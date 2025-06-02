-- Table Definition
CREATE TABLE toiletBlock(
	blockID INTEGER PRIMARY KEY,
	blockAddress VARCHAR(100) NOT NULL,
	blockStatus VARCHAR(15) DEFAULT 'Closed',
	toiletCount INTEGER DEFAULT 0,
	CHECK (toiletCount >= 0));

CREATE TABLE toilet(
	toiletID INTEGER PRIMARY KEY,
	blockID INTEGER NOT NULL,
	toiletStatus VARCHAR(15) DEFAULT 'Disabled',
	FOREIGN KEY (blockID) REFERENCES toiletBlock ON DELETE CASCADE);

CREATE TABLE resident(
	resID INTEGER PRIMARY KEY,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL,
	fullName VARCHAR(200) NOT NULL,
	address VARCHAR(100) NOT NULL);

CREATE TABLE farmer(
	farmerID INTEGER PRIMARY KEY,
	resID INTEGER,
	FOREIGN KEY (resID) REFERENCES resident);

-- Adding a toilet
CREATE OR REPLACE FUNCTION add_toilet_func()
RETURNS TRIGGER AS $$
BEGIN
	UPDATE toiletBlock
	SET toiletCount = toiletCount + 1
	WHERE toiletBlock.blockID = NEW.blockID;
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
	UPDATE toiletblock
	SET toiletCount = toiletCount - 1
	WHERE toiletblock.blockID = OLD.blockID;
	RETURN OLD;
END;
$$
LANGUAGE PLPGSQL;

CREATE OR REPLACE TRIGGER remove_toilet_trig
AFTER DELETE ON toilet
FOR EACH ROW
EXECUTE FUNCTION remove_toilet_func();
