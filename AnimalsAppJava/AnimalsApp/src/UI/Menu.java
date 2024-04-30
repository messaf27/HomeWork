package UI;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final List<MenuItem> menuList;

    public Menu() {
        this.menuList = new ArrayList<>();
    }

    public Menu(List<MenuItem> items) {
        this.menuList = items;
    }

    public void addMenuItem(MenuItem item) {
        this.menuList.add(item);
    }

    public int getNumItems() {
        return this.menuList.size();
    }

    public MenuItem getItemFromIndex(int index) {
        return this.menuList.get(index);
    }

    public String getItemNameFromIndex(int index) {
        return this.menuList.get(index).getName();
    }
}
