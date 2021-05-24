package shellpackage;

import exceptions.CatalogException;
import multimediamanagement.Catalog;

import java.io.IOException;

public class PlayCommand implements ICommand{

    private int fromIndex;

    public PlayCommand(int playFromIndex) {
        this.fromIndex = playFromIndex;
    }

    @Override
    public void run(Catalog catalog) throws IOException {
        catalog.play(fromIndex);
    }
}
