package mediaset;

import exceptions.CatalogException;

import java.util.Calendar;
import java.util.Date;

public class Song extends AbstractMediaUnit {
    private String title;
    private String composerName;
    private int releaseYear;
    private Double rating;

    public Song(String path, String title, String composerName, int releaseYear, Double rating) throws CatalogException {
        super(title,path);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (releaseYear > currentYear)
            throw new CatalogException("Invalid year!");

        this.title = title;
        this.composerName = composerName;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", path='" + super.getPath() + '\'' +
                ", composerName='" + composerName + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }

}
