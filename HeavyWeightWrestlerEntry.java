/**
 * Subclass to WrestlingMatchEntry to represent a Heavyweight Wrestler object
 * @author Kris Brooks
 */
public class HeavyWeightWrestlerEntry extends WrestlingMatchEntry {
    /**
     * Default Constructor
     * @param name
     */
    public HeavyWeightWrestlerEntry(String name) {
        super(name);
    }

    /**
    * Overloaded Constructor to create a LightWeightWrestler object
    * @param name           Name of Wrestler
    * @param t              Number of successful takedowns
    * @param e              Number of escapes from opponent's control
    * @param nf             Number of near-fall situations
    * @param r              Number of reversals
    * @param p              If player achieved a pin True = Yes, False = No
    */
    public HeavyWeightWrestlerEntry(String name, int t, int e, int nf, int r, boolean p) {
        super(name, t, e, nf, r, p);
    }

    /**
     * @param points - Override scorePoints methods to add effects for 
     *                 heavyweight wrestler as points are scored
     */
    @Override
    public void scorePoints(int points) {

        switch (points) {
            case 0:
                System.out.println(getWrestlerName() + " (Heavyweight) scored " + points + " points on that attempt.");
                break;
            case 1:
                System.out.println(getWrestlerName() + " (Heavyweight) pulled off a great escape (+1 point)");
                break;
            case 2:
                System.out.println(getWrestlerName() + " (Heavyweight) hears the crowd roar, TWOOOOO! (+2 points)");
                break;
            case 3:
                System.out.println(getWrestlerName() + " (Heavyweight) performs an amazing nearfall! (+3 points)");
                break;
        }

        super.scorePoints(points); // Call the superclass method to update statistics
    }



    /**Creates a representation of this players match statistics
     * @return String representation of Lightweight Contender match statistics
     */
    public String toString() {
        return "*Heavyweight Contender*" + super.toString();
    }
}
