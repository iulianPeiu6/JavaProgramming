package shellpackage;

import exceptions.CatalogException;
import mediaset.AbstractMediaUnit;
import multimediamanagement.Catalog;

import java.io.IOException;

public interface ICommand {
    void run(Catalog catalog) throws IOException, CatalogException;

}
