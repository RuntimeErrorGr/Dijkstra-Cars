package Map;

/***
 * Clasa instantiata la intalnirea comenzii addRestriction cu primul parametru "blocaj".
 */
public class Blocaj extends Ambuteiaj {

    /***
     * Constructor fara parametrii.
     */
    public Blocaj() {
        super();
    }

    /***
     * Constructor cu parametrii.
     * Are intotdeauna tipul "blocaj".
     * @param cost costul blocajului.
     * @param start numele nodului de start al strazii pe care este adaugat blocajul.
     * @param stop numele nodului de stop al strazii pe care este adaugat blocajul.
     */
    public Blocaj(int cost, String start, String stop) {
        super(cost, "blocaj", start, stop);
    }
}
