package MVP;

import DataBase.InterfaceDataBase;

public class Model {
    private InterfaceDataBase currentDataBase;
    private int curentIndex;

    public Model(InterfaceDataBase currentDataBase) {
        this.curentIndex = 0;
        this.currentDataBase = currentDataBase;
    }

    public InterfaceDataBase getCurrentDataBase()
    {
        return this.currentDataBase;
    }
}
