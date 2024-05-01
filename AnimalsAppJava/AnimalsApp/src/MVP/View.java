package MVP;

import Animals.Animal;
import DataBase.InterfaceDataBase;
import DataBase.MySQLDataBase;
import UI.Menu;

public interface View {
    void displayMenu(String title, Menu menu);
    int getSelectedMenuItem();
    void displayAnimal(Animal animal);
    void displayDataBase(InterfaceDataBase db);
    void displayResultMessage(String message);

    int getId();
    String getCommand();
    String getName();
    String getBirthday();
    void exit();
}
