import entities.Genre;
import services.IRepository;
import services.Repository;

public class Main {

    public static void runTest(){
        IRepository<Genre> genres = new Repository<>(Genre.class);
        Genre genre = new Genre();
        genre.setName("test");
        var added = genres.add(genre);
        var genreList = genres.getAll();
        System.out.println(genreList);
    }


    public static void main(String[] args){
        runTest();
    }
}
