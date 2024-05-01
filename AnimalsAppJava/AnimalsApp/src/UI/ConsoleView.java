package UI;

import Animals.Animal;
import DataBase.InterfaceDataBase;
import MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private Scanner in;

    public ConsoleView() {
        this.in = new Scanner(System.in);
    }

    private int getIntCheck()
    {
        int result = 0;

        if(in.hasNextInt()){
            result = in.nextInt();
        }else{
            System.out.println("---------------------!!!ВНИМАНИЕ!!!--------------------------");
            System.out.println("Ошибка ввода, введите число!");
        }
        in.nextLine(); // Fix new line symbol

        return result;
    }

    @Override
    public void displayMenu(String title, Menu menu) {
        StringBuilder buildMenu = new StringBuilder("\n");
        buildMenu.append("=============================================================\n");
        buildMenu.append(String.format("%s\n", title));
        buildMenu.append("-------------------------------------------------------------\n");
        for (int i = 0; i < menu.getNumItems(); i++) {
            buildMenu.append(String.format("[%d] %s\n",
                    menu.getItemFromIndex(i).getIndex(), menu.getItemNameFromIndex(i)));
        }
        buildMenu.append("=============================================================\n");
        buildMenu.append(String.format("Выберете пункт меню от %d до %d: ", 1, menu.getNumItems()));

        System.out.print(buildMenu);
    }

    @Override
    public int getSelectedMenuItem() {
        int selectedIndex = getIntCheck();
        System.out.println("-------------------------------------------------------------");
        return selectedIndex;
    }

    @Override
    public void displayAnimal(Animal animal) {
        System.out.println(animal);
    }

    @Override
    public void displayDataBase(InterfaceDataBase db) {
        System.out.println(db);
    }

    @Override
    public void displayResultMessage(String message) {
        System.out.println("-------------------------------------------------------------");
        System.out.println(message);
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public int getId() {
        System.out.print("Введите идентификатор (ID) животного: ");
        return getIntCheck();
    }

    @Override
    public String getCommand() {
        System.out.print("Введите новую команду: ");
        return in.nextLine();
    }

    @Override
    public String getName() {
        System.out.print("Введите имя: ");
        return in.nextLine();
    }

    @Override
    public String getBirthday() {
        System.out.print("Введите дату рождения (формат ДД-ММ-ГГГГ): ");
        return in.nextLine();
    }

    @Override
    public void exit() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Выход из приложения.");
        System.out.println("-------------------------------------------------------------");
    }


}
