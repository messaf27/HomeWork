package MVC;

public class MenuItem {
    private String name;
    private int index = 0;
    public MenuItem(String name, int index) {
        this.index = index;
        this.name = name;
    }
    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
