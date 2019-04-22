package Game;

import Interfaces.Command;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author xg6856vd
 */

//CUSTOM SWITCH CLASS FOR DYNAMIC CASES
public class Switcher {

    private Map<Integer, Command> caseCommands;

    private Command defaultCommand;

    private Command getCaseCommandByCaseId(Integer caseId) {
        if (caseCommands.containsKey(caseId)) {
            return caseCommands.get(caseId);
        } else {
            return defaultCommand;
        }
    }

    public Switcher() {
        caseCommands = new HashMap<Integer, Command>();

        setDefaultCaseCommand(new DoNothingCommand());
    }

    public void addCaseCommand(Integer caseId, Command caseCommand) {
        caseCommands.put(caseId, caseCommand);
    }

    public void setDefaultCaseCommand(Command defaultCommand) {
        if (defaultCommand != null) {
            this.defaultCommand = defaultCommand;
        }
    }

    public void on(Integer caseId) {
        Command command = getCaseCommandByCaseId(caseId);

        command.execute(caseId);
    }
}
