package mediaset;

import exceptions.CatalogException;

import java.util.Date;

public class Book extends AbstractMediaUnit {
    private String title;
    private String authorName;

    public Book(String path, String title, String authorName) throws CatalogException {
        super(title, path);
        this.title = title;
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", path='" + super.getPath() +'\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }

}
