package Cars;

/***
 * Clasa abstracta (nu este instantiata).
 * Ajuta la gruparea obiectelor cu acelasi gabarit.
 */
public abstract class Autovehicul extends Vehicul {

    /***
     * Constructor fara parametrii.
     * Gabaritul unui autovehicul este intotdeauna 2.
     */
    protected Autovehicul() {
        super();
        setGauge(2);
    }
}