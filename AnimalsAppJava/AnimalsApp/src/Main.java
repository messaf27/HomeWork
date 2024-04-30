import Animals.Animal;
import Animals.Cat;
import Animals.Horse;
import DataBase.InterfaceDataBase;
import DataBase.ListDataBase;
import DataBase.MySQLDataBase;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InterfaceDataBase animalDB = new ListDataBase("Human Friends");

        Animal cat1 = new Cat("Barsik", "11-12-2010");
        cat1.addCommand("Go");

        Animal cat2 = new Cat("Vasya", "13-05-2023");
        cat2.addCommand("Jump");

        Animal horse1 = new Horse("Iskra", "18-10-2020");
        horse1.addCommand("Stop");
        horse1.addCommand("Go");
        horse1.addCommand("Sleep");

        animalDB.addAnimal(cat1);
        animalDB.addAnimal(cat2);
        animalDB.addAnimal(horse1);

        System.out.println(animalDB);
    }
}
