package Animals;

import Classes.PackAnimal;
import Classes.PetAnimal;

import java.util.Date;

public class Camel extends PackAnimal {
    public Camel(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void playVoice() {
        System.out.println("Тьфу!!!");
    }

    @Override
    public void giveFood() {

    }
}
