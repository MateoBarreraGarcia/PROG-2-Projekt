package at.ac.fhcampuswien.fhmdb.HelperClasses;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.ArrayList;
import java.util.List;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Collections;
import java.util.List;

public class FilterHelper {
    // A Helper Class containing methods for filtering. They can be accessed by creating an object of the class.

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

    /*
    sorts the List of movies alphabetically by their titles,
    either ascending if order == true or decending if order == false
     */
    public List<Movie> sort(List<Movie> movies, boolean order) {
        if (movies == null) {
            throw new NullPointerException();
        }
        if (movies.isEmpty()) {
            throw new IllegalArgumentException();
        }

        if (order) {
            Collections.sort(movies);
        } else {
            movies.sort(Collections.reverseOrder());
        }
        return movies;
    }
}
