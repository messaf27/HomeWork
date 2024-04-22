package Animals;

import Classes.PetAnimal;

import java.util.Date;

public class Camel extends PetAnimal {
    public Camel(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void palayVoice() {
        System.out.println("Тьфу!!!");
    }
}