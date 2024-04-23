package MVC;

import DataBase.InterfaceDataBase;

public class Model {
    private InterfaceDataBase dataBase;

    public Model(InterfaceDataBase dataBase) {
        this.dataBase = dataBase;
    }
}
