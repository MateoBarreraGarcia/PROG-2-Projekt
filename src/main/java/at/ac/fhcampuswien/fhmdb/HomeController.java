package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        Movie movie= new Movie("Titel", "Beschreibung", List.of("ACTION",
                "ADVENTURE","ANIMATION","BIOGRAPHY","COMEDY","CRIME","DRAMA","DOCUMENTARY",
                "FAMILY","FANTASY","HISORY","HORROR","MUSICAL","MYSTERY","ROMANCE",
                "SCIENCE_FICTION","SPORT","THRILLER","WAR","WESTERN"));
        observableMovies.add(movie);

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)
        List<String> availableGenres = allMovies.stream()
                        .flatMap(m -> m.getGenres().stream())
                                .distinct()
                                        .sorted()
                                                .collect(Collectors.toList());

        genreComboBox.getItems().addAll(availableGenres);
        genreComboBox.setPromptText("Filter by Genre");

        genreComboBox.setOnAction(event -> {String selectedGenre= (String) genreComboBox.getSelectionModel().getSelectedItem();
            if (selectedGenre != null && !selectedGenre.isEmpty()) {
                // Filtere die Filme nach dem ausgewählten Genre
                ObservableList<Movie> filteredMovies = FXCollections.observableArrayList(
                        observableMovies.stream()
                                .filter(m -> m.getGenres().contains(selectedGenre))
                                .collect(Collectors.toList())
                );
                movieListView.setItems(filteredMovies);
            } else {
                // Wenn kein Genre ausgewählt ist, zeige alle Filme an
                movieListView.setItems(observableMovies);
            }
        });



        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                sortBtn.setText("Sort (desc)");
            } else {
                // TODO sort observableMovies descending
                sortBtn.setText("Sort (asc)");
            }
        });


    }
}