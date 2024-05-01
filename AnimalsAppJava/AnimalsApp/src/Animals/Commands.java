package Animals;

import java.util.ArrayList;
import java.util.Scanner;

public class Commands {
    public ArrayList<String> getComDelimiterFromString(String line, String delimiter)
    {
        ArrayList<String> commands = new ArrayList<>();
        try (Scanner s = new Scanner(line)) {
            s.useDelimiter(delimiter);
            while (s.hasNext()) {
                commands.add(s.next());
            }
            s.close();
        }
        return commands;
    }

    public String setComDelimiterToString(ArrayList<String> commands, String delimiter)
    {
        StringBuilder sb = new StringBuilder();
        for (String command : commands){
            sb.append(command);
            sb.append(delimiter);
        }
        return sb.toString();
    }

}
