package Cars;

/***
 * Clasa abstracta (nu este instantiata).
 * Ajuta la gruparea obiectelor de tip vehicul.
 */
public abstract class Vehicul {
    private int cost;
    private int gauge;

    /***
     * Constructor fara parametrii.
     */
    protected Vehicul() {}

    /***
     * Constructor cu parametrii.
     * @param cost costul vehiculului.
     * @param gauge gabaritul vehiculului.
     */
    protected Vehicul(int cost, int gauge) {
        this.cost = cost;
        this.gauge = gauge;
    }

    /***
     * @return costul vehiculului.
     */
    public int getCost() {
        return cost;
    }

    /***
     * @return gabaritul vehiculului.
     */
    public int getGauge() {
        return gauge;
    }

    /***
     * Actualizeaza costul vehiculului.
     * @param cost cost.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /***
     * Actualizeaza gabaritul vehiculului.
     * @param gauge noul gabarit.
     */
    public void setGauge(int gauge) {
        this.gauge = gauge;
    }
}