-- CREATE SCHEMA human_friends; 
-- SHOW DATABASES;
USE human_friends;

DROP TABLE IF EXISTS animals;
CREATE TABLE animals (
	id INT AUTO_INCREMENT PRIMARY KEY, 
	animal_type VARCHAR(20));
    
INSERT INTO animals (animal_type) 
VALUES 
	('PetAnimals'),
	('PackAnimals');  
SELECT * FROM animals;

DROP TABLE IF EXISTS pet_animals;
CREATE TABLE pet_animals(
	id INT AUTO_INCREMENT PRIMARY KEY,
    sub_type VARCHAR (20),
    sub_type_id INT,
    FOREIGN KEY (sub_type_id) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
    
INSERT INTO pet_animals (sub_type, sub_type_id) 
VALUES 
	('Cat', 1),
	('Dog', 1),  
	('Hamster', 1);  
SELECT * FROM pet_animals;    

DROP TABLE IF EXISTS pack_animals;
CREATE TABLE pack_animals(
	id INT AUTO_INCREMENT PRIMARY KEY,
    sub_type VARCHAR (20),
    sub_type_id INT,
    FOREIGN KEY (sub_type_id) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
    
INSERT INTO pack_animals (sub_type, sub_type_id) 
VALUES 
	('Camel', 2),
	('Horse', 2),  
	('Donkey', 2);  
SELECT * FROM pack_animals;   

CREATE TABLE cat (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pet_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
  
CREATE TABLE dog (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pet_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
  
CREATE TABLE hamster (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pet_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
  
CREATE TABLE camel (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
  
CREATE TABLE horse (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
  
CREATE TABLE donkey (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
  
  
-- Добавляем данные 
INSERT INTO cat (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Barsic', '2020-05-13', 'Voice, Go, Jump', 1),
	('Shurik', '2022-02-11', "Go, Run, Mur", 1),  
	('Vasya', '2019-11-02', "Jump, Go", 1);   
SELECT * FROM cat;

INSERT INTO dog (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Sharik', '2020-04-13', 'Voice, Jump', 1),
	('Losharik', '2022-03-11', "Go, Run, Gav-Gav", 1),  
	('Kuzya', '2019-11-01', "Jump", 1);   
SELECT * FROM dog;