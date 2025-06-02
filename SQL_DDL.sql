SET search_path TO 'synop25', public;

CREATE TABLE toiletBlock(
	blockID INTEGER PRIMARY KEY,
	blockAddress VARCHAR(100) NOT NULL,
	toiletCount INTEGER,
	blockStatus VARCHAR(15) DEFAULT 'Closed');

CREATE TABLE toilet(
	toiletID INTEGER PRIMARY KEY,
	blockID INTEGER NOT NULL,
	toiletStatus VARCHAR(15) DEFAULT 'Disabled',
	FOREIGN KEY (blockID) REFERENCES toiletBlock);

CREATE TABLE resident(
	resID INTEGER PRIMARY KEY,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL,
	fullName VARCHAR(200) NOT NULL,
	address VARCHAR(100) NOT NULL);

CREATE TABLE farmer(
	farmerID INTEGER PRIMARY KEY,
	resID INTEGER,
	username VARCHAR(32) NOT NULL,
	password VARCHAR(32) NOT NULL,
	FOREIGN KEY (resID) REFERENCES resident);
