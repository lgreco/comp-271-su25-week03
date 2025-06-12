public class Station {

    /** Default station name */
    private static final String DEFAULT_NAME = "Hogsmeade";

    private String name;
    private Station next;

    /** Basic constructor */
    public Station(String name) {
        this.name = name;
        this.next = null;
    } // basic constructor

    /** Default constructor */
    public Station() {
        this(DEFAULT_NAME);
    } // default constructor

    /** Set the next station (setter method aka mutators) */
    public void setNext(Station nextStation) {
        this.next = nextStation;
    } // method setNext

    /** Predicate accessor for next */
    public boolean hasNext() {
        return this.next != null;
    } // method hasNext

    /** Literal accessor (also a getter method) */
    public Station getNext() {
        return this.next;
    } // method getNext

    /** Getter method for the station's name */
    public String getName() {
        return this.name;
    } // method getName

    /** Text representation */
    public String toString() {
        return this.getName();
    } // method toString
} // class Station
