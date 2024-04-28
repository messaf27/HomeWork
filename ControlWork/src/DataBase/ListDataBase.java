package DataBase;

import Classes.Animal;
import Classes.PackAnimal;
import Classes.PetAnimal;

import java.util.ArrayList;
import java.util.List;

public class ListDataBase implements InterfaceDataBase{

//    private Integer petCounter;
//    private Integer packCounter;
    private List<PetAnimal> petAnimals;
    private List<PackAnimal> packAnimals;

    public ListDataBase() {
        this.petAnimals = new ArrayList<>();
        this.packAnimals = new ArrayList<>();
    }
    public void printTest(){
        System.out.printf("Print metod!!!");
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public void addAnimal(Animal animal) {
        if(animal instanceof PetAnimal){
            this.petAnimals.add((PetAnimal) animal);
        } else if (animal instanceof PackAnimal) {
            this.packAnimals.add((PackAnimal) animal);
        }
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder dbReport = new StringBuilder();

        dbReport.append("\r\n----- Animals Data Base ------\r\n");

        dbReport.append("Pet Animals:\r\n");
        for (PetAnimal petAnimals: this.petAnimals) {
            counter++;
            dbReport.append(String.format("[%d] ID: %d, Name: %s, Commands: %s\r\n",
                    counter, petAnimals.getId(), petAnimals.getName(), petAnimals.getCommands()));
        }

        counter = 0;

        dbReport.append("Pack Animals:\r\n");
        for (PackAnimal packAnimals: this.packAnimals) {
            counter++;
            dbReport.append(String.format("[%d] ID: %d, Name: %s, Commands: %s\r\n",
                    counter, packAnimals.getId(), packAnimals.getName(), packAnimals.getCommands()));
        }

        dbReport.append("\r\n----- End of Data Base ------\r\n");

        return dbReport.toString();
    }
}
