package Helpers;

import java.util.HashMap;
import java.util.Map;
import Interfaces.CommandInterface;

/**
 *
 * @author xg6856vd
 */

//CUSTOM SWITCH CLASS FOR DYNAMIC CASES
public class Switcher {

    private Map<Integer, CommandInterface> caseCommands;

    private CommandInterface defaultCommand;

    private CommandInterface getCaseCommandByCaseId(Integer caseId) {
        if (caseCommands.containsKey(caseId)) {
            return caseCommands.get(caseId);
        } else {
            return defaultCommand;
        }
    }

    public Switcher() {
        caseCommands = new HashMap<Integer, CommandInterface>();

        setDefaultCaseCommand(new DoNothingCommand());
    }

    public void addCaseCommand(Integer caseId, CommandInterface caseCommand) {
        caseCommands.put(caseId, caseCommand);
    }

    public void setDefaultCaseCommand(CommandInterface defaultCommand) {
        if (defaultCommand != null) {
            this.defaultCommand = defaultCommand;
        }
    }

    public void on(Integer caseId) {
        CommandInterface command = getCaseCommandByCaseId(caseId);

        command.execute(caseId);
    }
}
