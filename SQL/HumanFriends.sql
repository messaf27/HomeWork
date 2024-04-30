show databases;
USE sql6702277;

-- DROP DATABASE IF EXISTS HumanFriends;
-- CREATE DATABASE HumanFriends;
-- USE HumanFriends;

-- DROP TABLE IF EXISTS HumanFriends;
-- CREATE TABLE HumanFriends (
--     id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
--     animal_type VARCHAR(12)
-- );

DROP TABLE IF EXISTS PetAnimal;
CREATE TABLE PetAnimal (
    animal_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    animal_type VARCHAR(20),
    animal_name VARCHAR(20),
    aninal_bd_date DATE, 
    animal_commands VARCHAR(140)
    -- FOREIGN KEY (animal_id) REFERENCES HumanFriends(id)
);

INSERT INTO PetAnimal (animal_type, animal_name, aninal_bd_date, animal_commands)
VALUES
    ('CAT','Barsik', '2020-08-11', 'GO, STOP, JUMP'),
    ('DOG','Tuzic',  '2010-05-12', 'GO, STOP, VOICE, JUMP');
    
SELECT * FROM PetAnimal;    

DROP TABLE IF EXISTS PackAnimal;
CREATE TABLE PackAnimal (
    animal_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	animal_type VARCHAR(20),
    animal_name VARCHAR(20),
    aninal_bd_date DATE, 
    animal_commands VARCHAR(140)
    -- FOREIGN KEY (animal_id) REFERENCES HumanFriends(id)
);

INSERT INTO PackAnimal (animal_type, animal_name, aninal_bd_date, animal_commands)
VALUES
    ('HORSE', 'Barsik', '2011-01-07', 'GO, STOP, JUMP'),
    ('CAMEL', 'Tuzic', '2008-10-23', 'GO, STOP');

SELECT * FROM HumanFriends;