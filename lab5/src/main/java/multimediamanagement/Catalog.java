package multimediamanagement;

import exceptions.CatalogException;
import mediaset.AbstractMediaUnit;
import mediaset.Book;
import mediaset.Song;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog {

    private List<AbstractMediaUnit> content;

    public Catalog() {
        this.content = new ArrayList<>();
    }

    public void add(AbstractMediaUnit mediaUnit){
        content.add(0 , mediaUnit);
    }

    public void list(){

        for (var media : content){
            System.out.println(media.toString());
        }
    }

    public void play(int mediaIndex) throws IOException {

        Desktop desktop = Desktop.getDesktop();

        File file = new File(content.get(mediaIndex).getPath());

        desktop.open(file);

    }

    public void save(String fileName) throws IOException {
        File catalogFile = new File("C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab5\\src\\test\\java\\savedcatalogs\\"
                + fileName);

        catalogFile.createNewFile();

        FileWriter fileWriter = new FileWriter(catalogFile);

        fileWriter.write(content.toString());

        fileWriter.close();

    }

    private String getContentDetails(String fileName) throws CatalogException, FileNotFoundException {

        String getContendDetails;

        try {
            File catalogFile = new File("C:\\Users\\iulia\\OneDrive\\Desktop\\FII\\PA\\PA\\lab5\\src\\test\\java\\savedcatalogs\\"
                    + fileName);

            Scanner reader = new Scanner(catalogFile);

            getContendDetails = reader.nextLine();

        } catch (FileNotFoundException exp) {
            throw new CatalogException(exp);
        }

        return getContendDetails;
    }

    private void addBook(String book) throws CatalogException {

        String[] bookDetails = book.split(",");

        String title = bookDetails[0].split("'")[1];
        String path = bookDetails[1].split("'")[1];
        String authorName = bookDetails[2].split("'")[1];

        add(new Book(path, title, authorName));
    }

    private void addSong(String song) throws CatalogException {

        String[] songDetails = song.split(",");

        String title = songDetails[0].split("'")[1];
        String path = songDetails[1].split("'")[1];
        String composerName = songDetails[2].split("'")[1];
        String releaseYear = songDetails[3].split("'")[1];
        String rating = songDetails[4].split("'")[1];

        add(new Song(path, title, composerName, Integer.parseInt(releaseYear), Double.parseDouble(rating)));
    }

    public void load(String fileName) throws CatalogException, FileNotFoundException {

        String contentString = getContentDetails(fileName);
        contentString = contentString.substring(1,contentString.length()-1);

        String[] contentDetails = contentString.split("(\\{)|(})");

        int detailIndex=0;

        while (detailIndex < contentDetails.length){

            if (contentDetails[detailIndex].contains("Book"))
                addBook(contentDetails[++detailIndex]);

            else if (contentDetails[detailIndex].contains("Song"))
                addSong(contentDetails[++detailIndex]);

            ++detailIndex;
        }

    }

    public List<AbstractMediaUnit> getContent() {
        return content;
    }

    public int getSize(){
        return content.size();
    }
}
