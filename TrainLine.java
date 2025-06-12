public class TrainLine {

    private static final String DEFAULT_NAME = "Hogwarts Express";

    /** The name of the train line */
    private String name;
    /** The head station of the train line */
    private Station head;
    /** Current number of stations in the line */
    private int numberOfStations;

    /** Basic constructor */
    public TrainLine(String name) {
        this.name = name;
        this.head = null;
        this.numberOfStations = 0;
    } // basic constructor

    /** Default constructor */
    public TrainLine() {
        this(DEFAULT_NAME);
    } // default constructor

    /** Accessor for the number of stations */
    public int getNumberOfStations() {
        return this.numberOfStations;
    }

    /**
     * Adds a new station after the last station of a trainline.
     * 
     * @param name String with name of new station to create and add
     */
    public void add(String name) {
        Station newStation = new Station(name);
        if (this.head == null) {
            // No stations exist in this line. Make this new station
            // the head station of the line
            this.head = newStation;
        } else {
            // The line has at least one station (the head station).
            // Find the last station and make its next station the new one.
            Station cursor = this.head;
            while (cursor.hasNext()) {
                cursor = cursor.getNext();
            }
            // Cursor is now at the last station of the line
            cursor.setNext(newStation);
        }
        this.numberOfStations = this.numberOfStations+1; 
        // or this.numberOfStations++;
        // or this.numberOfStatiosn += 1;
    } // method add

    /**
     * Finds how many stations are in a train line
     * 
     * METHOD MADE OBSOLETE BY INTRODUCTING TrainLine.numberOfStations
     */
    public int stationCounter() {
        int counter = 0;
        if (this.head != null) {
            // Train line not empty
            Station cursor = this.head;
            while (cursor != null) {
                counter = counter + 1;
                cursor = cursor.getNext();
            }
        }
        return counter;
    } // method countStations


    /**
     * String representation of the object
     */
    private static final String EMPTY_TRAIN_LINE = "The train line is empty";
    private static final String TRAIN_LINE_HEADER = "\"%s\" has the following stations: %s";
    private static final String NEXT_ARROW = " --> ";

    public String toString() {
        if (this.head == null) {
            return EMPTY_TRAIN_LINE;
        } else {
            String stations = String.format(TRAIN_LINE_HEADER, this.name, this.head.getName());
            Station cursor = this.head.getNext();
            while (cursor != null) {
                stations = stations + NEXT_ARROW + cursor.getName();
                cursor = cursor.getNext();
            }
            return stations;
        }
    } // method toString
} // class TrainLine
