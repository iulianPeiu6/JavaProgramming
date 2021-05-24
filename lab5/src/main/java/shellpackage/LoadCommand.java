package shellpackage;

import exceptions.CatalogException;
import multimediamanagement.Catalog;

import java.io.IOException;

public class LoadCommand implements ICommand{

    private String loadFromFile;

    public LoadCommand(String loadFromFile) {
        this.loadFromFile = loadFromFile;
    }

    @Override
    public void run(Catalog catalog) throws IOException, CatalogException {
        catalog.load(loadFromFile);
    }
}
