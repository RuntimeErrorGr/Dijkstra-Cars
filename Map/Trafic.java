package Map;

/***
 * Clasa instantiata la intalnirea comenzii addRestriction cu primul parametru "trafic".
 */
public class Trafic extends Ambuteiaj {

    /***
     * Constructor fara parametrii.
     */
    public Trafic() {
        super();
    }

    /***
     * Constructor cu parametrii.
     * Are intotdeauna tipul "trafic".
     * @param cost costul traficului.
     * @param start numele nodului de start al strazii pe care este adaugat traficul.
     * @param stop numele nodului de stop al strazii pe care este adaugat traficul.
     */
    public Trafic(int cost, String start, String stop) {
        super(cost, "trafic", start, stop);
    }
}
