package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatalogException  extends Exception{

    public CatalogException(String msg) {
        super("Catalog exception: " + msg);
    }

    public CatalogException(FileNotFoundException exp) {
        super("Catalog exception: "+ exp.getMessage());
    }

    public CatalogException(IOException exp) {
        super("Catalog exception: "+ exp.getMessage());
    }

}
