package mediaset;

import exceptions.CatalogException;

import java.util.Calendar;
import java.util.Date;

public class Movie extends AbstractMediaUnit {
    private String title;
    private int releaseYear;
    private Double rating;

    public Movie(String title, String path, int releaseYear, Double rating) throws CatalogException {
        super(title,path);

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        if (releaseYear > currentYear)
            throw new CatalogException("Invalid year!");

        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", path='" + super.getPath() + '\'' +
                ", releaseYear=" + releaseYear +
                ", rating=" + rating +
                '}';
    }
}
