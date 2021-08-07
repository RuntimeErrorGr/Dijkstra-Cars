package Cars;

/***
 * Clasa instantiata la intalnirea comenzii drive cu primul parametru "a".
 * Mosteneste clasa Autovehicul pentru ca gabaritul unui autoturism este intotdeauna 2.
 */
public class Autoturism extends Autovehicul {

    /***
     * Constructor fara parametrii.
     * Costul unui autoturism este intotdeauna 4.
     */
    public Autoturism() {
        super();
        setCost(4);
    }
}