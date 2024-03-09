package at.ac.fhcampuswien.fhmdb.HelperClasses;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Movie.Genre;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterHelperTest {

    // Tests for public List<Movie> sort(List<Movie> movies, boolean order)
    @Test
    void a_MovieList_is_sorted_in_ascending_lexicographic_order_if_order_parameter_equals_true() {
        // given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie = new Movie("Dune", "Description", List.of(Movie.Genre.ADVENTURE));
        Movie secondMovie = new Movie("Dune: Part Two", "Description", List.of(Movie.Genre.ADVENTURE));
        Movie thirdMovie = new Movie("Spirited Away", "Description", List.of(Movie.Genre.ADVENTURE));
        Movie fourthMovie = new Movie("The Empire Strikes Back", "Description", List.of(Movie.Genre.ADVENTURE));

        List<Movie> movies = new ArrayList<>();
        movies.add(fourthMovie);
        movies.add(secondMovie);
        movies.add(firstMovie);
        movies.add(thirdMovie);

        List<Movie> expected = List.of(firstMovie,secondMovie,thirdMovie,fourthMovie);
        // when
        List<Movie> actual = filterHelper.sort(movies, true);
        // then
        assertEquals(expected, actual);
    }

    @Test
    void a_MovieList_is_sorted_in_descending_lexicographic_order_if_order_parameter_equals_false() {
        // given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie = new Movie("Dune", "Description", List.of(Movie.Genre.ADVENTURE));
        Movie secondMovie = new Movie("Dune: Part Two", "Description", List.of(Movie.Genre.ADVENTURE));
        Movie thirdMovie = new Movie("Spirited Away", "Description", List.of(Movie.Genre.ADVENTURE));
        Movie fourthMovie = new Movie("The Empire Strikes Back", "Description", List.of(Movie.Genre.ADVENTURE));

        List<Movie> movies = new ArrayList<>();
        movies.add(fourthMovie);
        movies.add(secondMovie);
        movies.add(firstMovie);
        movies.add(thirdMovie);

        List<Movie> expected = List.of(fourthMovie, thirdMovie, secondMovie, firstMovie);
        // when
        List<Movie> actual = filterHelper.sort(movies, false);
        // then
        assertEquals(expected, actual);
    }

    @Test
    void a_MovieList_cannot_be_sorted_if_it_is_empty() {
        // given
        FilterHelper filterHelper = new FilterHelper();
        List<Movie> movies = new ArrayList<>();
        // when and then
        assertThrows(IllegalArgumentException.class, () -> filterHelper.sort(movies, true));
    }

    @Test
    void a_MovieList_cannot_be_sorted_if_it_is_null() {
        // given
        FilterHelper filterHelper = new FilterHelper();
        // when and then
        assertThrows(NullPointerException.class, () -> filterHelper.sort(null, true));
    }

    void checks_if_Movie_has_at_least_one_Genre(){
        // given
        List <Movie> movies = Movie.initializeMovies();

        //when and then
        for (Movie movie : movies){
            //then
            assertTrue(!movie.getGenres().isEmpty(), "Film \"" + movie.getTitle()+"\" kein Genre");
        }

    }

    void check_Movie_with_valid_Genre(){
        //given
        String title = "Avatar";
        String description = "Description";
        Genre validGenre = Movie.Genre.ACTION;

        //when
        Movie movie = new Movie(title,description,List.of(validGenre));

        //then
        assertNotNull(movie);
        assertEquals(title, movie.getTitle());
        assertEquals(description, movie.getDescription());
        assertEquals(validGenre, movie.getGenres());
    }

    void check_Movie_with_unknown_Genre(){
        //given
        String title = "Movie Titel of the unknown Genre";
        String description = "Movie Description of the unknown Genre";
        Genre unknownGenre = Genre.UNKNOWN;

        //when and then
        assertThrows(IllegalArgumentException.class, ()->new Movie(title, description, List.of(unknownGenre)));
    }

}