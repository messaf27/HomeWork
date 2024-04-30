show databases;
USE sql6702277;

-- DROP DATABASE IF EXISTS HumanFriends;
-- CREATE DATABASE HumanFriends;
-- USE HumanFriends;

DROP TABLE IF EXISTS HumanFriends;
CREATE TABLE HumanFriends (
    AnimaTypeID INT NOT NULL PRIMARY KEY,
    AnimalTypeName VARCHAR(20)
);

INSERT INTO HumanFriends (AnimaTypeID, AnimalTypeName)
VALUES
    (1, 'Pet Animal'),
    (2, 'Pack Animal');
    
SELECT * FROM HumanFriends;     

DROP TABLE IF EXISTS PetCatecory;
CREATE TABLE PetCatecory(
	CategoryID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(20)
);

INSERT INTO PetCatecory (CategoryName)
VALUES
    ('CAT'),
    ('DOG'),
    ('HAMSTER');
SELECT * FROM PetCatecory;  

DROP TABLE IF EXISTS PackCatecory;
CREATE TABLE PackCatecory(
	CategoryID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    CategoryName VARCHAR(20)
);

INSERT INTO PackCatecory (CategoryName)
VALUES
    ('HORSE'),
    ('CAMEL'),
    ('DONKEY');
SELECT * FROM PackCatecory; 

DROP TABLE IF EXISTS PetAnimal;
CREATE TABLE PetAnimal (
    AnimaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    AnimaTypeID INT,
    CategoryID INT,
    AnimalName VARCHAR(20),
    AnimalDateBd DATE, 
    AnimalCommands VARCHAR(140),
    FOREIGN KEY (AnimaTypeID) REFERENCES HumanFriends(AnimaTypeID),
    FOREIGN KEY (CategoryID) REFERENCES PackCatecory(AnimaTypeID)
);

INSERT INTO PetAnimal (AnimaTypeID, AnimalName, AnimalDateBd, AnimalCommands)
VALUES
--     (1, 1, 'Barsik', '2020-08-11', 'GO, STOP, JUMP'),
--     (2, 1, 'Tuzic',  '2010-05-12', 'GO, STOP, VOICE, JUMP');
    (1, 'Barsik', '2020-08-11', 'GO, STOP, JUMP'),
    (1, 'Tuzic',  '2010-05-12', 'GO, STOP, VOICE, JUMP');
    
SELECT * FROM PetAnimal;    

DROP TABLE IF EXISTS PackAnimal;
CREATE TABLE PackAnimal (
    AnimaID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    AnimaTypeID INT,
    AnimalName VARCHAR(20),
    AnimalDateBd DATE, 
    AnimalCommands VARCHAR(140),
    FOREIGN KEY (AnimaTypeID) REFERENCES HumanFriends(AnimaTypeID)
);

INSERT INTO PackAnimal (AnimaTypeID, AnimalName, AnimalDateBd, AnimalCommands)
VALUES
    (2, 'Iskra', '2011-01-07', 'GO, STOP, JUMP'),
    (2, 'Valera', '2008-10-23', 'GO, STOP');

SELECT * FROM PackAnimal;    