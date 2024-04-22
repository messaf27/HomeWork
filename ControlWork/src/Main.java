import Animals.Cat;
import Animals.Dog;
import Animals.Horse;
import Classes.*;
import DataBase.InterfaceDataBase;
import DataBase.ListDataBase;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.print("PetRegistr \r\n");

        InterfaceDataBase db = new ListDataBase();

        Animal cat1 = new Cat( "Barsik", new Date());
        Animal cat2 = new Cat("Vasya", new Date());
        Animal dog1 = new Dog("Tuzik", new Date());
        Animal dog2 = new Dog("Sharik", new Date());
        Animal horse1 = new Horse("Iskra", new Date());

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(dog1);
        System.out.println(dog2);


        cat1.addNewCommand(Command.GO);
        cat1.addNewCommand(Command.STOP);

        dog1.addNewCommand(Command.COME_UP);
        dog2.addNewCommand(Command.JUMP);


        cat1.executeCommand(Command.GO);
        dog1.executeCommand(Command.JUMP);
        dog2.executeCommand(Command.JUMP);

        db.addAnimal(cat1);
        db.addAnimal(cat2);
        db.addAnimal(dog1);
        db.addAnimal(dog2);
        db.addAnimal(horse1);

        System.out.println(db);

    }
}