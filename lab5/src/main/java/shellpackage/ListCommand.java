package shellpackage;

import mediaset.AbstractMediaUnit;
import multimediamanagement.Catalog;

public class ListCommand implements ICommand {

    @Override
    public void run(Catalog catalog) {
        catalog.list();
    }
}
