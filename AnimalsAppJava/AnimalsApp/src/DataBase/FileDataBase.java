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
    private final List<PetAnimals> petAnimals;
    private final List<PackAnimals> packAnimals;

    public FileDataBase(String path) {
        this.path = path;
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
                case "Animal.PetAnimal" -> {
                    switch (lineValues.get(1)){
                        case "Cat" ->{
                            animal = new Cat(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComDelimiterFromString(
                                    lineValues.get(4), "|"));
                        }
                        case "Dog" ->{
                            animal = new Dog(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComDelimiterFromString(
                                    lineValues.get(4), "|"));
                        }
                        case "Hamster" ->{
                            animal = new Hamster(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComDelimiterFromString(
                                    lineValues.get(4), "|"));
                        }
                    }
                }
                case "Animal.PackAnimal" -> {
                    switch (lineValues.get(1)){
                        case "Horse" ->{
                            animal = new Horse(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComDelimiterFromString(
                                    lineValues.get(4), "|"));
                        }
                        case "Donkey" ->{
                            animal = new Donkey(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComDelimiterFromString(
                                    lineValues.get(4), "|"));
                        }
                        case "Camel" ->{
                            animal = new Camel(
                                    lineValues.get(2),
                                    lineValues.get(3));
                            animal.addCommands(commands.getComDelimiterFromString(
                                    lineValues.get(4), "|"));
                        }
                    }
                }
            }
        }
        return animal;
    }

    @Override
    public boolean open() {
        Animal animal = null;
        try (Scanner s = new Scanner(new File(this.path));) {
            while (s.hasNextLine()) {
                animal = getAnimalFromLine(s.nextLine());
                if(animal instanceof PetAnimals){
                    this.petAnimals.add((PetAnimals) animal);
                }else if (animal instanceof  PackAnimals){
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

    @Override
    public boolean close() {
        try (FileWriter wr = new FileWriter(this.path, false)) {
            for(int i =0; i < this.petAnimals.size(); i++ )
            {
                Animal animal = this.petAnimals.get(i);
                Commands commands = new Commands();

                wr.append(String.format("%s, ", animal.getClass()));
                wr.append(String.format("%s, ", animal.getName()));
                wr.append(String.format("%s, ", animal.getBirthday()));
                wr.append(String.format("%s\n", commands.setComDelimiterToString(animal.getCommands(), "|")));

            }
            for(int i =0; i < this.packAnimals.size(); i++ )
            {
                Animal animal = this.packAnimals.get(i);
                Commands commands = new Commands();

                wr.append(String.format("%s, ", animal.getClass()));
                wr.append(String.format("%s, ", animal.getName()));
                wr.append(String.format("%s, ", animal.getBirthday()));
                wr.append(String.format("%s\n", commands.setComDelimiterToString(animal.getCommands(), "|")));

            }
            wr.flush();
            wr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return true;
    }

    @Override
    public String getName() {
        return this.path;
    }

    @Override
    public void addAnimal(Animal animal) {
        if(animal instanceof PetAnimals){
            this.petAnimals.add((PetAnimals) animal);
        } else if (animal instanceof PackAnimals) {
            this.packAnimals.add((PackAnimals) animal);
        }
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
        return false;
    }

    @Override
    public boolean removeAnimal(int id) {
        return false;
    }

    @Override
    public int getNumOfAnimals() {
        return 0;
    }
}
