package Animals;

import Classes.PetAnimal;

import java.util.Date;

public class Hamster extends PetAnimal {
    public Hamster(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void palayVoice() {
        System.out.println("Фыр-фыр!!!");
    }
}
