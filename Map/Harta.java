package Map;
import Cars.*;
import java.io.*;
import java.util.*;

/***
 * In program, clasa Harta va fi instantiata o singura data.
 * Obiectul de tip Harta reprezinta graful pe care vor fi executate comenzile citite din fisierul
 * de intrare.
 */
public class Harta {
    private int noNodes;
    private int noEdges;
    private int[] distances;
    private PriorityQueue<Strada> q;
    private List<List<Strada>> adjList;

    /***
     * Constructor fara parametrii.
     */
    public Harta() { }

    /***
     * Constructor cu un parametru.
     * Sunt citite si initializate elementele grafului.
     * De asemenea este alocata memorie pentru vectorul de distante, coada de prioritati (folosite
     * ulterior in implementarea algoritmului Dijkstra) si lista de adiacenta in care sunt stocate
     * muchiile grafului).
     * @param scanner obiectul de tip Scanner folosit pentru citirea din fisier.
     */
    public Harta(Scanner scanner) {
        readMap(scanner);
        distances = new int[noNodes];
        q = new PriorityQueue<Strada>(noNodes, new Strada());
    }

    /***
     * Constructor cu parametrii.
     * @param noNodes numarul de noduri ale grafului.
     * @param noEdges numarul de muchii ale grafului.
     * @param distances vector ce retine distanta minima de la nodul @start la toate celelalte noduri.
     * @param q coada de prioritati folosita la implementarea algoritmului Dijkstra.
     * @param adjList lista de adiacenta in care este stocat graful.
     */
    public Harta(int noNodes, int noEdges, int[] distances, PriorityQueue<Strada> q, List<List<Strada>> adjList) {
        this.noNodes = noNodes;
        this.noEdges =noEdges;
        this.distances = distances;
        this.q = q;
        this.adjList = adjList;
    }

    /***
     * Sunt citite informatiile de pe prima linie a fisierului de intrare.
     * Sunt initializate numarul de noduri si numarul de muchii ale grafului.
     * Functia este apelata in constructorul cu un parametru.
     * Pentru citirea si formarea listei de adiacenta este apelata functia @getStreets.
     * @param scanner obiectul de tip Scanner folosit pentru citirea din fisier.
     */
    private void readMap(Scanner scanner) {
        noEdges = Integer.parseInt(scanner.next());
        noNodes = Integer.parseInt(scanner.next());
        getStreets(scanner);
    }

    /***
     * Graful este citit si stocat sub forma unei liste de adiacenta.
     * Fisierul de intrare este parcurs linie cu linie in bucla while si este apelata functia @addStreet
     * care adauga o noua muchie (obiect de tip Strada) in lista de adiacenta.
     * @param scanner obiectul de tip Scanner folosit pentru citirea din fisier.
     */
    private void getStreets(Scanner scanner) {
        int count = 0;
        this.adjList = new ArrayList<>();
        while (count < noEdges) {
            adjList.add(count, new ArrayList<>());
            String start = scanner.next();
            String stop = scanner.next();
            int cost = Integer.parseInt(scanner.next());
            int gaugeLimit = Integer.parseInt(scanner.next());
            addStreet(start, stop, cost, gaugeLimit);
            count++;
        }
    }

    /***
     * Este alocat un obiect de tip Strada si adaugat in lista de adiacenta.
     * @param start numele nodului de start al strazii.
     * @param stop numele nodului de stop al strazii.
     * @param cost limita de viteza a strazii (costul strazii).
     * @param gaugeLimit limita de gabarit a strazii.
     */
    private void addStreet(String start, String stop, int cost, int gaugeLimit) {
        Strada street = new Strada(start, stop, cost, gaugeLimit);
        int index = getIndex(start);
        adjList.get(index).add(street);
    }

    /***
     * In lista de restrictii a strazii cu coordonatele @start - @stop este adaugat un obiect
     * de tip Ambuteiaj.
     * Obiectul de tip Ambuteiaj este creat, initializat si returnat de functia @getRestriction.
     * @param tip tipul ambuteiajului (trafic/blocaj/accident).
     * @param start numele nodului de start al strazii pe care este adaugat ambuteiajul.
     * @param stop numele nodului de stop al strazii pe care este adaugat ambuteiajul.
     * @param cost costul suplimentar creat de ambuteiaj pe strada.
     */
    private void addRestriction(String tip, String start, String stop, int cost) {
        Ambuteiaj ambuteiaj = getRestriction(tip, start, stop, cost);
        for(Strada s: adjList.get(getIndex(start))) {
            if (s.getStop().equals(stop)) {
                s.getTrafficJams().add(ambuteiaj);
            }
        }
    }

