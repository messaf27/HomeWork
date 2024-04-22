package Classes;

import java.util.Date;

public abstract class Animal extends ListCommand{
    private Integer uniqId;
    private int number;
    private Date birthday;
    private String name;

    private ListCommand listCommand;

    public Animal(int number, Date birthday) {
        uniqId = new UniqID().creteId();
        this.number = number;
        this.birthday = birthday;
        this.listCommand = new ListCommand();
    }

    public Integer getId() {
        return uniqId;
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

    public String getAnimalType()
    {
        String animalType = "";
        if(this instanceof  PetAnimal) {
            animalType = "PetAnimal";
        }else if (this instanceof  PackAnimal) {
            animalType = "PackAnimal";
        }else{
            animalType = "None Type!!!";
        }
        return animalType;
    }

    public void executeCommand(Command command)
    {
        if(listCommand.getList().contains(command))
        {
            System.out.printf(
                    "Animal Type: %s, " +
                    "Name: %s, " +
                    "ID: %d," +
                    "Execute: %s ",
                    getAnimalType(),
                    getName(),
                    getId(),
                    command.toString()
            );
        }else {
            System.out.printf("Command: %s not found!!!\r\n", command.toString());
        }
    }





    @Override
    public String toString() {
        return String.format(
                "Animal Type: %s, " +
                "Name: %s, " +
                "ID: %d",
                getAnimalType(),
                getName(),
                getId()
        );
    }
}
