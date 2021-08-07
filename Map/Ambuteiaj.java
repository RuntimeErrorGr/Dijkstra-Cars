package Map;
/***
 * Clasa abstracta (nu este instantiata).
 * Ajuta la gruparea obiectelor ambuteiaj.
 */
public abstract class Ambuteiaj {
    private String tip;
    private int cost;
    private String start;
    private String stop;

    /***
     * Constructor fara parametrii.
     */
    protected Ambuteiaj() {}

    /***
     * Constructor cu parametrii.
     * @param cost cost ambuteiaj.
     * @param tip tipul ambuteiajului (trafic/blocaj/accident).
     * @param start numele nodului de start al strazii pe care este adaugat amjuteiajul.
     * @param stop numele nodului de stop al strazii pe care este adaugat amjuteiajul.
     */
    protected Ambuteiaj(int cost, String tip, String start, String stop) {
        this.cost = cost;
        this.tip = tip;
        this.start = start;
        this.stop = stop;
    }

    /***
     * @return costul ambuteiajului.
     */
    public int getCost() {
        return this.cost;
    }

    /***
     * @return numele nodului de start al strazii pe care este adaugat amjuteiajul.
     */
    public String getStart() {
        return this.start;
    }

    /***
     * @return tipul ambuteiajului (trafic/blocaj/accident).
     */
    public String getTip() {
        return this.tip;
    }

    /***
     * @return numele nodului de stop al strazii pe care este adaugat amjuteiajul.
     */
    public String getStop() {
        return this.stop;
    }

    /***
     * Actualizeaza costul ambuteiajului.
     * @param cost noul cost.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /***
     * Actualizeaza numele nodului de start al strazii pe care este adaugat amjuteiajul.
     * @param start noul nume al nodului de start.
     */
    public void setStart(String start) {
        this.start = start;
    }

    /***
     * Actualizeaza numele nodului de stop al strazii pe care este adaugat amjuteiajul.
     * @param stop noul nume al nodului de stop.
     */
    public void setStop(String stop) {
        this.stop = stop;
    }
}
