package DataBase;

import Animals.Animal;
import Animals.PackAnimals;
import Animals.PetAnimals;
import Animals.Animal;
import Animals.PackAnimals;
import Animals.PetAnimals;

import java.util.ArrayList;
import java.util.List;

public class ListDataBase implements InterfaceDataBase{

    private String dbname;
    private List<PetAnimals> petAnimals;
    private List<PackAnimals> packAnimals;

    public ListDataBase(String dbname) {
        this.dbname = dbname;
        this.petAnimals = new ArrayList<>();
        this.packAnimals = new ArrayList<>();
    }
    public void printTest(){
        System.out.printf("Print metod!!!");
    }

    @Override
    public boolean open() {
        return true;
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
    public String toString() {
        StringBuilder dbReport = new StringBuilder();

        dbReport.append(String.format("\r\n----- %s ------\r\n", this.dbname));

        dbReport.append("Pet Animals:\r\n");
        for (PetAnimals petAnimal: this.petAnimals) {
            dbReport.append(String.format(petAnimal.toString()));
            dbReport.append("\r\n");
        }

        dbReport.append("Pack Animals:\r\n");
        for (PackAnimals packAnimal: this.packAnimals) {
            dbReport.append(String.format(packAnimal.toString()));
            dbReport.append("\r\n");
        }

        dbReport.append("\r\n----- End of Data Base ------\r\n");

        return dbReport.toString();
    }
}