    /***
     * Pe baza parametrului @tip este alocat, initializat si returnat obiectul Ambuteiaj corespunzator.
     * @param tip tipul ambuteiajului (trafic/blocaj/accident).
     * @param start numele nodului de start al strazii pe care urmeaza sa fie adaugat ambuteiajul.
     * @param stop numele nodului de stop al strazii pe care urmeaza sa fie adaugat ambuteiajul.
     * @param cost costul suplimentar creat de ambuteiaj pe strada.
     * @return obiectul ambuteiaj.
     */
    private Ambuteiaj getRestriction(String tip, String start, String stop, int cost) {
        if (tip.equals("trafic")) {
            return new Trafic(cost, start, stop);
        }
        else if (tip.equals("blocaj")) {
            return new Blocaj(cost, start, stop);
        }
        return new Accident(cost, start, stop);
    }

    /***
     * Este apelata functia @dijkstra care calculeaza pe baza algoritmului Dijsktra, a tipului de
     * vehicul condus si a restrictiilor intalnite pana in momentul apelarii functiei, distanta
     * minima pe graf de la un nod de start dat la toate celelalte noduri.
     * Aceste distante sunt stocate in vectorul @distances al grafului (distanta minima de la
     * start la nod i = distances[i])
     * @param vehicle obiectul de tip vehicul condus.
     * @param start numele nodului de start.
     * @param stop numele nodului destinatie.
     * @return lista de stringuri ce reprezinta numele nodurilor prin care trece drumul de cost
     * minim de la start la stop.
     */
    private List<String> drive(Vehicul vehicle, String start, String stop) {
        String[] parent = dijkstra(vehicle, start);
        return getPath(parent, start, stop);
    }

    /***
     * Pe baza parametrului @tip este alocat, initializat si returnat obiectul Vehicul corespunzator.
     * @param tip tipul vehiculului (bicicleta/motocicleta/autoturism/camion).
     * @return obiectul vehicul.
     */
    private Vehicul getVehicle(String tip) {
        if (tip.equals("a")) {
            return new Autoturism();
        }
        else if (tip.equals("b")) {
            return new Bicicleta();
        }
        else if(tip.equals("m")) {
            return new Motocicleta();
        }
        return new Camion();
    }

    /***
     * Implementare a algoritmului Dijkstra cu ajutorul unei cozi cu prioritati.
     * Pe baza tipului de vehicul dat ca parametru, este calculata distanta minima pe graf intre
     * punctul de start si toate celelalte puncte. Distantele sunt stocate in vectorul distances.
     * Daca nu exista un drum posibil pentru vehiculul dat intre punctul de start si un nod i,
     * pozitia i din vectorul distances va ramane initializata cu valoarea Integer.MAX_VALUE.
     * Vectorul @parentStreet pastreaza pentru fiecare nod, nodul precedent prin care trece calea
     * de cost minim.
     * @param vehicle tipul vehiculului condus (bicicleta/motocicleta/autoturism/camion).
     * @param start numele nodului de start din care incepe algoritmul.
     * @return vector de stringuri ce reprezinta numele nodului precedent fiecarui nod din calea
     * de cost minim.
     */
    private String[] dijkstra(Vehicul vehicle, String start) {
        String[] parentStreet = new String[noNodes];
        parentStreet[0] = null;                         // nodul start are mereu precedentul null
        for(int i = 0; i < noNodes; i++) {              // initializare distante cu o valoare mare
            distances[i] = Integer.MAX_VALUE;
        }
        distances[getIndex(start)] = 0;                 // distanta nodului de start fata de el e 0
        Strada firstStreet = new Strada(start, start);
        q.add(firstStreet);                             // nodul start este adaugat in coada
        while(!q.isEmpty()) {                           // cat timp exista noduri in coada
            Strada currentStreet = q.poll();            // se extrage primul nod din coada
            int index = getIndex(currentStreet.getName()[1]);
            int listSize = adjList.get(index).size();
            for(int i = 0; i < listSize; i++) {         // se parcurge lista de vecini a nodului
                Strada neighbourStreet = adjList.get(index).get(i);
                if(vehicle.getGauge() <= neighbourStreet.getGaugeLimit()) {
                    int additionalCost = 0;
                    for(Ambuteiaj r: neighbourStreet.getTrafficJams()) {
                        additionalCost += r.getCost(); // se parcurge lista de restrictii a nodului
                    }                                  // si se calculeaza costul pe baza formulei
                    int cost = neighbourStreet.getCost() * vehicle.getCost() + additionalCost;
                    int currentDestination = getIndex(currentStreet.getStop());
                    int neighbourDestination = getIndex(neighbourStreet.getStop());
                    int newDistance = distances[currentDestination] + cost;
                    if (newDistance < distances[neighbourDestination]) { // cost nou mai bun
                        q.remove(neighbourStreet);
                        distances[neighbourDestination] = newDistance;  // actualizare cost
                        parentStreet[neighbourDestination] = currentStreet.getStop();
                        q.add(neighbourStreet);                         // nodul este reintrodus
                    }
                }
            }
        }
        return parentStreet;
    }

