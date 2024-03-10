package at.ac.fhcampuswien.fhmdb.HelperClasses;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.models.Movie.Genre;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterHelperTest {

    // Tests for public List<Movie> filterMovies(List<Movie> movies, String searchString, Movie.Genre genre)
    @Test
    void if_query_is_empty_and_a_genre_is_selected_only_movies_with_that_genre_are_returned() {
        //given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie = new Movie("Dune", "Description", List.of(Movie.Genre.ADVENTURE, Genre.ROMANCE));
        Movie secondMovie = new Movie("Dune: Part Two", "Description", List.of(Movie.Genre.ACTION));
        Movie thirdMovie = new Movie("Spirited Away", "Description", List.of(Genre.HISTORY));
        Movie fourthMovie = new Movie("The Empire Strikes Back", "Description", List.of(Movie.Genre.ADVENTURE));

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);
        movies.add(fourthMovie);

        String query = "";
        Movie.Genre genre = Genre.ADVENTURE;

        List<Movie> expected = List.of(firstMovie,fourthMovie);
        // when
        List<Movie> actual = FilterHelper.filterMovies(movies, query, genre);
        // then
        assertEquals(expected, actual);
    }

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
    @Test
    void if_no_query_was_set_and_no_genre_selected_the_initial_list_is_returned(){
        // given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie = new Movie("Dune", "Description", List.of(Movie.Genre.ADVENTURE, Genre.ROMANCE));
        Movie secondMovie = new Movie("Dune: Part Two", "Description", List.of(Movie.Genre.ACTION));
        Movie thirdMovie = new Movie("Spirited Away", "Description", List.of(Genre.HISTORY));
        Movie fourthMovie = new Movie("The Empire Strikes Back", "Description", List.of(Movie.Genre.ADVENTURE));

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);
        movies.add(fourthMovie);

        String query = "";
        Movie.Genre genre = null;

        List<Movie> expected = movies;
        // when
        List<Movie> actual = FilterHelper.filterMovies(movies, query, genre);
        // then
        assertEquals(expected, actual);

    }
    @Test
    void if_a_query_was_set_and_no_genre_selected_only_movies_whos_title_or_description_contain_the_query_are_returned(){
        //given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie= new Movie("Knight and Day", "Description", List.of(Genre.ACTION, Genre.SCIENCE_FICTION));
        Movie secondMovie=new Movie("The Terminator", "Description", List.of(Genre.ROMANCE, Genre.ACTION, Genre.ACTION));
        Movie thirdMovie=new Movie("The Incredibles", "Description", List.of(Genre.COMEDY, Movie.Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION, Genre.FAMILY));

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);

        String query = "Terminator";

        List<Movie> expected = List.of(secondMovie);
        //when
        List<Movie> actual = FilterHelper.filterMovies(movies, query, null);
        // then
        assertEquals(expected, actual);

    }

    @Test
    void if_a_query_was_set_and_a_genre_is_selected_only_movies_with_that_genre_and_whos_title_or_description_contain_the_query_are_returned (){
        //given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie= new Movie("Knight and Day", "Description", List.of(Genre.ACTION, Genre.SCIENCE_FICTION));
        Movie secondMovie=new Movie("The Terminator", "Description", List.of(Genre.ROMANCE, Genre.ACTION, Genre.ACTION));
        Movie thirdMovie=new Movie("The Incredibles", "Description", List.of(Genre.COMEDY, Movie.Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION, Genre.FAMILY));

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);

        String query = "Terminator";
        Genre genre = Genre.ACTION;

        List<Movie> expected = List.of(secondMovie);
        //when
        List<Movie> actual = FilterHelper.filterMovies(movies, query, genre);
        // then
        assertEquals(expected, actual);

    }

}
