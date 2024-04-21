package Classes;

import java.util.ArrayList;

public class PetCommands {
    ArrayList<Commands> commands = new ArrayList<>();

    public PetCommands() {
    }

    private String getCommandName(Commands command)
    {
        switch (command)
        {
            case Commands.GO: return  "Go";
            case Commands.STOP: return  "Stop";

            default: return "NULL";
        }
    }

    public void addCommand(Commands commnand)
    {
//        System.out.printf("add %s command \r\n", commnand.toString());
        commands.add(commnand);
//        System.out.println(commands);
    }

    @Override
    public String toString() {
        System.out.println(this.commands);

        StringBuilder cmds = new StringBuilder();
//        for (Commands cmd: this.commands ) {
//            cmds.append(getCommandName(cmd));
//            cmds.append("\r\n");
//        }
        return cmds.toString();
    }
}

