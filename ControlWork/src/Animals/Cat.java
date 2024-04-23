

package Animals;

import Classes.Animal;
import Classes.PetAnimal;
import java.util.Date;

public class Cat extends PetAnimal {

    public Cat(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void playVoice() {
        System.out.println("Мяу-мяу!!!");
    }

    @Override
    public void giveFood() {

    }
}
