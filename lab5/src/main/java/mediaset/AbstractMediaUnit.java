package mediaset;

import exceptions.CatalogException;

import java.io.File;
import java.io.FileNotFoundException;

public abstract class AbstractMediaUnit {
    private String name;
    private String path;

    public AbstractMediaUnit(String name, String path) throws CatalogException {

        File file = new File(path);

        if (!file.exists())
            throw new CatalogException(
                    new FileNotFoundException("File " + name + " doesn't exists!")
            );

        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

}
