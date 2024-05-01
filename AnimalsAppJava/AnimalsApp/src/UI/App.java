package UI;

import DataBase.FileDataBase;
import DataBase.ListDataBase;
import MVP.Model;
import MVP.Presenter;
import MVP.View;

import java.util.function.Predicate;

public class App {
    public boolean run(){
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        View view = new ConsoleView();
//        Model model = new Model(new ListDataBase("Друзья человека"));
        Model model = new Model(new FileDataBase("dataBase.db", "Друзья человека"));
        Presenter presenter = new Presenter(model, view);
        return presenter.startUserInterface();
    }
}
