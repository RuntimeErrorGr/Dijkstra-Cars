package Map;

/***
 * Clasa instantiata la intalnirea comenzii addRestriction cu primul parametru "accident".
 */
public class Accident extends Ambuteiaj {

    /***
     * Constructor fara parametrii.
     */
    public Accident() {
        super();
    }

    /***
     * Constructor cu parametrii.
     * Are intotdeauna tipul "accident".
     * @param cost costul accidentului.
     * @param start numele nodului de start al strazii pe care este adaugat accidentul.
     * @param stop numele nodului de stop al strazii pe care este adaugat accidentul.
     */
    public Accident(int cost, String start, String stop) {
        super(cost, "accident", start, stop);
    }
}
