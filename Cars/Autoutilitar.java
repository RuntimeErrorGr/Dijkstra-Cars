package Cars;

/***
 * Clasa abstracta (nu este instantiata).
 * Ajuta la gruparea obiectelor cu acelasi gabarit.
 */
public abstract class Autoutilitar extends Vehicul {

    /***
     * Constructor fara parametrii.
     * Gabaritul unui autoutilitar este intotdeauna 3.
     */
    protected Autoutilitar() {
        super();
        setGauge(3);
    }
}