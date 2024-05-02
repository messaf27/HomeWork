# Итоговая контрольная работа "Система учета для питомника, в котором живут домашние и вьючные животные"

### Задача 1. Работа с файлами через терминал Linux
* Используя команду cat в терминале операционной системы Linux, создать два файла **Домашние животные** (заполнив файл собаками, кошками, хомяками) и **Вьючные животными** заполнив файл Лошадьми, верблюдами и ослы), а затем объединить их.*

```sh
:~$ mkdir 'Итоговая контрольная работа'
:~$ cd 'Итоговая контрольная работа'
```


### Задача 2. Работа с MySQL
* Устанавливаем контейнер MySQL с помощью Docker:
```sh
root@telebotvpnserver:~# sudo docker run -h $HOSTNAME --name mydb-mysql -e MYSQL_ROOT_PASSWORD=123 -d mysql:latest
```
* Заходим в контейнер и подключаемся к MySQL:
```sh
root@telebotvpnserver:~# docker exec -it mydb-mysql bash
bash-4.4# mysql -u root -p
Enter password:
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.4.0 MySQL Community Server - GPL

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>
```
* Создаем базу данных "human_friends":
```sql
CREATE SCHEMA human_friends;
```
* Просматриваем результат:
```sql
SHOW DATABASES;
+--------------------+
| Database           |
+--------------------+
| human_friends      |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
```
Видим, что бада данных успешна создана.

* Выбираем созданную базу для дальнейшей работы с ней:
```sql
USE human_friends;
```

* Начинаем наполнять базу таблицами в соответствии с диаграммой классов.
* Создаем таблицу _"animals"_
```sql
CREATE TABLE animals 
(
	id INT AUTO_INCREMENT PRIMARY KEY, 
	animal_type VARCHAR(20)
);
```
* Заполняем данными:
```sql
INSERT INTO animals (animal_type) 
VALUES 
	('PetAnimals'),
	('PackAnimals');
  ```  
* Проверяем: 
```sql 
SELECT * FROM animals;
+----+-------------+
| id | animal_type |
+----+-------------+
|  1 | PetAnimals  |
|  2 | PackAnimals |
+----+-------------+
```
* Создаем таблицу _"pet_animals"_
```sql
CREATE TABLE pet_animals(
	id INT AUTO_INCREMENT PRIMARY KEY,
    sub_type VARCHAR (20),
    sub_type_id INT,
    FOREIGN KEY (sub_type_id) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Заполняем данными:
```sql
INSERT INTO pet_animals (sub_type, sub_type_id) 
VALUES 
	('Cat', 1),
	('Dog', 1),  
	('Hamster', 1);    
  ```  
* Проверяем: 
```sql 
SELECT * FROM pet_animals; 
+----+----------+-------------+
| id | sub_type | sub_type_id |
+----+----------+-------------+
|  1 | Cat      |           1 |
|  2 | Dog      |           1 |
|  3 | Hamster  |           1 |
+----+----------+-------------+
```
* Создаем таблицу _"pack_animals"_
```sql
CREATE TABLE pack_animals(
	id INT AUTO_INCREMENT PRIMARY KEY,
    sub_type VARCHAR (20),
    sub_type_id INT,
    FOREIGN KEY (sub_type_id) REFERENCES animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Заполняем данными:
```sql
INSERT INTO pack_animals (sub_type, sub_type_id) 
VALUES 
	('Camel', 2),
	('Horse', 2),  
	('Donkey', 2);   
  ```  
* Проверяем: 
```sql 
SELECT * FROM pet_animals;   
+----+----------+-------------+
| id | sub_type | sub_type_id |
+----+----------+-------------+
|  1 | Camel    |           2 |
|  2 | Horse    |           2 |
|  3 | Donkey   |           2 |
+----+----------+-------------+
```
* Далее будут создаваться таблици классов самих видов животных.
* Создаем таблицу _"cat"_
```sql
CREATE TABLE cat (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pet_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Создаем таблицу _"dog"_
```sql
CREATE TABLE dog (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pet_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Создаем таблицу _"hamster"_
```sql
CREATE TABLE hamster (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pet_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Создаем таблицу _"camel"_
```sql
CREATE TABLE camel (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Создаем таблицу _"horse"_
```sql
CREATE TABLE horse (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Создаем таблицу _"donkey"_
```sql
CREATE TABLE donkey (
  id INT AUTO_INCREMENT PRIMARY KEY, 
  Name VARCHAR(20), 
  Birthday DATE,
  Commands VARCHAR(50),
  sub_type_id INT,
  FOREIGN KEY (sub_type_id) REFERENCES pack_animals (id) ON DELETE CASCADE ON UPDATE CASCADE);
```
* Теперь можно проверить наличие созданных таблиц:
```sql
SHOW TABLES;
+-------------------------+
| Tables_in_human_friends |
+-------------------------+
| animals                 |
| camel                   |
| cat                     |
| dog                     |
| donkey                  |
| hamster                 |
| horse                   |
| pack_animals            |
| pet_animals             |
+-------------------------+
```
* Далее наполняем данными созданные таблицы (имя, дата рождения, знание команд) и проверяем:
>***cat***
```sql
INSERT INTO cat (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Barsic', '2020-05-13', 'Voice, Go, Jump', 1),
	('Shurik', '2022-02-11', "Go, Run, Mur", 1),  
	('Vasya', '2019-11-02', "Jump, Go", 1);   

SELECT * FROM cat;
+----+--------+------------+-----------------+-------------+
| id | Name   | Birthday   | Commands        | sub_type_id |
+----+--------+------------+-----------------+-------------+
|  1 | Barsic | 2020-05-13 | Voice, Go, Jump |           1 |
|  2 | Shurik | 2022-02-11 | Go, Run, Mur    |           1 |
|  3 | Vasya  | 2019-11-02 | Jump, Go        |           1 |
+----+--------+------------+-----------------+-------------+
```
>***dog***
```sql
INSERT INTO dog (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Sharik', '2020-04-13', 'Voice, Jump', 1),
	('Losharik', '2022-03-11', "Go, Run, Gav-Gav", 1),  
	('Kuzya', '2019-11-01', "Jump", 1);   

SELECT * FROM dog;
+----+----------+------------+------------------+-------------+
| id | Name     | Birthday   | Commands         | sub_type_id |
+----+----------+------------+------------------+-------------+
|  1 | Sharik   | 2020-04-13 | Voice, Jump      |           1 |
|  2 | Losharik | 2022-03-11 | Go, Run, Gav-Gav |           1 |
|  3 | Kuzya    | 2019-11-01 | Jump             |           1 |
+----+----------+------------+------------------+-------------+
```
>***hamster***
```sql
INSERT INTO hamster (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Pusik', '2023-01-13', 'Sleep, Jump', 1),
	('Koshmarik', '2024-01-12', "Run, Fyr-Fyr", 1),  
	('Lusya', '2019-11-01', "Go", 1);  
   
SELECT * FROM hamster;
+----+-----------+------------+--------------+-------------+
| id | Name      | Birthday   | Commands     | sub_type_id |
+----+-----------+------------+--------------+-------------+
|  1 | Pusik     | 2023-01-13 | Sleep, Jump  |           1 |
|  2 | Koshmarik | 2024-01-12 | Run, Fyr-Fyr |           1 |
|  3 | Lusya     | 2019-11-01 | Go           |           1 |
+----+-----------+------------+--------------+-------------+

```