package at.ac.fhcampuswien.fhmdb.HelperClasses;
import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.ArrayList;
import java.util.List;

import at.ac.fhcampuswien.fhmdb.models.Movie;

import java.util.Collections;
import java.util.List;

public class FilterHelper {
    // A Helper Class containing methods for filtering. They can be accessed by creating an object of the class.

    public List<Movie> filterMovies(List<Movie> movies, String searchString, Movie.Genre genre){
        // Check for Null or empty
        if (movies == null) throw new NullPointerException();
        if (movies.isEmpty()) throw new IllegalArgumentException();

        return (genre != null)?
                 movies.stream().filter(x -> x.getGenres().contains(genre)).filter(x -> x.getTitle().toLowerCase().contains(searchString.trim().toLowerCase()) || x.getDescription().toLowerCase().contains(searchString.trim().toLowerCase())).toList()
                : movies.stream().filter(x -> x.getTitle().toLowerCase().contains(searchString.trim().toLowerCase()) || x.getDescription().toLowerCase().contains(searchString.trim().toLowerCase())).toList();
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
