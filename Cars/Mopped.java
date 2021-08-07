package Cars;

/***
 * Clasa abstracta (nu este instantiata).
 * Ajuta la gruparea obiectelor cu acelasi gabarit.
 */
public abstract class Mopped extends Vehicul {

    /***
     * Constructor fara parametrii.
     * Gabaritul unui mopped este intotdeauna 1.
     */
    protected Mopped() {
        super();
        setGauge(1);
    }
}