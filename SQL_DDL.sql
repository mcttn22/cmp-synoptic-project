-- Table Definition
CREATE TABLE toilet_block(
	block_id SERIAL PRIMARY KEY,
	block_address VARCHAR(100) NOT NULL,
	block_status VARCHAR(15) DEFAULT 'Closed',
	toilet_count INTEGER DEFAULT 0,
	CHECK (toilet_count >= 0));

CREATE TABLE toilet(
	toilet_id SERIAL PRIMARY KEY,
	block_id INTEGER NOT NULL,
	toilet_status VARCHAR(15) DEFAULT 'Disabled',
	FOREIGN KEY (block_id) REFERENCES toilet_block ON DELETE CASCADE);

CREATE TABLE resident(
	res_id SERIAL PRIMARY KEY,
	username VARCHAR(32) NOT NULL,
	email TEXT NOT NULL,
	password TEXT NOT NULL);

CREATE TABLE farmer(
	farmer_id SERIAL PRIMARY KEY,
	res_id INTEGER,
	FOREIGN KEY (res_id) REFERENCES resident ON DELETE CASCADE);

CREATE TABLE report(
	report_id SERIAL PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email TEXT NOT NULL, 
	block_address VARCHAR(100) NOT NULL,
	description TEXT NOT NULL);

-- Adding a toilet
CREATE OR REPLACE FUNCTION add_toilet_func()
RETURNS TRIGGER AS $$
BEGIN
	UPDATE toilet_block
	SET toilet_count = toilet_count + 1
	WHERE toilet_block.block_id = NEW.block_id;
	RETURN NEW;
END;
$$
LANGUAGE PLPGSQL;

CREATE OR REPLACE TRIGGER add_toilet_trig
AFTER INSERT ON toilet
FOR EACH ROW
EXECUTE FUNCTION add_toilet_func();

-- Removing a toilet
CREATE OR REPLACE FUNCTION remove_toilet_func()
RETURNS TRIGGER AS $$
BEGIN
	UPDATE toilet_block
	SET toilet_count = toilet_count - 1
	WHERE toilet_block.block_id = OLD.block_id;
	RETURN OLD;
END;
$$
LANGUAGE PLPGSQL;

CREATE OR REPLACE TRIGGER remove_toilet_trig
AFTER DELETE ON toilet
FOR EACH ROW
EXECUTE FUNCTION remove_toilet_func();
