package DataBase;
import Classes.Animal;

public interface InterfaceDataBase {
    boolean connect();
    boolean create(String dbTableName);
    void addAnimal(Animal animal);
}
