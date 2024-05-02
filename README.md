# Итоговая контрольная работа "Система учета для питомника, в котором живут домашние и вьючные животные"

### Операционные системы и виртуализация (Linux) ###

### 1. Использование команды cat в Linux
_Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов._

* Для начало создадим каталог, в котором будем работать:

```sh
root@telebotvpnserver:~# cd /home
root@telebotvpnserver:/home# mkdir HomeWork
root@telebotvpnserver:/home# cd HomeWork/
root@telebotvpnserver:/home/HomeWork#
```
* Создадим текстовый файл: "PetAnimals"(Домашние животные):
```sh
root@telebotvpnserver:/home/HomeWork# cat > PetAnimals
Cat
Dog
Hamster
```

* Создадим текстовый файл: "PackAnimals"(вьючные животные):
```sh
root@telebotvpnserver:/home/HomeWork# cat > PackAnimals
Horse
Camel
Donkey
```

_Объединить содержимое этих двух файлов в один и просмотреть его содержимое. Переименовать получившийся файл в "Human Friends"_

* Склеиваем файлы в новый файл командой `cat`:
```sh
root@telebotvpnserver:/home/HomeWork# cat PetAnimals PackAnimals > HumanFriends
```
* Просмотрим каталог:
```sh
root@telebotvpnserver:/home/HomeWork# ls -l
total 12
-rw-r--r-- 1 root root 35 May  2 20:38 HumanFriends
-rw-r--r-- 1 root root 19 May  2 20:35 PackAnimals
-rw-r--r-- 1 root root 16 May  2 20:34 PetAnimals
```
* Как видим - файл создан, теперь просмотрим его содержимое с помощью команды `cat`:
```sh
root@telebotvpnserver:/home/HomeWork# cat HumanFriends
Cat
Dog
Hamster
Horse
Camel
Donkey
```

### 2. Работа с директориями в Linux
_Создать новую директорию и переместить туда файл "Human Friends"._

* Создаем дирректорию (каталог) с помощью команды `mkdir`:
```sh
root@telebotvpnserver:/home/HomeWork# mkdir NewDirectory
```
* Проверяем:
```sh
root@telebotvpnserver:/home/HomeWork# ls -l
total 16
-rw-r--r-- 1 root root   35 May  2 20:38 HumanFriends
drwxr-xr-x 2 root root 4096 May  2 20:48 NewDirectory
-rw-r--r-- 1 root root   19 May  2 20:35 PackAnimals
-rw-r--r-- 1 root root   16 May  2 20:34 PetAnimals
```

* Переносим каталог "HumanFriends" в новую дирректорию с помощью команды `mv` и проверям результат:
```sh
root@telebotvpnserver:/home/HomeWork# mv HumanFriends NewDirectory
root@telebotvpnserver:/home/HomeWork# ls -l
total 12
drwxr-xr-x 2 root root 4096 May  2 20:51 NewDirectory
-rw-r--r-- 1 root root   19 May  2 20:35 PackAnimals
-rw-r--r-- 1 root root   16 May  2 20:34 PetAnimals

root@telebotvpnserver:/home/HomeWork# cd NewDirectory/
root@telebotvpnserver:/home/HomeWork/NewDirectory# ls -l
total 4
-rw-r--r-- 1 root root 35 May  2 20:38 HumanFriends

root@telebotvpnserver:/home/HomeWork/NewDirectory# cat HumanFriends
Cat
Dog
Hamster
Horse
Camel
Donkey
```

### 3. Управление deb-пакетами
   _Установить и затем удалить deb-пакет, используя команду `dpkg`._

* Скачмваем пакет с помощью команды `wget`:
```sh
root@telebotvpnserver:~# wget https://dev.mysql.com/get/mysql-apt-config_0.8.25-1_all.deb
--2024-05-02 21:22:32--  https://dev.mysql.com/get/mysql-apt-config_0.8.25-1_all.deb
Resolving dev.mysql.com (dev.mysql.com)... 23.38.27.41, 2a02:26f0:6b:180::2e31, 2a02:26f0:6b:1b3::2e31
Connecting to dev.mysql.com (dev.mysql.com)|23.38.27.41|:443... connected.
HTTP request sent, awaiting response... 302 Moved Temporarily
Location: https://repo.mysql.com//mysql-apt-config_0.8.25-1_all.deb [following]
--2024-05-02 21:22:32--  https://repo.mysql.com//mysql-apt-config_0.8.25-1_all.deb
Resolving repo.mysql.com (repo.mysql.com)... 23.201.249.199, 2a02:26f0:6b:183::1d68, 2a02:26f0:6b:18e::1d68
Connecting to repo.mysql.com (repo.mysql.com)|23.201.249.199|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: 18120 (18K) [application/x-debian-package]
Saving to: ‘mysql-apt-config_0.8.25-1_all.deb.1’

mysql-apt-config_0.8.25-1_a 100%[===========================================>]  17.70K  --.-KB/s    in 0s

2024-05-02 21:22:32 (56.9 MB/s) - ‘mysql-apt-config_0.8.25-1_all.deb.1’ saved [18120/18120]
```
* Устанавливаем:

