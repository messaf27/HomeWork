package Animals;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;

public abstract class Animal {
    static int counter;
    private final Integer id;
    private String name;
    private String birthday;
    private ArrayList<String> commands;

    public Animal(String name, String birthday) {
        counter++;
        id = counter;
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
    }

    public int getId()
    {
        return this.id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCommand(String command)
    {
        commands.add(command);
    }
    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(!commands.isEmpty())
        {
            for (int i = 0; i < commands.size(); i++)
            {
                sb.append(commands.get(i));
                if((i + 1) != commands.size())
                    sb.append(", ");
            }
        }else {
            sb.append("None commands");
        }

        return String.format("[%d] Name: %s, Birthday: %s, Commands: %s",
        this.id, this.name, this.birthday, sb);
    }
}
