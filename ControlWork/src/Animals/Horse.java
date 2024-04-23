package Animals;

import Classes.PackAnimal;
import java.util.Date;

public class Horse extends PackAnimal {
    public Horse(String name, Date birthday) {
        super(name, birthday);
    }

    @Override
    public void playVoice() {
        System.out.println("Иго-го!!!");
    }

    @Override
    public void giveFood() {

    }
}
