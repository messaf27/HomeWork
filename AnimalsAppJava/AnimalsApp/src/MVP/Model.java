package MVP;

import DataBase.InterfaceDataBase;

public class Model {
    private InterfaceDataBase currentDataBase;

    public Model(InterfaceDataBase currentDataBase) {
        this.currentDataBase = currentDataBase;
    }

    public InterfaceDataBase getCurrentDataBase()
    {
        return this.currentDataBase;
    }
}
