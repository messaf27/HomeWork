package MVP;

import Animals.*;
import UI.Menu;
import UI.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class Presenter {
    private Model model;
    private View view;

    private final Menu main = new Menu(Arrays.asList(
            new MenuItem("Прочитать базу данных", 1),
            new MenuItem("Добавить животное", 2),
            new MenuItem("Удалить животное", 3),
            new MenuItem("Выход", 4)
    ));

    private final Menu selectAddAnimals = new Menu(Arrays.asList(
            new MenuItem("Добавить домашнее животное", 1),
            new MenuItem("Добавить вьючное животное", 2)
    )
    );

    private final Menu selectAddPetAnimal = new Menu(Arrays.asList(
            new MenuItem("Кот", 1),
            new MenuItem("Собака", 2),
            new MenuItem("Хомяк", 3),
            new MenuItem("Отменить добавление", 4)
    ));

    private final Menu selectAddPackAnimal = new Menu(Arrays.asList(
            new MenuItem("Лошадь", 1),
            new MenuItem("Осёл", 2),
            new MenuItem("Верблюд", 3),
            new MenuItem("Отменить добавление", 4)
    ));

    private final Menu confirmRequestYesNo = new Menu(Arrays.asList(
            new MenuItem("Да", 1),
            new MenuItem("Нет", 2)
    ));


    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public boolean startUserInterface()
    {
        boolean dbIsOpen = model.getCurrentDataBase().open();
        while(true)
        {
            if(!dbIsOpen) {
                view.displayResultMessage("Невозможно открыть базу данных!");
                return false;
            }
            view.displayMenu(
                    String.format("База данных \"%s\" содержет %d животных",
                            model.getCurrentDataBase().getName(),
                    model.getCurrentDataBase().getNumOfAnimals()),
                    main);

            int selectedItem = view.getSelectedMenuItem();

            if(selectedItem == 4) {
                return this.exit();
            }else if (selectedItem > 0 && selectedItem < main.getNumItems()) {
                switch (selectedItem)
                {
                    case 1 ->{
                        view.displayDataBase(model.getCurrentDataBase());
                    }

                    case 2 ->{
                        view.displayMenu("Выберете тип животного:",
                                selectAddAnimals);

                        Animal animal = null;
                        switch (view.getSelectedMenuItem()){
                            case 1 ->{
                                view.displayMenu("Выберете вид домашнего животного:",
                                        selectAddPetAnimal);

                                int selected = view.getSelectedMenuItem();
                                switch (selected){
                                    case 1,2,3->{
                                        switch (selected){
                                            case 1 ->{
                                                animal = new Cat(view.getName(), view.getBirthday());
                                            }
                                            case 2 ->{
                                                animal = new Dog(view.getName(), view.getBirthday());
                                            }
                                            case 3 ->{
                                                animal = new Hamster(view.getName(), view.getBirthday());
                                            }
                                        }
                                        animal.addCommands(addCommandMenu());
                                        model.getCurrentDataBase().addAnimal(animal);
                                    }
                                    case 4 -> {break;}
                                }
                            }

                            case 2 ->{
                                view.displayMenu("Выберете вид вьючного животного:",
                                        selectAddPackAnimal);
                                int selected = view.getSelectedMenuItem();
                                switch (selected){
                                    case 1,2,3->{
                                        switch (selected){
                                            case 1 ->{
                                                animal = new Horse(view.getName(), view.getBirthday());
                                            }
                                            case 2 ->{
                                                animal = new Donkey(view.getName(), view.getBirthday());
                                            }
                                            case 3 ->{
                                                animal = new Camel(view.getName(), view.getBirthday());
                                            }
                                        }
                                        animal.addCommands(addCommandMenu());
                                        model.getCurrentDataBase().addAnimal(animal);
                                    }
                                    case 4 -> {break;}
                                }
                            }
                            case 4 -> {break;}

                        }
                    }

                    case 3->{
                        int deleteId = view.getId();
                        if(model.getCurrentDataBase().getAnimalFromId(deleteId) != null)
                        {
                            view.displayMenu(
                                    String.format("Вы действительно хотите удалить? :\n %s",
                                            model.getCurrentDataBase().getAnimalFromId(deleteId)),
                                    confirmRequestYesNo
                            );
                        }else {
                            view.displayResultMessage(String.format("ID: %d не найден в базе", deleteId));
                            break;
                        }

                        if(view.getSelectedMenuItem() == 1)
                        {
                            if(model.getCurrentDataBase().removeAnimal(deleteId))
                                view.displayResultMessage("Животное успешно удалено!");
                            else
                                view.displayResultMessage("Ошибка удаления");
                        }else{
                            view.displayResultMessage("Отмена удаления");
                        }
                    }
                }
            }
        }
    }

    public boolean exit()
    {
        view.exit();
        return model.getCurrentDataBase().close();
    }

    private ArrayList<String> addCommandMenu()
    {
        String command = "";
        ArrayList<String> commands = new ArrayList<>();
        while (true)
        {
            view.displayMenu("Добавить команду?", confirmRequestYesNo);
            if(view.getSelectedMenuItem() == 2)
                break;
            commands.add(view.getCommand());
            view.displayResultMessage("Команда добавлена");
        }
        return commands;
    }
}
