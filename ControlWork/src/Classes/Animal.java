package Classes;

import java.util.Date;

public abstract class Animal {
    private Integer uniqId;
    private Date birthday;
    private String name;
    private final ListCommand listCommand;

    public Animal(String name, Date birthday) {
        this.uniqId = new UniqID().creteId();
        this.name = name;
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

    public void addNewCommand(Command cmd)
    {
        this.listCommand.addCommand(cmd);
    }

    public String getCommands()
    {
        return this.listCommand.getList().toString();
    }

    public void executeCommand(Command command)
    {
        if(this.listCommand.getList().contains(command))
        {
            System.out.printf(
//                    "Animal Type: %s, " +
                    "Name: %s, " +
                    "ID: %d, " +
                    "Execute: %s ",
//                    getAnimalType(),
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