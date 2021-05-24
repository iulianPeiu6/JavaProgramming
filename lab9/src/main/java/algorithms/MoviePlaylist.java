package algorithms;

import entities.Director;
import entities.Movie;
import services.Repository;

import java.util.List;

public class MoviePlaylist {
    private List<Movie> allMovies;

    private List<Director> allDirectors;

    private Graph graphAssociation;

    public MoviePlaylist() {
        allMovies = (new Repository<Movie>(Movie.class))
                .getAll();

        allDirectors = (new Repository<Director>(Director.class))
                .getAll();

        initGraph();
        graphAssociation.createMaximalCustomMatching();
        var matching = graphAssociation.getMatching();
        //matching.size();
    }

    private void initGraph() {
        graphAssociation = new Graph(allMovies.size());

        for (int i=0; i<allMovies.size(); i++)
            for (int j=0; j<allMovies.size(); j++)
                if (moviesRelate(i,j))
                    graphAssociation.addEdge(i,j);
    }

    private boolean moviesRelate(int firstMovieIndex, int secondMovieIndex) {
        int firstMovieId = allMovies.get(firstMovieIndex).getId();
        int secondMovieId = allMovies.get(secondMovieIndex).getId();

        int firstMovieDirectorId = getDirectorId(firstMovieId);
        int secondMovieDirectorId = getDirectorId(secondMovieId);

        return (firstMovieDirectorId == secondMovieDirectorId);
    }

    private int getDirectorId(int movieId) {
        for (Director director : allDirectors)
            if (director.getMovieId() == movieId)
                return director.getId();

        return 0;
    }
}
