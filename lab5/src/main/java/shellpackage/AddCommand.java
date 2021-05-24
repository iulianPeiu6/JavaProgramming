package shellpackage;

import mediaset.AbstractMediaUnit;
import multimediamanagement.Catalog;

public class AddCommand implements ICommand{

    private AbstractMediaUnit mediaUnit;

    public AddCommand(AbstractMediaUnit mediaUnit) {
        this.mediaUnit = mediaUnit;
    }

    @Override
    public void run(Catalog catalog) {
        catalog.add(mediaUnit);
    }
}
