package DataBase;
import Classes.Animal;

public interface InterfaceDataBase {
    boolean connect();
    void addAnimal(Animal animal);
}
