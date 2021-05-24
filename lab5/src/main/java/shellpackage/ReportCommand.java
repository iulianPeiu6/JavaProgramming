package shellpackage;

import exceptions.CatalogException;
import multimediamanagement.Catalog;
import org.apache.velocity.app.Velocity;

import java.io.IOException;

public class ReportCommand implements ICommand{
    @Override
    public void run(Catalog catalog) throws IOException, CatalogException {
        Velocity.init();
    }
}
