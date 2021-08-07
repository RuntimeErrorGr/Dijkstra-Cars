package Cars;

/***
 * Clasa instantiata la intalnirea comenzii drive cu primul parametru "b".
 * Mosteneste clasa Mopped pentru ca gabaritul unei Biciclete este intotdeauna 1.
 */
public class Bicicleta extends Mopped  {

    /***
     * Constructor fara parametrii.
     * Costul unei biciclete este intotdeauna 1.
     */
    public Bicicleta() {
        super();
        setCost(1);
    }
}
