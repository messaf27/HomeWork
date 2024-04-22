package Animals;

import Classes.PackAnimal;
import Classes.PetAnimal;

import java.util.Date;

public class Horse extends PackAnimal {
    public Horse(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void palayVoice() {
        System.out.println("Иго-го!!!");
    }
}
