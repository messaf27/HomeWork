package MVP;

import Animals.Animal;
import UI.Menu;

public interface View {
    void displayUserMenu(String title, Menu menu);
    String getName();
    void setName(String name);
    String getBirthday();
    void setBirthday(String date);
    void displayAnimal(Animal animal);

}
