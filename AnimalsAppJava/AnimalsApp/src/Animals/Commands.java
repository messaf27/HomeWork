package Animals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Commands {
    public ArrayList<String> getComFromString(String line)
    {
        String comString = null;
        ArrayList<String> commands = null;

        if((line.contains("[")) && (line.contains("]"))) {
            comString = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            String[] strCommands = comString.split(",");
            List<String> fixedLenghtList = Arrays.asList(strCommands);
            commands = new ArrayList<String>(fixedLenghtList);
        }

        return commands;
    }

    public String setComToString(ArrayList<String> commands)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < commands.size(); i++)
        {
            sb.append(commands.get(i));
            if((i + 1) != commands.size())
                sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }

}
