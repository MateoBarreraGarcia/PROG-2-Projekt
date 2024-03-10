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

        List<Movie> expected = List.of(firstMovie, secondMovie, thirdMovie, fourthMovie);
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

    // Tests for public List<Movie> filterMovies(List<Movie> movies, String searchString, Movie.Genre genre)
    @Test
    void if_the_movielist_to_filter_is_empty_an_error_is_thrown() {
        // given
        FilterHelper filterHelper = new FilterHelper();
        List<Movie> movies = new ArrayList<>();
        // when and then
        assertThrows(IllegalArgumentException.class, () -> filterHelper.filterMovies(movies, "", Genre.ALL));
    }

    @Test
    void if_the_movielist_to_filter_is_null_an_error_is_thrown() {
        // given
        FilterHelper filterHelper = new FilterHelper();
        // when and then
        assertThrows(NullPointerException.class, () -> filterHelper.filterMovies(null, "", Genre.ALL));
    }

    @Test
    void if_the_query_is_null_an_error_is_thrown() {
        // given
        FilterHelper filterHelper = new FilterHelper();
        List<Movie> movies = List.of(new Movie("Dune", "Description", List.of(Movie.Genre.ADVENTURE, Genre.ROMANCE)),
                new Movie("Dune: Part Two", "Description", List.of(Movie.Genre.ACTION)),
                new Movie("Spirited Away", "Description", List.of(Genre.HISTORY)),
                new Movie("The Empire Strikes Back", "Description", List.of(Movie.Genre.ADVENTURE)));

        // when and then
        assertThrows(NullPointerException.class, () -> filterHelper.filterMovies(movies, null, Genre.ALL));
    }

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

        List<Movie> expected = List.of(firstMovie, fourthMovie);
        // when
        List<Movie> actual = filterHelper.filterMovies(movies, query, genre);
        // then
        assertEquals(expected, actual);
    }

    @Test
    void if_no_query_was_set_and_no_genre_selected_the_initial_list_is_returned() {
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
        Movie.Genre genre = Genre.ALL;

        List<Movie> expected = movies;
        // when
        List<Movie> actual = filterHelper.filterMovies(movies, query, genre);
        // then
        assertEquals(expected, actual);

    }

    @Test
    void if_a_query_was_set_and_no_genre_selected_only_movies_whos_title_or_description_contain_the_query_are_returned() {
        //given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie = new Movie("Knight and Day", "Description", List.of(Genre.ACTION, Genre.SCIENCE_FICTION));
        Movie secondMovie = new Movie("The Terminator", "Description", List.of(Genre.ROMANCE, Genre.ACTION, Genre.ACTION));
        Movie thirdMovie = new Movie("The Incredibles", "Description", List.of(Genre.COMEDY, Movie.Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION, Genre.FAMILY));

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);

        String query = "Terminator";

        List<Movie> expected = List.of(secondMovie);
        //when
        List<Movie> actual = filterHelper.filterMovies(movies, query, Genre.ALL);
        // then
        assertEquals(expected, actual);

    }

    @Test
    void if_a_query_was_set_and_a_genre_is_selected_only_movies_with_that_genre_and_whos_title_or_description_contain_the_query_are_returned() {
        //given
        FilterHelper filterHelper = new FilterHelper();

        Movie firstMovie = new Movie("Knight and Day", "Description", List.of(Genre.ACTION, Genre.SCIENCE_FICTION));
        Movie secondMovie = new Movie("The Terminator", "Description", List.of(Genre.ROMANCE, Genre.ACTION, Genre.ACTION));
        Movie thirdMovie = new Movie("The Incredibles", "Description", List.of(Genre.COMEDY, Movie.Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION, Genre.FAMILY));

        List<Movie> movies = new ArrayList<>();
        movies.add(firstMovie);
        movies.add(secondMovie);
        movies.add(thirdMovie);

        String query = "Terminator";
        Genre genre = Genre.ACTION;

        List<Movie> expected = List.of(secondMovie);
        //when
        List<Movie> actual = filterHelper.filterMovies(movies, query, genre);
        // then
        assertEquals(expected, actual);

    }

    private List<Movie> createTestDataList() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1917", "At the height of the First World War, two young British soldiers must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers.", List.of(Genre.DRAMA, Genre.WAR)));
        movies.add((new Movie("The Lord of the Rings: The Two Towers", "Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard.", List.of(Genre.FANTASY, Genre.ADVENTURE))));
        movies.add((new Movie("Back to the Future", "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.", List.of(Genre.COMEDY, Genre.FAMILY, Genre.SCIENCE_FICTION))));
        movies.add((new Movie("Interstellar", "The adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.", List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE))));
        movies.add((new Movie("Spirited Away", "A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.", List.of(Genre.ADVENTURE))));
        movies.add((new Movie("The Empire Strikes Back", "The epic saga continues as Luke Skywalker, in hopes of defeating the evil Galactic Empire, learns the ways of the Jedi from aging master Yoda. But Darth Vader is more determined than ever to capture Luke. Meanwhile, rebel leader Princess Leia, cocky Han Solo, Chewbacca, and droids C-3PO and R2-D2 are thrown into various stages of capture, betrayal and despair.", List.of(Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.FANTASY))));
        movies.add((new Movie("Spider-Man: Across the Spider-Verse", "After reuniting with Gwen Stacy, Brooklyn’s full-time, friendly neighborhood Spider-Man is catapulted across the Multiverse, where he encounters the Spider Society, a team of Spider-People charged with protecting the Multiverse’s very existence. But when the heroes clash on how to handle a new threat, Miles finds himself pitted against the other Spiders and must set out on his own to save those he loves most.", List.of(Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION))));
        movies.add((new Movie("Whiplash", "Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.", List.of(Genre.DRAMA, Genre.MUSICAL))));
        movies.add((new Movie("A Silent Voice: The Movie", "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?", List.of(Genre.ANIMATION, Genre.DRAMA))));
        movies.add((new Movie("Parasite", "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.", List.of(Genre.DRAMA, Genre.THRILLER, Genre.COMEDY))));
        movies.add((new Movie("Forrest Gump", "A man with a low IQ has accomplished great things in his life and been present during significant historic events—in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him.", List.of(Genre.DRAMA, Genre.COMEDY))));
        movies.add((new Movie("Pulp Fiction", "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.", List.of(Genre.THRILLER, Genre.DRAMA, Genre.COMEDY, Genre.CRIME))));
        movies.add((new Movie("Your Name.", "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.", List.of(Genre.FANTASY, Genre.DRAMA, Genre.ROMANCE))));

        movies.add((new Movie("Knight and Day", "A young woman gets mixed up with a disgraced spy who is trying to clear his name.", List.of(Genre.ACTION, Genre.SCIENCE_FICTION))));//ACTION,SCIENCE_FICTION
        movies.add((new Movie("The Terminator", "A human soldier is sent from 2029 to 1984 to stop an almost indestructible cyborg killing machine, sent from the same year, which has been programmed to execute a young woman whose unborn son is the key to humanity's future salvation.", List.of(Genre.ROMANCE, Genre.ACTION, Genre.ACTION)))); //ROMANCE
        movies.add((new Movie("The Incredibles", "While trying to lead a quiet suburban life, a family of undercover superheroes are forced into action to save the world.", List.of(Genre.COMEDY, Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION, Genre.FAMILY)))); //
        movies.add((new Movie("Modern Times", "The Tramp struggles to live in modern industrial society with the help of a young homeless woman.", List.of(Genre.COMEDY, Genre.DRAMA)))); //
        movies.add((new Movie("The Conjuring", "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.", List.of(Genre.HORROR, Genre.THRILLER)))); //
        movies.add((new Movie("Toy Story", "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", List.of(Genre.COMEDY, Genre.ANIMATION, Genre.FAMILY, Genre.ADVENTURE)))); //
        movies.add(new Movie("Django Unchained", "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation owner in Mississippi.", List.of(Genre.WESTERN, Genre.DRAMA)));
        movies.add(new Movie("The Iron Claw", "The true story of the inseparable Von Erich brothers, who made history in the intensely competitive world of professional wrestling in the early 1980s.", List.of(Genre.SPORT, Genre.BIOGRAPHY, Genre.DRAMA)));
        movies.add(new Movie("Baywatch: The Documentary", "Matt (producer), Nicole Eggert (Summer Quinn) and Jeremy Jackson (Hobie) all three examine why Baywatch became the most watched TV show in the world.", List.of(Genre.DOCUMENTARY)));
        return movies;
    }

    @Test
    void if_a_query_was_set_but_not_found_an_empty_list_is_returned() {
        // given
        FilterHelper filterHelper = new FilterHelper();

        List<Movie> movies = createTestDataList();

        List<Movie> expected = new ArrayList<>();
        // when
        List<Movie> actual = filterHelper.filterMovies(movies, "ThisIsAQuery", Genre.ALL);
        // then
        assertEquals(expected, actual);
    }

    @Test
    void if_a_genre_was_selected_but_not_found_an_empty_list_is_returned() {
        // given
        FilterHelper filterHelper = new FilterHelper();

        List<Movie> movies = createTestDataList();

        List<Movie> expected = new ArrayList<>();
        // when
        List<Movie> actual = filterHelper.filterMovies(movies, "", Genre.MYSTERY);
        // then
        assertEquals(expected, actual);
    }

    @Test
    void leading_and_trailing_spaces_in_the_query_are_removed_and_the_filtering_is_continued_with_the_resulting_string() {
        // given
        FilterHelper filterHelper = new FilterHelper();

        List<Movie> movies = createTestDataList();

        List<Movie> expected = List.of(movies.get(13));
        // when
        List<Movie> actual = filterHelper.filterMovies(movies, "       Knight and Day      ", Genre.ALL);
        // then
        assertEquals(expected, actual);
    }
}
