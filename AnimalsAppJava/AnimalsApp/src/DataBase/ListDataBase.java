package DataBase;

import Animals.Animal;
import Animals.PackAnimals;
import Animals.PetAnimals;

import java.util.ArrayList;
import java.util.List;

public class ListDataBase implements InterfaceDataBase{

    private final String dbname;
    private final List<PetAnimals> petAnimals;
    private final List<PackAnimals> packAnimals;

    public ListDataBase(String dbname) {
        this.dbname = dbname;
        this.petAnimals = new ArrayList<>();
        this.packAnimals = new ArrayList<>();
    }

    @Override
    public boolean open() {
        return true;
    }

    @Override
    public boolean close() {
        // TODO: Добавить механизм закрытия при необходимости
        return true;
    }

    @Override
    public String getName() {
        return this.dbname;
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
                return this.packAnimals.get(i).toString();
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
                return true;
            }
        }

        for(int i =0; i < this.packAnimals.size(); i++ )
        {
            if(this.packAnimals.get(i).getId() == id){
                this.packAnimals.remove(i);
                return true;
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

        dbReport.append(String.format("\r\n----- %s ------\r\n", this.dbname));

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