```sh
root@telebotvpnserver:~# dpkg -i mysql-apt-config_0.8.25-1_all.deb

 ┌──────────────────────────────────────Configuring mysql-apt-config────────────────────────────────────────┐
 │ MySQL APT Repo features MySQL Server along with a variety of MySQL components. You may select the        │
 │ appropriate product to choose the version that you wish to receive.                                      │
 │                                                                                                          │
 │ Once you are satisfied with the configuration then select last option 'Ok' to save the configuration,    │
 │ then run 'apt-get update' to load package list. Advanced users can always change the configurations      │
 │ later, depending on their own needs.                                                                     │
 │                                                                                                          │
 │ Which MySQL product do you wish to configure?                                                            │
 │ ┌──────────────────────────────────────────────────────────────────────────────────────────────────────┐ │
 │ │                       MySQL Server & Cluster (Currently selected: mysql-5.7)                         │ │
 │ │                       MySQL Tools & Connectors (Currently selected: Enabled)                         │ │
 │ │                       MySQL Preview Packages (Currently selected: Disabled)                          │ │
 │ │                       Ok                                                                             │ │
 │ └──────────────────────────────────────────────────────────────────────────────────────────────────────┘ │
 ├──────────────────────────────────────────────────────────────────────────────────────────────────────────┤
 │                                                 <  OK  >                                                 │
 └──────────────────────────────────────────────────────────────────────────────────────────────────────────┘
```
* Нажимаем "ОК", далее обновляем репозиторий:
```sh
root@telebotvpnserver:~# sudo apt update
....
```
* Устанавливаем MySQL из репозитория:
```sh
root@telebotvpnserver:~# apt install mysql-server
....
```
* Далее можно удалить mysql-server - удобнее работать в контейнере
```sh
root@telebotvpnserver:~# apt remove mysql-server
....
```
### Объектно-ориентированное программирование  ###
* Диаграмма классов сделана в IDE IntelliJ IDEA 2024.1

