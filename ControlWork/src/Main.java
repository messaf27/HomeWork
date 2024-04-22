import Animals.Cat;
import Animals.Dog;
import Classes.Animal;
import Classes.Command;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.print("PetRegistr \r\n");

        Animal cat1 = new Cat( "Barsik", new Date());
        Animal cat2 = new Cat("Vasya", new Date());
        Animal dog1 = new Dog("Tuzik", new Date());
        Animal dog2 = new Dog("Sharik", new Date());

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(dog1);
        System.out.println(dog2);


        cat1.addNewCommand(Command.GO);
        cat1.addNewCommand(Command.STOP);

        dog1.addNewCommand(Command.COME_UP);
        dog2.addNewCommand(Command.JUMP);


        cat1.executeCommand(Command.GO);
//        dog1.executeCommand(Command.JUMP);

//        System.out.println(cat1.getCommandsList());
//        System.out.println(cat2.getCommandsList());
    }
}