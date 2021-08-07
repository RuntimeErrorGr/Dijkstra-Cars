package Cars;

/***
 * Clasa instantiata la intalnirea comenzii drive cu primul parametru "c".
 * Mosteneste clasa Autoutilitar pentru ca gabaritul unui autoturism este intotdeauna 3.
 */
public class Camion extends Autoutilitar {

    /***
     * Constructor fara parametrii.
     * Costul unui camion este intotdeauna 6.
     */
    public Camion() {
        super();
        setCost(6);
    }
}
