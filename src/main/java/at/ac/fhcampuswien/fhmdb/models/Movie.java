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
        movies.add(new Movie("Zeke und Luther","Zeke und Luther wünschen sich nichts sehnlicher, als weltberühmte Skateboarder zu werden. Gemeinsam mit ihren Freunden, Skateboard-Rivalen und Familienmitgliedern geraten sie immer wieder in chaotische Abenteuer.")); // Komödie, Kids
        movies.add(new Movie("Avatar – Der Herr der Elemente ","Der als Avatar bekannte Junge muss vier elementare Kräfte beherrschen, um eine Welt im Krieg zu retten, und einen skrupellosen Feind besiegen, der dies verhindern will.")); // Sci-Fi & Fantasy, Action & Adventure, Drama
        movies.add(new Movie("Dune: Part Two","Pauls Rache nimmt formen an. Nachdem die Harkonnen seinen Vater umbrachten, hat Paul mittlerweile seine übernatürlichen, prophetische Kräfte endgültig manifestieren können. Er wächst immer mehr in seine Rolle als Anführer und prophezeiter Erlöser der Fremen hinein, wenn auch widerwillig.")); // Science Fiction, Abenteuer
        movies.add(new Movie("Dune","\"Dune\" erzählt die packende Geschichte des brillanten jungen Helden Paul Atreides, dem das Schicksal eine Rolle vorherbestimmt hat, von der er niemals geträumt hätte. Um die Zukunft seiner Familie und seines gesamten Volkes zu sichern, muss Paul auf den gefährlichsten Planeten des Universums reisen. Nur auf dieser Welt existiert ein wertvoller Rohstoff, der es der Menschheit ermöglichen könnte, ihr vollständiges geistiges Potenzial auszuschöpfen. Doch finstere Mächte wollen die Kontrolle über die kostbare Substanz an sich reißen. Es entbrennt ein erbitterter Kampf, den nur diejenigen überleben werden, die ihre eigenen Ängste besiegen.")); // Science Fiction, Abenteuer
        movies.add(new Movie("Poor Things","Eine junge Frau namens Bella Baxter wird von dem unkonventionellen Wissenschaftler Dr. Godwin Baxter zurück ins Leben gebracht. Unter Führung des brillanten Wissenschaftlers begibt sich Bella auf eine Reise zu sich selbst, immer auf der Suche nach der Lebenserfahrung, die ihr bisher fehlt. Sie trifft dabei unter anderem auf Duncan Wedderburn, einen Anwalt, der ihr die Welt jenseits der Wissenschaft zeigt und mit ihr ein wildes Abenteuer über mehrere Kontinente hinweg erlebt. Aber auch Baxters Student Max McCandless Leben ändern sich plötzlich, als er auf Bella trifft und von ihr regelrecht mit- und aus seinem behüteten Leben herausgerissen wird. Bella entdeckt Stück für Stück ihre Leidenschaft für soziale Gerechtigkeit und Befreiung und kann sich so auch ihrer eigenen Zwänge entledigen, Vorurteile hinter sich lassen und sich immer und immer mehr ausleben.")); // Science Fiction, Liebesfilm, Komödie
        movies.add(new Movie("Shōgun ","Wir schreiben das Jahr 1600, der Schauplatz ist Japan: Als Fürst Yoshii Toranaga um sein Leben kämpfen muss, nachdem sich seine Feinde im Regentschaftsrat gegen ihn verbündet haben, strandet in einem nahegelegenen Fischerdorf ein mysteriöses europäisches Schiff."));    // Drama, War & Politics
        movies.add(new Movie("Wonka","Bereits in jungen Jahren träumt Willy Wonka von seinem eigenen Schokoladengeschäft. Doch Schaum wie so manch anderer Traum ist das nicht. Mit dem Laden ist es ihm sehr ernst. Deshalb hat er auch viel Zeit damit verbracht, um die Welt zu reisen und an verschiedensten Orten seine Techniken zu verbessern. Doch bevor alles überhaupt richtig in Gang kommen kann, ist es schon fast wieder aus mit dem Traum vom eigenen Laden. Denn das mächtige Schokoladenkartell legt dem exzentrischen Wonka jede Menge Steine in den Weg. Aber ohne die Erlaubnis des Kartells geht nun mal leider gar nichts, die Ladentür muss verschlossen bleiben. Aber Wonka lässt sich auch davon nicht unterkriegen. Er sprudelt regelrecht vor Ideen, wie er seine schokoladigen Leckereien trotzdem unters Volk bringen kann. Alleine ist er dabei auch nicht. Die kleine Noodle ist ebenfalls mit dabei. Außerdem kann Wonka auf die Unterstützung der skurrilen Oompa Loompas setzen."));  // Komödie, Familie, Fantasy
        movies.add(new Movie("Oppenheimer","Als dem Physiker Julius Robert Oppenheimer während des Zweiten Weltkriegs die wissenschaftliche Leitung des Manhattan-Projekts übertragen wird, können er und seine Ehefrau Kitty sich nicht vorstellen, welche Auswirkungen Oppenheimers Arbeit nicht nur auf ihr Leben, sondern auf die ganze Welt haben wird. Im Los Alamos National Laboratory in New Mexico sollen er und sein Team unter der Aufsicht von Lt. Leslie Groves eine Nuklearwaffe entwickeln – was ihnen auch gelingt. Oppenheimer wird zum „Vater der Atombombe“ ausgerufen, doch dass seine tödliche Erfindung bald folgenschwer in Hiroshima und Nagasaki eingesetzt wird, lässt Oppenheimer Abstand von dem Projekt nehmen. Als der Krieg zu Ende geht, setzt sich Robert Oppenheimer als Berater der US-amerikanischen Atomenergiebehörde, die von Lewis Strauss mitbegründet wurde, für eine internationale Kontrolle von Kernenergie und gegen ein nukleares Wettrüsten ein – und gerät ins Visier des FBI."));    // Drama, Historie
        movies.add(new Movie("Avatar: The Way of Water","Mehr als zehn Jahre nach den Ereignissen des ersten Films haben Jake und Neytiri eine Familie gegründet. Ihre Kinder sind Neteyam, Lo’ak und Tuktirey, der adoptierte Menschenjunge Miles “Spider” Socorro und die adoptierte Na’vi-Teenagerin Kiri. Doch ihre Heimat ist weiterhin nicht sicher - das müssen sie feststellen, als die Resources Development Administration (RDA) unter Führung von General Ardmore mit noch mehr Militär und einem alten Bekannten nach Pandora zurückkehrt, um den Planeten zur neuen Heimat der Menschheit zu machen. Bald sehen sich Neytiri, Jake und ihre Familie gezwungen, ihr Zuhause zu verlassen und beim Na’vi-Stamm der Metkayina Zuflucht zu suchen, der an den Küsten und Meeren des Mondes Pandora lebt und von der schwangeren Ronal und ihrem Mann Tonowari angeführt wird."));   // Science Fiction, Abenteuer, Action

        return movies;
    }
}
