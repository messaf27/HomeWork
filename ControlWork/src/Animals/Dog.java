package Animals;

import Classes.Animal;
import Classes.PetAnimal;

import java.util.Date;

public class Dog extends PetAnimal {

    public Dog(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void playVoice() {
        System.out.println("Гав-гав!!!");
    }

    @Override
    public void giveFood() {

    }
}
