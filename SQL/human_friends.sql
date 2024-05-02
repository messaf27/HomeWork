CREATE SCHEMA human_friends; 
SHOW DATABASES;
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

INSERT INTO hamster (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Pusik', '2023-01-13', 'Sleep, Jump', 1),
	('Koshmarik', '2024-01-12', "Run, Fyr-Fyr", 1),  
	('Lusya', '2019-11-01', "Go", 1);   
SELECT * FROM hamster;

INSERT INTO horse (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Iskra', '2012-02-09', 'Go, Stop, Jump', 2),
	('Zvezda', '2013-08-22', 'Go, Stop', 2),  
	('Masha', '2019-11-01', "Jump, Voice", 2);   
SELECT * FROM horse;

INSERT INTO donkey (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Volodya', '2000-04-11', 'Tifoo', 2),
	('Valera', '2013-08-22', 'Go, Stop', 2),  
	('Gennadich', '2019-11-01', "Sleep", 2);   
SELECT * FROM donkey;

INSERT INTO camel (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Gosha', '2010-11-11', 'Tifoo, Jump', 2),
	('Ivanych', '2013-08-20', 'Dance, Round, Stop', 2),  
	('Vitek', '2014-09-17', "Seat, Trash", 2);   
SELECT * FROM camel;


-- SET SQL_SAFE_UPDATES = 0;
DELETE FROM camel;
SELECT * FROM camel;

CREATE VIEW all_animals AS
SELECT * FROM horse
UNION
SELECT * FROM donkey
UNION
SELECT * FROM dog
UNION
SELECT * FROM cat
UNION
SELECT * FROM hamster;

DROP TABLE IF EXISTS young_age;
CREATE TABLE young_age
SELECT Id, Name, Birthday, Commands, sub_type_id, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_months
FROM all_animals
WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
SELECT * FROM young_age;


--
SELECT hr.Name, hr.Birthday, hr.Commands, pkan.sub_type
FROM horse hr
LEFT JOIN young_age yng ON yng.Name = hr.Name
LEFT JOIN pack_animals pkan ON pkan.Id = hr.sub_type_id
UNION 
SELECT dnk.Name, dnk.Birthday, dnk.Commands, pkan.sub_type
FROM donkey dnk
LEFT JOIN young_age yng ON yng.Name = dnk.Name
LEFT JOIN pack_animals pkan ON pkan.Id = dnk.sub_type_id
UNION
SELECT ct.Name, ct.Birthday, ct.Commands, ptan.sub_type
FROM cat ct
LEFT JOIN young_age yng ON yng.Name = ct.Name
LEFT JOIN pet_animals ptan ON ptan.Id = ct.sub_type_id
UNION
SELECT dg.Name, dg.Birthday, dg.Commands, ptan.sub_type
FROM dog dg
LEFT JOIN young_age yng ON yng.Name = dg.Name
LEFT JOIN pet_animals ptan ON ptan.Id = dg.sub_type_id
UNION
SELECT hmr.Name, hmr.Birthday, hmr.Commands, ptan.sub_type
FROM hamster hmr
LEFT JOIN young_age yng ON yng.Name = hmr.Name
LEFT JOIN pet_animals ptan ON ptan.Id = hmr.sub_type_id;
