package at.ac.fhcampuswien.fhmdb.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Movie implements Comparable<Movie> {
    private String title;
    private String description;
    // TODO add more properties here
    private List<Genre> genres;

    public Movie(String title, String description, List<Genre> genres)
    {
        this.title = title;
        this.description = description;
        this.genres = genres;
    }

    public List <Genre> getGenres()
    {
        return genres;
    }

    public void setGenres(List<Genre> genres)
    {
        this.genres = genres;
    }

    public String getTitle()
    {
        return title;
    }

    public String getDescription()
    {
        return description;
    }

    public static List<Movie> initializeMovies()
    {
        List<Movie> movies = new ArrayList<>();
        // TODO add some dummy data here
        movies.add(new Movie("Zeke and Luther", "Zeke and Luther want nothing more in the world than to become world-famous skateboarders. Together with their friends, skating rivals, and family, Zeke & Luther find themselves always busy getting into mischief.", List.of(Genre.COMEDY))); // Komödie, Kids
        movies.add(new Movie("Avatar: The Last Airbender", "In a war-torn world of elemental magic, a young boy reawakens to undertake a dangerous mystic quest to fulfill his destiny as the Avatar, and bring peace to the world.", List.of(Genre.ACTION,Genre.ADVENTURE,Genre.ANIMATION, Genre.SCIENCE_FICTION))); // Sci-Fi & Fantasy, Action & Adventure, Animaion
        movies.add(new Movie("Dune: Part Two", "Follow the mythic journey of Paul Atreides as he unites with Chani and the Fremen while on a path of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, Paul endeavors to prevent a terrible future only he can foresee.", List.of(Genre.ADVENTURE,Genre.SCIENCE_FICTION))); // Science Fiction, Abenteuer
        movies.add(new Movie("Dune", "Paul Atreides, a brilliant and gifted young man born into a great destiny beyond his understanding, must travel to the most dangerous planet in the universe to ensure the future of his family and his people. As malevolent forces explode into conflict over the planet's exclusive supply of the most precious resource in existence-a commodity capable of unlocking humanity's greatest potential-only those who can conquer their fear will survive.", List.of(Genre.ADVENTURE, Genre.SCIENCE_FICTION))); // Science Fiction, Abenteuer
        movies.add(new Movie("Poor Things", "Brought back to life by an unorthodox scientist, a young woman runs off with a debauched lawyer on a whirlwind adventure across the continents. Free from the prejudices of her times, she grows steadfast in her purpose to stand for equality and liberation.", List.of(Genre.COMEDY, Genre.ROMANCE, Genre.SCIENCE_FICTION))); // Science Fiction, Liebesfilm, Komödie
        movies.add(new Movie("Shōgun ", "In Japan in the year 1600, at the dawn of a century-defining civil war, Lord Yoshii Toranaga is fighting for his life as his enemies on the Council of Regents unite against him, when a mysterious European ship is found marooned in a nearby fishing village.", List.of(Genre.ACTION, Genre.DRAMA, Genre.WAR)));    // Drama, War & Politics
        movies.add(new Movie("Wonka", "Willy Wonka – chock-full of ideas and determined to change the world one delectable bite at a time – is proof that the best things in life begin with a dream, and if you’re lucky enough to meet Willy Wonka, anything is possible.", List.of(Genre.COMEDY, Genre.FAMILY, Genre.FANTASY)));  // Komödie, Familie, Fantasy
        movies.add(new Movie("Oppenheimer", "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.", List.of(Genre.DRAMA, Genre.HISTORY)));    // Drama, Historie
        movies.add(new Movie("Avatar: The Way of Water", "Set more than a decade after the events of the first film, learn the story of the Sully family (Jake, Neytiri, and their kids), the trouble that follows them, the lengths they go to keep each other safe, the battles they fight to stay alive, and the tragedies they endure.", List.of(Genre.ACTION, Genre.ADVENTURE, Genre.SCIENCE_FICTION)));   // Science Fiction, Abenteuer, Action

        movies.add(new Movie("1917", "At the height of the First World War, two young British soldiers must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers.", List.of(Genre.DRAMA, Genre.WAR)));
        movies.add((new Movie("The Lord of the Rings: The Two Towers", "Frodo and Sam are trekking to Mordor to destroy the One Ring of Power while Gimli, Legolas and Aragorn search for the orc-captured Merry and Pippin. All along, nefarious wizard Saruman awaits the Fellowship members at the Orthanc Tower in Isengard.",List.of(Genre.FANTASY, Genre.ADVENTURE))));
        movies.add((new Movie("Back to the Future", "Eighties teenager Marty McFly is accidentally sent back in time to 1955, inadvertently disrupting his parents' first meeting and attracting his mother's romantic interest. Marty must repair the damage to history by rekindling his parents' romance and - with the help of his eccentric inventor friend Doc Brown - return to 1985.", List.of(Genre.COMEDY, Genre.FAMILY, Genre.SCIENCE_FICTION))));
        movies.add((new Movie("Interstellar", "The adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.", List.of(Genre.SCIENCE_FICTION, Genre.ADVENTURE))));
        movies.add((new Movie("Spirited Away", "A young girl, Chihiro, becomes trapped in a strange new world of spirits. When her parents undergo a mysterious transformation, she must call upon the courage she never knew she had to free her family.", List.of(Genre.ADVENTURE))));
        movies.add((new Movie("The Empire Strikes Back", "The epic saga continues as Luke Skywalker, in hopes of defeating the evil Galactic Empire, learns the ways of the Jedi from aging master Yoda. But Darth Vader is more determined than ever to capture Luke. Meanwhile, rebel leader Princess Leia, cocky Han Solo, Chewbacca, and droids C-3PO and R2-D2 are thrown into various stages of capture, betrayal and despair.", List.of(Genre.ADVENTURE, Genre.SCIENCE_FICTION, Genre.FANTASY))));
        movies.add((new Movie("Spider-Man: Across the Spider-Verse", "After reuniting with Gwen Stacy, Brooklyn’s full-time, friendly neighborhood Spider-Man is catapulted across the Multiverse, where he encounters the Spider Society, a team of Spider-People charged with protecting the Multiverse’s very existence. But when the heroes clash on how to handle a new threat, Miles finds himself pitted against the other Spiders and must set out on his own to save those he loves most.", List.of(Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION))));
        movies.add((new Movie("Whiplash", "Under the direction of a ruthless instructor, a talented young drummer begins to pursue perfection at any cost, even his humanity.", List.of(Genre.DRAMA,Genre.MUSICAL))));
        movies.add((new Movie("A Silent Voice: The Movie", "Shouya Ishida starts bullying the new girl in class, Shouko Nishimiya, because she is deaf. But as the teasing continues, the rest of the class starts to turn on Shouya for his lack of compassion. When they leave elementary school, Shouko and Shouya do not speak to each other again... until an older, wiser Shouya, tormented by his past behaviour, decides he must see Shouko once more. He wants to atone for his sins, but is it already too late...?", List.of(Genre.ANIMATION, Genre.DRAMA))));
        movies.add((new Movie("Parasite", "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.", List.of(Genre.DRAMA, Genre.THRILLER, Genre.COMEDY))));
        movies.add((new Movie("Forrest Gump", "A man with a low IQ has accomplished great things in his life and been present during significant historic events—in each case, far exceeding what anyone imagined he could do. But despite all he has achieved, his one true love eludes him.", List.of(Genre.DRAMA, Genre.COMEDY))));
        movies.add((new Movie("Pulp Fiction", "A burger-loving hit man, his philosophical partner, a drug-addled gangster's moll and a washed-up boxer converge in this sprawling, comedic crime caper. Their adventures unfurl in three stories that ingeniously trip back and forth in time.", List.of(Genre.THRILLER, Genre.DRAMA, Genre.COMEDY, Genre.CRIME))));
        movies.add((new Movie("Your Name.", "High schoolers Mitsuha and Taki are complete strangers living separate lives. But one night, they suddenly switch places. Mitsuha wakes up in Taki’s body, and he in hers. This bizarre occurrence continues to happen randomly, and the two must adjust their lives around each other.", List.of(Genre.FANTASY, Genre.DRAMA, Genre.ROMANCE))));

        movies.add((new Movie("Knight and Day", "A young woman gets mixed up with a disgraced spy who is trying to clear his name.", List.of(Genre.ACTION, Genre.SCIENCE_FICTION))));//ACTION,SCIENCE_FICTION
        movies.add((new Movie("The Terminator", "A human soldier is sent from 2029 to 1984 to stop an almost indestructible cyborg killing machine, sent from the same year, which has been programmed to execute a young woman whose unborn son is the key to humanity's future salvation.", List.of(Genre.ROMANCE, Genre.ACTION)))); //ROMANCE
        movies.add((new Movie("The Incredibles", "While trying to lead a quiet suburban life, a family of undercover superheroes are forced into action to save the world.", List.of(Genre.COMEDY, Genre.ADVENTURE, Genre.ACTION, Genre.ANIMATION, Genre.FAMILY)))); //
        movies.add((new Movie("Modern Times", "The Tramp struggles to live in modern industrial society with the help of a young homeless woman.", List.of(Genre.COMEDY, Genre.DRAMA)))); //
        movies.add((new Movie("The Conjuring", "Paranormal investigators Ed and Lorraine Warren work to help a family terrorized by a dark presence in their farmhouse.", List.of(Genre.HORROR, Genre.THRILLER)))); //
        movies.add((new Movie("Toy Story", "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.", List.of(Genre.COMEDY, Genre.ANIMATION, Genre.FAMILY, Genre.ADVENTURE)))); //
        movies.add(new Movie("Django Unchained", "With the help of a German bounty-hunter, a freed slave sets out to rescue his wife from a brutal plantation owner in Mississippi.", List.of(Genre.WESTERN, Genre.DRAMA)));
        movies.add(new Movie("The Iron Claw", "The true story of the inseparable Von Erich brothers, who made history in the intensely competitive world of professional wrestling in the early 1980s.", List.of(Genre.SPORT, Genre.BIOGRAPHY, Genre.DRAMA)));
        movies.add(new Movie("Baywatch: The Documentary", "Matt (producer), Nicole Eggert (Summer Quinn) and Jeremy Jackson (Hobie) all three examine why Baywatch became the most watched TV show in the world.", List.of(Genre.DOCUMENTARY)));

        return movies;
    }

    @Override
    public int compareTo(Movie other) {
        return this.getTitle().compareTo(other.getTitle()); // Movies are compared by their title; the .compareTo method of String compares them lexicographically
    }

    public static enum Genre {
        ALL ("All"),
        ACTION("Action"),
        ADVENTURE("Adventure"),
        ANIMATION("Animation"),
        BIOGRAPHY("Biography"),
        COMEDY("Comedy"),
        CRIME("Crime"),
        DRAMA("Drama"),
        DOCUMENTARY("Documentary"),
        FAMILY("Family"),
        FANTASY("Fantasy"),
        HISTORY("History"),
        HORROR("Horror"),
        MUSICAL("Musical"),
        MYSTERY("Mystery"),
        ROMANCE("Romance"),
        SCIENCE_FICTION("Science Fiction"),
        SPORT("Sport"),
        THRILLER("Thriller"),
        WAR("War"),
        WESTERN("Western"),
        UNKNOWN ("Unknown");    // Used for Genres which do not fit the predefined Genres

        public final String label;

        private Genre(String lable){
            this.label = lable;
        }
        public String getLabel(){
            return label;
        }
        //checks if given Genre object is valid otherwise it returns false
        public static boolean validGenre (Genre genre){
            for (Genre g:Genre.values()){
                if (g==genre){
                    return true;
                }
            }
            return false;
        }
    }
}
