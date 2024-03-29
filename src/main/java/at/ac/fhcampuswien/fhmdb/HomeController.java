package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.HelperClasses.FilterHelper;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
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

    private ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    final List<Movie.Genre> genreList = allMovies.stream()
            .flatMap(m -> m.getGenres().stream())
            .distinct()
            .sorted()
            .collect(Collectors.toList());

    private FilterHelper filterHelper = new FilterHelper();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        observableMovies.addAll(allMovies);         // add dummy data to observable list

        // initialize UI stuff
        movieListView.setItems(observableMovies);   // set data of observable list to list view
        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // TODO add genre filter items with genreComboBox.getItems().addAll(...)

        //to filter movies by genre
        genreList.add(0,Movie.Genre.ALL);
        genreComboBox.getItems().addAll(genreList);
        genreComboBox.setValue(Movie.Genre.ALL);

        genreComboBox.setOnAction(event -> {

        });


        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        searchBtn.setOnAction(actionEvent -> {

            List<Movie> filteredMovies = filterHelper.filterMovies(allMovies, searchField.getText(), (Movie.Genre) genreComboBox.getSelectionModel().getSelectedItem());

            if (filteredMovies.isEmpty()) {
                observableMovies.clear();
                movieListView.setPlaceholder(new Label("No Movies found"));
            } else {
                observableMovies = FXCollections.observableArrayList(filteredMovies);
                movieListView.setItems(observableMovies);
                movieListView.setCellFactory(movieListView -> new MovieCell());
            }
        });

        // Sort button example:
        sortBtn.setOnAction(actionEvent -> {
            if (sortBtn.getText().equals("Sort (asc)")) {
                // TODO sort observableMovies ascending
                observableMovies = FXCollections.observableArrayList(filterHelper.sort(observableMovies, true));
                movieListView.setItems(observableMovies);
                movieListView.setCellFactory(movieListView -> new MovieCell());
                sortBtn.setText("Sort (desc)");
            } else {
                // TODO sort observableMovies descending
                observableMovies = FXCollections.observableArrayList(filterHelper.sort(observableMovies, false));
                movieListView.setItems(observableMovies);
                movieListView.setCellFactory(movieListView -> new MovieCell());
                sortBtn.setText("Sort (asc)");
            }
        });


    }
}