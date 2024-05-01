package DataBase;

import Animals.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataBase implements InterfaceDataBase{

    private String path;
    private final String dbname;

    private final List<PetAnimals> petAnimals;
    private final List<PackAnimals> packAnimals;

    public FileDataBase(String path, String dbname) {
        this.path = path;
        this.dbname = dbname;
        this.petAnimals = new ArrayList<>();
        this.packAnimals = new ArrayList<>();
    }

    private List<Animal> animals;

    public void setPath(String path) {
        this.path = path;
//        this.animals = new ArrayList<>();
    }

    private Animal getAnimalFromLine(String line){
        Animal animal = null;
        Commands commands = new Commands();
        List<String> lineValues = new ArrayList<>();

        try (Scanner s = new Scanner(line)) {
            s.useDelimiter(", ");
            while (s.hasNext()) {
                lineValues.add(s.next());
            }
            s.close();
            switch (lineValues.get(0)) {
                case "PetAnimals" -> {
                    switch (lineValues.get(1)){
                        case "Cat" ->{
                            animal = new Cat(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComFromString(lineValues.get(4)));
                        }
                        case "Dog" ->{
                            animal = new Dog(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComFromString(lineValues.get(4)));
                        }
                        case "Hamster" ->{
                            animal = new Hamster(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComFromString(lineValues.get(4)));
                        }
                    }
                }
                case "PackAnimals" -> {
                    switch (lineValues.get(1)){
                        case "Horse" ->{
                            animal = new Horse(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComFromString(lineValues.get(4)));
                        }
                        case "Donkey" ->{
                            animal = new Donkey(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComFromString(lineValues.get(4)));
                        }
                        case "Camel" ->{
                            animal = new Camel(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComFromString(lineValues.get(4)));
                        }
                    }
                }
            }
        }
        return animal;
    }

    private void writeAnimalToFile(FileWriter wr, Commands commands, Animal animal) throws IOException {
        wr.append(String.format("%s, ", animal.getClass().getSuperclass().getSimpleName()));
        wr.append(String.format("%s, ", animal.getClass().getSimpleName()));
        wr.append(String.format("%s, ", animal.getName()));
        wr.append(String.format("%s, ", animal.getBirthday()));
        wr.append(String.format("%s\n", commands.setComToString(animal.getCommands())));
    }

    @Override
    public boolean open() {
        Animal animal = null;
        try (Scanner s = new Scanner(new File(this.path));) {
            while (s.hasNextLine()) {
                animal = getAnimalFromLine(s.nextLine());
                if(animal instanceof PetAnimals){
                    this.petAnimals.add((PetAnimals) animal);
                }else if (animal instanceof PackAnimals){
                    this.packAnimals.add((PackAnimals) animal);
                }else{
                    return false;
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean save()
    {
        try (FileWriter wr = new FileWriter(this.path, false)) {
            Commands commands = new Commands();

            for(int i =0; i < this.petAnimals.size(); i++ )
            {
                Animal animal = this.petAnimals.get(i);
//                Commands commands = new Commands();

                writeAnimalToFile(wr, commands, animal);

            }
            for(int i =0; i < this.packAnimals.size(); i++ )
            {
                Animal animal = this.packAnimals.get(i);
//                Commands commands = new Commands();

                writeAnimalToFile(wr, commands, animal);

            }
            wr.flush();
            wr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return true;
    }


    @Override
    public boolean close() {
        return this.save();
    }

    @Override
    public String getName() {
        return String.format("%s (%s)", this.dbname, this.path);
    }

    @Override
    public void addAnimal(Animal animal) {
        if(animal instanceof PetAnimals){
            this.petAnimals.add((PetAnimals) animal);
        } else if (animal instanceof PackAnimals) {
            this.packAnimals.add((PackAnimals) animal);
        }
        this.save();
    }

    @Override
    public String getAnimalFromId(int id) {
        for(int i =0; i < this.petAnimals.size(); i++ )
        {
            if(this.petAnimals.get(i).getId() == id){
                return this.petAnimals.get(i).toString();
            }
        }
        for(int i =0; i < this.packAnimals.size(); i++ )
        {
            if(this.packAnimals.get(i).getId() == id){
                return this.packAnimals.get(i).toString();
            }
        }
        return null;
    }

    @Override
    public boolean removeAnimal(Animal animal) {
        if(animal instanceof PetAnimals){
            this.petAnimals.remove((PetAnimals) animal);
        } else if (animal instanceof PackAnimals) {
            this.packAnimals.remove((PackAnimals) animal);
        }else {
            return false;
        }
        return true;
    }

    @Override
    public boolean removeAnimal(int id) {
        for(int i =0; i < this.petAnimals.size(); i++ )
        {
            if(this.petAnimals.get(i).getId() == id){
                this.petAnimals.remove(i);
                return this.save();
            }
        }

        for(int i =0; i < this.packAnimals.size(); i++ )
        {
            if(this.packAnimals.get(i).getId() == id){
                this.packAnimals.remove(i);
                return this.save();
            }
        }
        return false;
    }

    @Override
    public int getNumOfAnimals() {
        return this.petAnimals.size() + this.packAnimals.size();
    }

    @Override
    public String toString() {
        StringBuilder dbReport = new StringBuilder();

        dbReport.append(String.format("\r\n----- %s ------\r\n", this.path));
        dbReport.append(String.format("Домашние животные (%d):\r\n", this.petAnimals.size()));
        for (PetAnimals petAnimal: this.petAnimals) {
            dbReport.append(String.format(petAnimal.toString()));
            dbReport.append("\r\n");
        }

        dbReport.append(String.format("Вьючные животные (%d):\r\n", this.packAnimals.size()));
        for (PackAnimals packAnimal: this.packAnimals) {
            dbReport.append(String.format(packAnimal.toString()));
            dbReport.append("\r\n");
        }

        dbReport.append("\r\n----- Конец базы данных ------\r\n");

        return dbReport.toString();
    }
}