    /***
     * Pe baza numelui unui nod "Pi", este returnat indexul corespunzator "i".
     * @param name nume nod.
     * @return index.
     */
    private int getIndex(String name) {
        return Integer.parseInt(name.substring(1));
    }

    /***
     * Pe baza instructiunilor citite din fisierul de intrare se adauga o noua restrictie in lista
     * de restrictii a unei strazi sau se executa comanda @drive.
     * La executia comenzii @drive sunt scrise in fisierul de iesire rezultatele: calea de cost
     * minim de la start la stop, respectiv costul minim.
     * Functia este apelata in functia main pentru graful format.
     * @param scanner obiectul de tip Scanner folosit pentru citirea din fisier.
     * @param writer obiectul de tip PrintWriter folosit pentru scrierea in fisier.
     */
    public void executeCommands(Scanner scanner, PrintWriter writer) {
        scanner.nextLine();
        while (scanner.hasNextLine()) {                               // cat timp exista comenzi
            String[] commands = scanner.nextLine().split(" ");
            if (!commands[0].equals("drive")) {                       // daca nu este intalnit drive
                String start = commands[1];
                String stop = commands[2];
                int cost = Integer.parseInt(commands[3]);
                String tip = commands[0];
                addRestriction(tip, start, stop, cost);               // adauga restrictie
            }
            else {
                String tip = commands[1];
                String start = commands[2];
                String stop = commands[3];
                Vehicul vehicle = getVehicle(tip);                     // obtine vehicul
                List<String> path = drive(vehicle, start, stop);       // obtine cale + distante
                if (distances[getIndex(stop)] != Integer.MAX_VALUE) {  // daca exista cale
                    for (String s: path) {
                        writer.print(s + " ");                         // afiseaza cale
                    }
                    writer.println(distances[getIndex(stop)]);         // afiseaza distante
                }
                else {                                                 // nu exista calea
                    writer.print(start + " " + stop + " ");            // afiseaza start + stop
                    writer.println("null");
                }
            }
        }
    }

    /***
     * Pe baza vectorului de noduri precedente dat ca parametru este creata o lista cu numele
     * nodurilor prin care trece drumul de cost minim de la start la stop.
     * @param parent vectorul de noduri precedente.
     * @param start numele nodului de start al strazii.
     * @param stop numele nodului de stop al strazii.
     * @return lista de stringuri ce reprezinta calea de cost minim.
     */
    private List<String> getPath(String[] parent, String start, String stop) {
        ArrayList<String> path = new ArrayList<>();
        while (parent[getIndex(stop)] != null) {        // cat timp exista noduri
            path.add(stop);                             // adauga numele nodului curent
            stop = parent[getIndex(stop)];              // se trece la nodul urmator
        }
        path.add(start);                                // se adauga si nodul de start
        Collections.reverse(path);                      // se inverseaza lista
        return path;
    }

    /***
     * @return numar muchii (strazi) graf.
     */
    public int getNoEdges() {
        return noEdges;
    }

    /***
     * @return numar noduri graf.
     */
    public int getNoNodes() {
        return noNodes;
    }

    /***
     * @return lista de adiacenta (modalitatea de stocare a grafului).
     */
    public List<List<Strada>> getAdjList() {
        return adjList;
    }

    /***
     * @return coada de prioritati a grafului.
     */
    public PriorityQueue<Strada> getQueue() {
        return q;
    }

    /***
     * Actualizeaza lista de adiacenta.
     * @param adjList lista de adiacenta.
     */
    public void setAdjList(List<List<Strada>> adjList) {
        this.adjList = adjList;
    }
    /***
     * Actualizeaza numarul de muchii (strazi).
     * @param noEdges numarul de muchii.
     */
    public void setNoEdges(int noEdges) {
        this.noEdges = noEdges;
    }

    /***
     * Actualizeaza numarul de noduri.
     * @param noNodes numarul de noduri.
     */
    public void setNoNodes(int noNodes) {
        this.noNodes = noNodes;
    }

    /***
     * Actualizeaza coada de prioritati.
     * @param q coada de prioritati
     */
    public void setQueue(PriorityQueue<Strada> q) {
        this.q = q;
    }
}