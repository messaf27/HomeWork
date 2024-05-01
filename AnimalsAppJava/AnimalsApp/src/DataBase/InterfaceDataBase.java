package DataBase;

import Animals.Animal;

public interface InterfaceDataBase {
    boolean open();
    boolean close();
    String getName();
    void addAnimal(Animal animal);
    String getAnimalFromId(int id);
    boolean removeAnimal(Animal animal);
    boolean removeAnimal(int id);
    int getNumOfAnimals();
}
