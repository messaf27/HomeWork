import Animals.Cat;
import Classes.Animal;
import Classes.Command;

import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        System.out.print("PetRegistr \r\n");

        Animal cat1 = new Cat(1, new Date());
        Animal cat2 = new Cat(2, new Date());

        cat1.setName("Barsik");
        cat2.setName("Vasya");

        System.out.println(cat1);
        System.out.println(cat2);

        cat1.addCommand(Command.GO);
        cat1.addCommand(Command.STOP);
        System.out.println(cat1.getList());
        cat1.executeCommand(Command.GO);

//        System.out.println(cat1.getCommandsList());
//        System.out.println(cat2.getCommandsList());
    }
}