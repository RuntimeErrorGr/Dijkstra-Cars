package Cars;

/***
 * Clasa instantiata la intalnirea comenzii drive cu primul parametru "m".
 * Mosteneste clasa Mopped pentru ca gabaritul unei motociclete este intotdeauna 1.
 */
public class Motocicleta extends Mopped {

    /***
     * Constructor fara parametrii.
     * Costul unei motociclete este intotdeauna 2.
     */
    public Motocicleta() {
        super();
        setCost(2);
    }
}