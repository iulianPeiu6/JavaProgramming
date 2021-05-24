package multimediamanagement;

import com.github.javafaker.Faker;
import exceptions.CatalogException;
import mediaset.Book;
import mediaset.Image;
import mediaset.Movie;
import mediaset.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CatalogTest {

    private Catalog catalog;

    @BeforeEach
    @Test
    @DisplayName("Catalog should be created!")
    public void catalogWasCreatedTest(){

        catalog = new Catalog();

        assertTrue(catalog.getContent().isEmpty());

    }

    @Test
    @DisplayName("Book should be added in catalog!")
    public void addBookTest() {

        try {
            catalog.add(new Book("C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\" +
                    "lab5\\src\\test\\java\\mediasample\\Mockingbird.pdf",
                    "To Kill a Mockingbird",
                    "Harper Lee"));
        } catch (CatalogException e) {
            e.printStackTrace();
        }

        String addedBookDetails = catalog.getContent().get(0).toString();

        System.out.println(addedBookDetails);
        assertEquals(addedBookDetails,"Book{title='To Kill a Mockingbird', " +
                "path='C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab5\\src\\test\\java\\mediasample\\Mockingbird.pdf', " +
                "authorName='Harper Lee'}");
    }

    @Test
    @DisplayName("Image should not be added in catalog, cause: invalid path!")
    public void addImageTest(){

        String anInvalidPath = "C: invalid path blabla sadsd\\dsfdsf";
        try {
            catalog.add(new Image("pickles", anInvalidPath));
        } catch (CatalogException e) {
            return;
        }

        fail();

    }

    @Test
    @DisplayName("Song should be added in catalog!")
    public void addSongTest() {

        String songPath = "C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\" +
                "lab5\\src\\test\\java\\mediasample\\ACDC - Highway to Hell (Official Video).mp3";

        try {
            catalog.add(new Song(songPath,"Highway to Hell", "ACDC", 1979, 8.9));
        } catch (CatalogException e) {
            fail();
        } finally {
            assertFalse(catalog.getContent().isEmpty());
        }

    }

    @Test
    @DisplayName("Movie should not be added in catalog: cause: invalid Date!")
    public void addMovieTest() {

        int anInvalidYear = Calendar.getInstance().get(Calendar.YEAR)+1;

        try {
            catalog.add(new Movie("Avanger: Endgame",
                    "C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab5\\src\\test\\java\\mediasample\\Marvel Studios' Avengers_ Endgame - Official Trailer.mp4",
                    anInvalidYear,
                    9.4));
        } catch (CatalogException e) {
            return ;
        }

        fail();

    }

    @Test
    @DisplayName("Content should be printed!")
    public void listTest(){

        addBookTest();

        addImageTest();

        addSongTest();

        addMovieTest();

        assertEquals(catalog.getContent().size(), 2);

        //catalog.list();

        assertEquals(catalog.getContent().toString(),
                "[Song{title='Highway to Hell', " +
                        "path='C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab5\\src\\test\\java\\mediasample\\ACDC - Highway to Hell (Official Video).mp3', " +
                        "composerName='ACDC', releaseYear='1979', rating='8.9'}, " +
                        "Book{title='To Kill a Mockingbird', path='C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab5\\src\\test\\java\\mediasample\\Mockingbird.pdf', " +
                        "authorName='Harper Lee'}]");


    }

    @Test
    @DisplayName("Content should be opened!")
    public void playTest() {

        listTest();

        for (int mediaIndex=0; mediaIndex < catalog.getSize() ; mediaIndex++)
        try {
            catalog.play(mediaIndex);
        } catch (IOException exp){
            System.out.println(exp);
        }

    }

    @Test
    @DisplayName("Content string should be put in catalogNum1.txt!")
    public void saveTest() throws IOException {

        listTest();

        catalog.save("catalogNum1.txt");

    }

    @Test
    @DisplayName("Content should be loaded from catalogNum1.txt!")
    public void loadTest() throws IOException, CatalogException {

        catalog.load("catalogNum1.txt");

        catalog.play(0);
        catalog.play(1);

    }

}