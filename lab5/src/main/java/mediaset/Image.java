package mediaset;

import exceptions.CatalogException;

import java.util.Date;

public class Image extends AbstractMediaUnit {
    public Image(String name, String path) throws CatalogException {
        super(name,path);
    }

    @Override
    public String toString() {
        return "Image{" +
                "name='" + super.getName() + '\'' +
                ", path='" + super.getPath() + '\'' + '}';
    }
}
