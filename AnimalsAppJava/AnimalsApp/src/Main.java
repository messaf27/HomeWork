import Animals.*;
import DataBase.FileDataBase;
import DataBase.InterfaceDataBase;
import DataBase.ListDataBase;
import DataBase.MySQLDataBase;
import UI.App;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        App app = new App();
        boolean result = app.run();

        System.out.printf(
                "Приложение завершилось %s\r\n",
                result ? "без ошибок" : "с ошибкой!");
//
//        InterfaceDataBase db = new FileDataBase("dataBase.db", "Human Friends");
//        db.open();
//        System.out.println(db);

//        Animal cat1 = new Cat("Barsik", "12-12-2020");
//        cat1.addCommand("Jump");
//        cat1.addCommand("Voice");
//        cat1.addCommand("Go");
//
//        Animal horse1 = new Horse("Iskra", "02-05-2023");
//        horse1.addCommand("Stop");
//        horse1.addCommand("Get");
//        horse1.addCommand("Beg");
//
//        db.addAnimal(cat1);
//        db.addAnimal(horse1);

//        db.close();
    }

}
