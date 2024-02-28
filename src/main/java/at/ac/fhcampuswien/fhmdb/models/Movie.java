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

        movies.add(new Movie("1917", "At the height of the First World War, two young British soldiers must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers.")); // WAR, ACTION, DRAMA
        movies.add((new Movie("The Lord of the Rings: The Two Towers", "Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard."))); // ADVENTURE, FANTASY, ACTION
        movies.add((new Movie("Back to the Future", "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985."))); // ADVENTURE, COMEDY, SCIENCE_FICTION
        movies.add((new Movie("Interstellar", "The adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage."))); // ADVENTURE, DRAMA, SCIENCE_FICTION
        movies.add((new Movie("Spirited Away", "A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family."))); // ANIMATION, FAMILY, FANTASY
        movies.add((new Movie("The Empire Strikes Back", "The epic saga continues as Luke Skywalker, in hopes of defeating the evil Galactic Empire, learns the ways of the Jedi from aging master Yoda. But Darth Vader is more determined than ever to capture Luke. Meanwhile, rebel leader Princess Leia, cocky Han Solo, Chewbacca, and droids C-3PO and R2-D2 are thrown into various stages of capture, betrayal and despair."))); //  ADVENTURE, ACTION, SCIENCE_FICTION
        movies.add((new Movie("Spider-Man: Across the Spider-Verse", "After reuniting with Gwen Stacy, Brooklyn’s full-time, friendly neighborhood Spider-Man is catapulted across the Multiverse, where he encounters the Spider Society, a team of Spider-People charged with protecting the Multiverse’s very existence. But when the heroes clash on how to handle a new threat, Miles finds himself pitted against the other Spiders and must set out on his own to save those he loves most."))); // ANIMATION, ACTION, ADVENTURE, SCIENCE_FICTION
        movies.add((new Movie("Whiplash", "Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity."))); // DRAMA, MUSIC
        movies.add((new Movie("A Silent Voice: The Movie", "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?"))); // ANIMATION, DRAMA
        movies.add((new Movie("Parasite", "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident."))); // COMEDY, THRILLER, DRAMA
        movies.add((new Movie("Forrest Gump", "A man with a low IQ has accomplished great things in his life and been present during significant historic events—in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him."))); // COMEDY, DRAMA, ROMANCE
        movies.add((new Movie("Pulp Fiction", "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time."))); // THRILLER, CRIME
        movies.add((new Movie("Your Name.", "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other."))); // ANIMATION, ROMANCE, DRAMA
        movies.add((new Movie("Oppenheimer", "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.")));

        return movies;
    }
}
