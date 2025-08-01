# Vehicle and Map Management System

In this project, I grouped the classes into two packages based on their purpose:

## 1) `Cars` Package – Classes for Drivable Objects

### 1.1) `Vehicul`  
An abstract class that groups all vehicle types.  
Its attributes are marked `private` to prevent external modification (vehicle cost and size limit are initialized at construction and remain constant).  
Constructors are `protected` because this class should not be instantiated directly. They're only called by its derived classes: `Mopped`, `Autovehicul`, and `Autoutilitar`.

#### 1.1.1) `Mopped`  
An abstract class that extends `Vehicul`. It groups all vehicles with size 1.  
Cost is undefined here.  
Constructor is `protected` and only used by the `Bicicleta` and `Motocicleta` classes.

##### 1.1.1.1) `Bicicleta`  
Instantiated when a `drive` command with the first parameter `"b"` is encountered.  
Inherits from `Mopped` (size always 1).  
Public constructor sets the vehicle cost to `1`.

##### 1.1.1.2) `Motocicleta`  
Instantiated when the `drive` command with parameter `"m"` is used.  
Inherits from `Mopped` (size always 1).  
Public constructor sets the vehicle cost to `2`.

#### 1.1.2) `Autovehicul`  
Abstract class extending `Vehicul`, groups vehicles with size 2.  
Cost remains undefined at this level.  
Constructor is `protected`, used only by `Autoturism`.

##### 1.1.2.1) `Autoturism`  
Instantiated when the command `drive a` is received.  
Inherits from `Autovehicul` (size always 2).  
Public constructor sets cost to `4`.

#### 1.1.3) `Autoutilitar`  
Abstract class extending `Vehicul`, for size-3 vehicles.  
Constructor is `protected`, used only by `Camion`.

##### 1.1.3.1) `Camion`  
Instantiated when `drive c` is encountered.  
Inherits from `Autoutilitar` (size always 3).  
Public constructor sets cost to `6`.

---

## 2) `Map` Package – Graph and Routing Logic

### 2.1) `Harta`  
A singleton class representing the map. Instantiated once in `main()`.  
Handles file I/O and command execution.

- Most methods/attributes are `private` for internal use, except getters/setters, constructors, and `executeCommands`.
- Reads the map from `map.in` using a `Scanner`:
  - Parses number of nodes and edges.
  - Builds an adjacency list of `Strada` objects via `addStreet`.

Then it processes the commands found in the input:

#### 2.1.1) Commands: `trafic`, `blocaj`, or `accident`  
Each `Strada` contains a list of restrictions (can be empty).  
Upon encountering one of these commands:
- `addRestriction()` creates a `Trafic`, `Blocaj`, or `Accident` instance.
- Adds it to the restriction list of the appropriate `Strada` based on start/stop node.

#### 2.1.2) Command: `drive`  
Triggers the `dijkstra()` method, which:

- Starts from the given start node.
- Initializes a distance vector with `INT_MAX` for all nodes.
- Uses a priority queue to process nodes.
- For each neighbor:
  - Checks if the vehicle size restriction allows traversal.
  - Calculates the extra cost added by restrictions.
  - Computes total cost as:
    ```
    total_cost = vehicle_cost * street_cost + traffic_penalty
    ```
  - If a better path is found, updates distances and requeues the node.

Also tracks predecessors for shortest path reconstruction.

If a path is found, it's printed along with the cost to output. Otherwise, outputs `null` with start and stop nodes.

---

### 2.2) `Strada`  
Represents the edges in the graph, uniquely identified by start and stop nodes.  
Implements `Comparator` for use in `PriorityQueue` (Dijkstra).

### 2.3) `Ambuteiaj`  
An abstract class grouping all types of traffic restrictions.  
Constructor is `protected`, used only by derived types:

- **2.3.1) `Trafic`** – created on `addRestriction trafic`
- **2.3.2) `Blocaj`** – created on `addRestriction blocaj`
- **2.3.3) `Accident`** – created on `addRestriction accident`

---

## OOP Concepts Used

- **Inheritance**: 
  Superclasses and subclasses used to group common logic (e.g., `Vehicul` with its subclasses, `Ambuteiaj` with its types).
  
- **Abstraction**:  
  Abstract classes prevent instantiation. Only derived types are used in logic.

- **Polymorphism**:  
  Based on Lab 2 definition:  
  “Polymorphism allows an object of a derived class to be passed to a method expecting a base class.”  
  Example: `Harta.drive()` accepts a `Vehicul`, but works with instances of `Bicicleta`, `Motocicleta`, `Autoturism`, or `Camion`.

---
