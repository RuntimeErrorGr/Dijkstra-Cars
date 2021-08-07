package Map;
import java.util.*;

public class Strada implements Comparator<Strada> {
    private String[] name;
    private String start;
    private String stop;
    private int cost;
    private int gaugeLimit;
    private List<Ambuteiaj> trafficJams;

    /***
     * Constructor fara parametrii.
     */
    public Strada() {}

    /***
     * Constructor cu parametrii.
     * @param name numele strazii.
     * @param start numele nodului de start al strazii.
     * @param stop numele nodului de stop al strazii.
     * @param cost costul strazii (limita de viteza).
     * @param gaugeLimit limita de gabarit a strazii.
     * @param trafficJams lista de restrictii a strazii.
     */
    public Strada(String[] name, String start, String stop, int cost, int gaugeLimit, List<Ambuteiaj> trafficJams) {
        this.name = name;
        this.start = start;
        this.stop = stop;
        this.cost = cost;
        this.gaugeLimit = gaugeLimit;
        this.trafficJams = trafficJams;
    }

    /***
     * Constructor ce initializeaza numele punctelor de start si de stop ale strazii.
     * Este folosit in algoritmul Dijsktra pentru a crea primul obiect ce este adaugat in coada
     * de prioritati. Pentru acesta sunt necesare numai coordonatele.
     * @param start numele nodului de start al strazii.
     * @param stop numele nodului de stop al strazii.
     */
    public Strada(String start, String stop) {
        this.start = start;
        this.stop = stop;
        this.name = new String[2];
        this.name[0] = start;
        this.name[1] = stop;
    }

    /***
     * Constructor cu parametrii, fara lista de restrictii.
     * Este folosit pentru a crea un obiect atunci cand lista de restrictii pentru o strada
     * inca nu a fost citita.
     * @param start numele nodului de start al strazii.
     * @param stop numele nodului de stop al strazii.
     * @param cost costul strazii (limita de viteza).
     * @param gaugeLimit limita de gabarit a strazii.
     */
    public Strada(String start, String stop, int cost, int gaugeLimit) {
        this.start = start;
        this.stop = stop;
        this.cost = cost;
        this.gaugeLimit = gaugeLimit;
        this.name = new String[2];
        this.name[0] = start;
        this.name[1] = stop;
        this.trafficJams = new ArrayList<Ambuteiaj>();
    }


    /***
     * Numele este format din numele nodului de start + numele nodului de stop.
     * @return numele strazii.
     */
    public String[] getName() {
        return name;
    }

    /***
     * @return costul (limita de viteza) a strazii.
     */
    public int getCost() {
        return cost;
    }

    /***
     * @return limita de gabarit a strazii.
     */
    public int getGaugeLimit() {
        return gaugeLimit;
    }

    /***
     * @return numele nodului de start al strazii.
     */
    public String getStart() {
        return start;
    }

    /***
     * @return numele nodului de stop al strazii.
     */
    public String getStop() {
        return stop;
    }

    /***
     * @return lista de restrictii a strazii.
     */
    public List<Ambuteiaj> getTrafficJams() {
        return trafficJams;
    }

    /***
     * Actualizeaza numele strazii.
     * @param name noul nume.
     */
    public void setName(String[] name) {
        this.name = name;
    }

    /***
     * Actualizeaza costul strazii.
     * @param speedLimit noul cost.
     */
    public void setCost(int speedLimit) {
        this.cost = speedLimit;
    }

    /***
     * Actualizeaza limita de gabarit a strazii.
     * @param gaugeLimit noua limita de gabarit.
     */
    public void setGaugeLimit(int gaugeLimit) {
        this.gaugeLimit = gaugeLimit;
    }

    /***
     * Actualizeaza numele nodului de start al strazii.
     * @param start noul nume al nodului de start.
     */
    public void setStart(String start) {
        this.start = start;
    }

    /***
     * Actualizeaza numele nodului de stop.
     * @param stop noul nume al nodului de stop.
     */
    public void setStop(String stop) {
        this.stop = stop;
    }

    /***
     * Actualizeaza lista de restrictii a strazii.
     * @param trafficJams noua lista de restrictii.
     */
    public void setTrafficJams(List<Ambuteiaj> trafficJams) {
        this.trafficJams = trafficJams;
    }

    /***
     * Implementeaza functia compare din interfata Comparator pentru implementarea algoritmului
     * Dijkstra cu java.util.priorityqueue.
     * @param s1 obiect de tip Strada.
     * @param s2 alt obiect de tip Strada.
     * @return -1/0/1.
     */
    public int compare(Strada s1, Strada s2) {
        if(s1.cost < s2.cost) {
            return -1;
        }
        if(s1.cost > s2.cost) {
            return 1;
        }
        return 0;
    }
}
