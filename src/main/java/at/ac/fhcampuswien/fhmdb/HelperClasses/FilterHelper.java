package at.ac.fhcampuswien.fhmdb.HelperClasses;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.ArrayList;
import java.util.List;

public class FilterHelper {
    // A Helper Class containing methods for filtering. They can be accessed by creating an object of the class.

    public static int addOrSubstract(int x, int y, boolean operation) {

        return operation ? x + y: x - y;
    }

    public static List<Movie> filterMovies(List<Movie> movies, String searchString, Movie.Genre genre){
        /*
        for (Movie movie: movies) {

        }
        */

        /*
        Filter after Genre

        Filter After Title

        Filter After Description
         */
        // Old Code
        if(searchString.isEmpty() || searchString == "" || searchString.trim() == "") return movies;    // Returnes the list of all movies when searchig for empty strings

        List<Movie> filteredMovieList = new ArrayList<>();
        for (Movie movie:movies) {  // Improve with regex?
            if(movie.getTitle().contains(searchString)){
                filteredMovieList.add(0,movie);
            }
            /*
            else {
                if(movie.getDescription().contains(searchString)) filteredMovieList.add(movie);
            }
            */
        }

        return filteredMovieList;
    }
}
