package Classes;

import Classes.PetCommands;
import java.util.Date;

public abstract class Animal extends PetCommands {
    static int id;
    int number;
    Date birthday;

    String name;

    PetCommands commands;

    public Animal(int number, Date birthday) {
        id++;
        this.number = number;
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommandsList()
    {
        return commands.toString();
    }
}