![Diagram](https://github.com/messaf27/HomeWork/blob/main/AnimalsAppJava/Диаграмма%20классов.PNG?raw=true).

* Далее разработка приложения велась по одному из принятому паттерну `MVC (Model-View-Controller)`.

__*Весь проект приложения выложен по ссылке [AnimalsAppJava/AnimalsApp/src](https://github.com/messaf27/HomeWork/tree/main/AnimalsAppJava/AnimalsApp/src), точка входа в файле scr/Main.java*__ 

```java
import UI.App;

public class Main {
    public static void main(String[] args) {

        App app = new App();
        boolean result = app.run();

        System.out.printf(
                "Приложение завершилось %s\r\n",
                result ? "без ошибок" : "с ошибкой!");
    }

}
```

* База данных выполнена в виде файла `AnimalsAppJava/AnimalsApp/dataBase.db` ([dataBase.db](https://github.com/messaf27/HomeWork/blob/main/AnimalsAppJava/AnimalsApp/dataBase.db))

```
PetAnimals, Hamster, Чика, 13-02-2020, [Спать,Жрать,Бегать]
PetAnimals, Cat, Вася, 12-12-2020, [Голос,Прыгнуть,Брысь]
PackAnimals, Donkey, Эдик, 15-06-2018, [Быстрее,Сидеть,Лежать]
PackAnimals, Camel, Боря, 17-12-2019, [Плюнуть]
```
* Файл бызы данных подключается через класс-интерфейс в файле `AnimalsAppJava/AnimalsApp/src/UI/App.java` ([App.java](https://github.com/messaf27/HomeWork/blob/main/AnimalsAppJava/AnimalsApp/src/UI/App.java)): 
```java
package UI;

import DataBase.FileDataBase;
import DataBase.ListDataBase;
import MVP.Model;
import MVP.Presenter;
import MVP.View;

import java.util.function.Predicate;

public class App {
    public boolean run(){
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
//        Model model = new Model(new ListDataBase("Друзья человека"));
        Model model = new Model(new FileDataBase("dataBase.db", "Друзья человека"));
        Presenter presenter = new Presenter(model, view);
        return presenter.startUserInterface();
    }
}
```

* Вся основная работа приложения осуществляется в файле `AnimalsAppJava/AnimalsApp/src/MVP/Presenter.java` ([Presenter.java](https://github.com/messaf27/HomeWork/blob/main/AnimalsAppJava/AnimalsApp/src/MVP/Presenter.java)): 

```java
ackage MVP;

import Animals.*;
import UI.Menu;
import UI.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class Presenter {
    private Model model;
    private View view;

    private final Menu main = new Menu(Arrays.asList(
            new MenuItem("Прочитать базу данных", 1),
            new MenuItem("Добавить животное", 2),
            new MenuItem("Удалить животное", 3),
            new MenuItem("Выход", 4)
    ));

    private final Menu selectAddAnimals = new Menu(Arrays.asList(
            new MenuItem("Добавить домашнее животное", 1),
            new MenuItem("Добавить вьючное животное", 2)
    )
    );

    private final Menu selectAddPetAnimal = new Menu(Arrays.asList(
            new MenuItem("Кот", 1),
            new MenuItem("Собака", 2),
            new MenuItem("Хомяк", 3),
            new MenuItem("Отменить добавление", 4)
    ));

    private final Menu selectAddPackAnimal = new Menu(Arrays.asList(
            new MenuItem("Лошадь", 1),
            new MenuItem("Осёл", 2),
            new MenuItem("Верблюд", 3),
            new MenuItem("Отменить добавление", 4)
    ));

    private final Menu confirmRequestYesNo = new Menu(Arrays.asList(
            new MenuItem("Да", 1),
            new MenuItem("Нет", 2)
    ));


    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public boolean startUserInterface()
    {
        boolean dbIsOpen = model.getCurrentDataBase().open();
        while(true)
        {
            if(!dbIsOpen) {
                view.displayResultMessage("Невозможно открыть базу данных!");
                return false;
            }
            view.displayMenu(
                    String.format("База данных \"%s\" содержет %d животных",
                            model.getCurrentDataBase().getName(),
                    model.getCurrentDataBase().getNumOfAnimals()),
                    main);

            int selectedItem = view.getSelectedMenuItem();

            if(selectedItem == 4) {
                return this.exit();
            }else if (selectedItem > 0 && selectedItem < main.getNumItems()) {
                switch (selectedItem)
                {
                    case 1 ->{
                        view.displayDataBase(model.getCurrentDataBase());
                    }

                    case 2 ->{
                        view.displayMenu("Выберете тип животного:",
                                selectAddAnimals);

                        Animal animal = null;
                        switch (view.getSelectedMenuItem()){
                            case 1 ->{
                                view.displayMenu("Выберете вид домашнего животного:",
                                        selectAddPetAnimal);

                                int selected = view.getSelectedMenuItem();
                                switch (selected){
                                    case 1,2,3->{
                                        switch (selected){
                                            case 1 ->{
                                                animal = new Cat(view.getName(), view.getBirthday());
                                            }
                                            case 2 ->{
                                                animal = new Dog(view.getName(), view.getBirthday());
                                            }
                                            case 3 ->{
                                                animal = new Hamster(view.getName(), view.getBirthday());
                                            }
                                        }
                                        animal.addCommands(addCommandMenu());
                                        model.getCurrentDataBase().addAnimal(animal);
                                    }
                                    case 4 -> {break;}
                                }
                            }

                            case 2 ->{
                                view.displayMenu("Выберете вид вьючного животного:",
                                        selectAddPackAnimal);
                                int selected = view.getSelectedMenuItem();
                                switch (selected){
                                    case 1,2,3->{
                                        switch (selected){
                                            case 1 ->{
                                                animal = new Horse(view.getName(), view.getBirthday());
                                            }
                                            case 2 ->{
                                                animal = new Donkey(view.getName(), view.getBirthday());
                                            }
                                            case 3 ->{
                                                animal = new Camel(view.getName(), view.getBirthday());
                                            }
                                        }
                                        animal.addCommands(addCommandMenu());
                                        model.getCurrentDataBase().addAnimal(animal);
                                    }
                                    case 4 -> {break;}
                                }
                            }
                            case 4 -> {break;}

                        }
                    }

                    case 3->{
                        int deleteId = view.getId();
                        if(model.getCurrentDataBase().getAnimalFromId(deleteId) != null)
                        {
                            view.displayMenu(
                                    String.format("Вы действительно хотите удалить? :\n %s",
                                            model.getCurrentDataBase().getAnimalFromId(deleteId)),
                                    confirmRequestYesNo
                            );
                        }else {
                            view.displayResultMessage(String.format("ID: %d не найден в базе", deleteId));
                            break;
                        }

                        if(view.getSelectedMenuItem() == 1)
                        {
                            if(model.getCurrentDataBase().removeAnimal(deleteId))
                                view.displayResultMessage("Животное успешно удалено!");
                            else
                                view.displayResultMessage("Ошибка удаления");
                        }else{
                            view.displayResultMessage("Отмена удаления");
                        }
                    }
                }
            }
        }
    }

    public boolean exit()
    {
        view.exit();
        return model.getCurrentDataBase().close();
    }

    private ArrayList<String> addCommandMenu()
    {
        String command = "";
        ArrayList<String> commands = new ArrayList<>();
        while (true)
        {
            view.displayMenu("Добавить команду?", confirmRequestYesNo);
            if(view.getSelectedMenuItem() == 2)
                break;
            commands.add(view.getCommand());
            view.displayResultMessage("Команда добавлена");
        }
        return commands;
    }
}
```
* Взаимодействие с пользоваиелем выполнено в консольном варианте:

```
=============================================================
База данных "Друзья человека (dataBase.db)" содержет 4 животных
-------------------------------------------------------------
[1] Прочитать базу данных
[2] Добавить животное
[3] Удалить животное
[4] Выход
=============================================================
Выберете пункт меню от 1 до 4: 1

----- dataBase.db ------
Домашние животные (2):
[ID: 1] Имя: Чика, Дата рождения: 13-02-2020, Команды: Спать, Жрать, Бегать
[ID: 2] Имя: Вася, Дата рождения: 12-12-2020, Команды: Голос, Прыгнуть, Брысь
Вьючные животные (2):
[ID: 3] Имя: Эдик, Дата рождения: 15-06-2018, Команды: Быстрее, Сидеть, Лежать
[ID: 4] Имя: Боря, Дата рождения: 17-12-2019, Команды: Плюнуть

----- Конец базы данных ------

=============================================================
База данных "Друзья человека (dataBase.db)" содержет 4 животных
-------------------------------------------------------------
[1] Прочитать базу данных
[2] Добавить животное
[3] Удалить животное
[4] Выход
=============================================================
Выберете пункт меню от 1 до 4: 4
-------------------------------------------------------------
-------------------------------------------------------------
Выход из приложения.
-------------------------------------------------------------
Приложение завершилось без ошибок

Process finished with exit code 0
```

### Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”
> Примечание: на практике мной использовался уже рабочий VDS сервер (выполняющий мои задачи) работающий на ОС Debian 4.19.304-1:
```sh
root@telebotvpnserver:~# uname -a
Linux telebotvpnserver 4.19.0-26-amd64 #1 SMP Debian 4.19.304-1 (2024-01-09) x86_64 GNU/Linux
```
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
>***horse***
```sql
INSERT INTO horse (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Iskra', '2012-02-09', 'Go, Stop, Jump', 2),
	('Zvezda', '2013-08-22', 'Go, Stop', 2),  
	('Masha', '2019-11-01', "Jump, Voice", 2);   

SELECT * FROM horse;
+----+--------+------------+----------------+-------------+
| id | Name   | Birthday   | Commands       | sub_type_id |
+----+--------+------------+----------------+-------------+
|  1 | Iskra  | 2012-02-09 | Go, Stop, Jump |           2 |
|  2 | Zvezda | 2013-08-22 | Go, Stop       |           2 |
|  3 | Masha  | 2019-11-01 | Jump, Voice    |           2 |
+----+--------+------------+----------------+-------------+
```
>***donkey***
```sql
INSERT INTO donkey (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Volodya', '2000-04-11', 'Tifoo', 2),
	('Valera', '2013-08-22', 'Go, Stop', 2),  
	('Gennadich', '2019-11-01', "Sleep", 2);   

SELECT * FROM donkey;
+----+-----------+------------+----------+-------------+
| id | Name      | Birthday   | Commands | sub_type_id |
+----+-----------+------------+----------+-------------+
|  1 | Volodya   | 2000-04-11 | Tifoo    |           2 |
|  2 | Valera    | 2013-08-22 | Go, Stop |           2 |
|  3 | Gennadich | 2019-11-01 | Sleep    |           2 |
+----+-----------+------------+----------+-------------+

```
>***camel***
```sql
INSERT INTO camel (Name, Birthday, Commands, sub_type_id) 
  VALUES 
	('Gosha', '2010-11-11', 'Tifoo, Jump', 2),
	('Ivanych', '2013-08-20', 'Dance, Round, Stop', 2),  
	('Vitek', '2014-09-17', "Seat, Trash", 2);   

SELECT * FROM camel;
+----+---------+------------+--------------------+-------------+
| id | Name    | Birthday   | Commands           | sub_type_id |
+----+---------+------------+--------------------+-------------+
|  1 | Gosha   | 2010-11-11 | Tifoo, Jump        |           2 |
|  2 | Ivanych | 2013-08-20 | Dance, Round, Stop |           2 |
|  3 | Vitek   | 2014-09-17 | Seat, Trash        |           2 |
+----+---------+------------+--------------------+-------------+
```

>* Далее в соответствии с заданием нужно _***"удалить записи о верблюдах и объединить таблицы лошадей и ослов"***_.
* Удаляем данные о верблюдах в соответствующей таблице:
```sql
DELETE FROM camel;
SELECT * FROM camel;
Empty set (0.00 sec)
```
* Объединяем лошадeй, и ослов в одну таблицу:
```sql
SELECT * FROM horse
UNION
SELECT * FROM donkey;
+----+-----------+------------+----------------+-------------+
| id | Name      | Birthday   | Commands       | sub_type_id |
+----+-----------+------------+----------------+-------------+
|  1 | Iskra     | 2012-02-09 | Go, Stop, Jump |           2 |
|  2 | Zvezda    | 2013-08-22 | Go, Stop       |           2 |
|  3 | Masha     | 2019-11-01 | Jump, Voice    |           2 |
|  1 | Volodya   | 2000-04-11 | Tifoo          |           2 |
|  2 | Valera    | 2013-08-22 | Go, Stop       |           2 |
|  3 | Gennadich | 2019-11-01 | Sleep          |           2 |
+----+-----------+------------+----------------+-------------+
```
* Создаем новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца:
```sql
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

CREATE TABLE young_age
SELECT Id, Name, Birthday, Commands, sub_type_id, TIMESTAMPDIFF(MONTH, Birthday, CURDATE()) AS Age_months
FROM all_animals
WHERE Birthday BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

SELECT * FROM young_age;
+----+----------+------------+------------------+-------------+------------+
| Id | Name     | Birthday   | Commands         | sub_type_id | Age_months |
+----+----------+------------+------------------+-------------+------------+
|  2 | Losharik | 2022-03-11 | Go, Run, Gav-Gav |           1 |         25 |
|  2 | Shurik   | 2022-02-11 | Go, Run, Mur     |           1 |         26 |
|  1 | Pusik    | 2023-01-13 | Sleep, Jump      |           1 |         15 |
+----+----------+------------+------------------+-------------+------------+

```
* Объединяем все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам:
```sql
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
+-----------+------------+------------------+----------+
| Name      | Birthday   | Commands         | sub_type |
+-----------+------------+------------------+----------+
| Iskra     | 2012-02-09 | Go, Stop, Jump   | Horse    |
| Zvezda    | 2013-08-22 | Go, Stop         | Horse    |
| Masha     | 2019-11-01 | Jump, Voice      | Horse    |
| Volodya   | 2000-04-11 | Tifoo            | Horse    |
| Valera    | 2013-08-22 | Go, Stop         | Horse    |
| Gennadich | 2019-11-01 | Sleep            | Horse    |
| Barsic    | 2020-05-13 | Voice, Go, Jump  | Cat      |
| Shurik    | 2022-02-11 | Go, Run, Mur     | Cat      |
| Vasya     | 2019-11-02 | Jump, Go         | Cat      |
| Sharik    | 2020-04-13 | Voice, Jump      | Cat      |
| Losharik  | 2022-03-11 | Go, Run, Gav-Gav | Cat      |
| Kuzya     | 2019-11-01 | Jump             | Cat      |
| Pusik     | 2023-01-13 | Sleep, Jump      | Cat      |
| Koshmarik | 2024-01-12 | Run, Fyr-Fyr     | Cat      |
| Lusya     | 2019-11-01 | Go               | Cat      |
+-----------+------------+------------------+----------+

```