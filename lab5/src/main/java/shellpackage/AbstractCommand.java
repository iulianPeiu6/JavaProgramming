package shellpackage;

import mediaset.AbstractMediaUnit;
import multimediamanagement.Catalog;

public abstract class AbstractCommand {
    private String commandName;

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public abstract void runCommand(Catalog catalog);

    public abstract void runCommand(Catalog catalog, AbstractMediaUnit mediaUnit);

}
