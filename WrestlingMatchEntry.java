/**Superclass to represent an entry of information about a wrestling
 * game-related match
 * @author Kris Brooks
 */
public class WrestlingMatchEntry {

    /** Class Instance Variables */
    private String wrestlerName;    // Name of Wrestler
    private int takedowns;          // Number of successful takedowns
    private int escapes;            // Number of escapes from opponent's control
    private int nearFalls;          // Number of near-fall situations
    private int reversals;          // Number of reversals 
    private boolean pins;           // If player achieved a pin True = Yes, False = No
    private int points;             // Total Points

    /**
     * Default Constructor Method
     * @param name      Name of Wrestler
     */
    public WrestlingMatchEntry(String name) {
        wrestlerName = name;
    }
    
   /**
    * Overloaded Constructor to create a Wrestler object
    * @param name           Name of Wrestler
    * @param t              Number of successful takedowns
    * @param e              Number of escapes from opponent's control
    * @param nf             Number of near-fall situations
    * @param r              Number of reversals 
    * @param p              If player achieved a pin True = Yes, False = No
    */
    public WrestlingMatchEntry(String name, int t, int e, int nf, int r, boolean p) {
        wrestlerName = name;
        takedowns = t;
        escapes = e;
        nearFalls = nf;
        reversals = r;
        pins = p;
    }

   /**
    * @return wrestlerName, the name of the wrestler
    */
    public String getWrestlerName() {
        return wrestlerName;
    }

    /**
    * @return takedowns, the number of successful takesdowns
    */
    public int getTakedowns() {
        return takedowns;
    }

    /**
    * @return escapes, the number of escapes from opponent's control
    */
    public int getEscapes() {
        return escapes;
    }

    /**
    * @return nearFalls, the number of near-fall situations
    */
    public int getNearFalls() {
        return nearFalls;
    }

    /**
    * @return reversals, the number of reversals
    */
    public int getReversals() {
        return reversals;
    }

    /**
    * @return pins, the number of pins achieved
    */
    public boolean getPins() {
        return pins;
    }

    /**
     * @return points, total points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param p - Points Scored in match
     */
    public void scorePoints(int p) {
        points = points + p;
    };

    /** Simulates player takedown */
    public void performTakedown() {
        takedowns++;
        scorePoints(2);
    }

    /** Simulates player escape */
    public void performEscape() {
        escapes++;
        scorePoints(1);
    }

    /**
     * Simulates player nearfall
     * @param points - nearfall points 2 / 3
     */
    public void performNearFall(int points) {
        nearFalls++;
        scorePoints(points);
    }

    /** Simulates player reversal */
    public void performReversal() {
        reversals++;
        scorePoints(2);
    }

    /** Simulates player pin */
    public void performPin() {
        pins = true;
        scorePoints(0); // Pins result in match victory
    }

   /**Creates a representation of this players match statistics,
    * which allows a WrestlingMatchEntry object to be 'printed'
    * @return String representation of current players match statistics.
    */
    public String toString() {
        return "\nWrestler: " + wrestlerName +
               "\nTakedowns: " + takedowns +
               "\nEscapes: " + escapes +
               "\nNear Falls: " + nearFalls +
               "\nReversals: " + reversals +
               "\nPins: " + pins;
    }
}
