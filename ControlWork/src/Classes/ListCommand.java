package Classes;
import java.util.ArrayList;
import java.util.List;

public class ListCommand {
    List<Command> commandList;

    public ListCommand() {
        this.commandList = new ArrayList<>();
    }

    public void addCommand(Command cmd)
    {
        if(!this.commandList.contains(cmd))
        {
            this.commandList.add(cmd);
        }else {
            System.out.printf("Command %s has already added!", cmd.toString());
        }
    }

    public List<Command>getList()
    {
        return this.commandList;
    }

}
