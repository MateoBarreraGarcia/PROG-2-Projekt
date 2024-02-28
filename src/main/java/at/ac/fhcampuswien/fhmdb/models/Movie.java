package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String title;
    private String description;
    // TODO add more properties here

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static List<Movie> initializeMovies(){
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        movies.add(new Movie("Zeke and Luther","Zeke and Luther want nothing more in the world than to become world-famous skateboarders. Together with their friends, skating rivals, and family, Zeke & Luther find themselves always busy getting into mischief.")); // Komödie, Kids
        movies.add(new Movie("Avatar: The Last Airbender","In a war-torn world of elemental magic, a young boy reawakens to undertake a dangerous mystic quest to fulfill his destiny as the Avatar, and bring peace to the world.")); // Sci-Fi & Fantasy, Action & Adventure, Animation
        movies.add(new Movie("Dune: Part Two","Follow the mythic journey of Paul Atreides as he unites with Chani and the Fremen while on a path of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, Paul endeavors to prevent a terrible future only he can foresee.")); // Science Fiction, Abenteuer
        movies.add(new Movie("Dune","Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.")); // Science Fiction, Abenteuer
        movies.add(new Movie("Poor Things","Brought back to life by an unorthodox scientist, a young woman runs off with a debauched lawyer on a whirlwind adventure across the continents. Free from the prejudices of her times, she grows steadfast in her purpose to stand for equality and liberation.")); // Science Fiction, Liebesfilm, Komödie
        movies.add(new Movie("Shōgun ","In Japan in the year 1600, at the dawn of a century-defining civil war, Lord Yoshii Toranaga is fighting for his life as his enemies on the Council of Regents unite against him, when a mysterious European ship is found marooned in a nearby fishing village."));    // Drama, War & Politics
        movies.add(new Movie("Wonka","Willy Wonka – chock-full of ideas and determined to change the world one delectable bite at a time – is proof that the best things in life begin with a dream, and if you’re lucky enough to meet Willy Wonka, anything is possible."));  // Komödie, Familie, Fantasy
        movies.add(new Movie("Oppenheimer","The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II."));    // Drama, Historie
        movies.add(new Movie("Avatar: The Way of Water","Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure."));   // Science Fiction, Abenteuer, Action

        return movies;
    }
}
