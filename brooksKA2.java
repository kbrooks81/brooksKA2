/**Public class used to demonstrate the use of WreslingmatchEntry and LightWeightWrestlerEntry
 * @author Kris Brooks
 */
public class brooksKA2 {
    public static void main(String[] args) {
        // Create four wrestler objects (two on each team)
        WrestlingMatchEntry wrestler1 = new HeavyWeightWrestlerEntry("John");
        WrestlingMatchEntry wrestler2 = new LightWeightWrestlerEntry("Alex"); // Lightweight wrestler
        WrestlingMatchEntry wrestler3 = new HeavyWeightWrestlerEntry("Mike");
        WrestlingMatchEntry wrestler4 = new LightWeightWrestlerEntry("Sam"); // Lightweight wrestler

        // Create CircularlyLinkedList data structures to hold each team 
        CircularlyLinkedList<WrestlingMatchEntry> lightWeight = new CircularlyLinkedList<>();
        CircularlyLinkedList<WrestlingMatchEntry> veterans = new CircularlyLinkedList<>();

        // Insert players into their respective teams
        veterans.addFirst(wrestler1);
        veterans.addFirst(wrestler3);

        lightWeight.addFirst(wrestler2);
        lightWeight.addFirst(wrestler4);

        // Simulate teams facing each other and scoring points
        int rounds = 2; // Simulate two rounds
        for (int i = 1; i <= rounds; i++) {
            System.out.println("\nRound " + i);
            simulateRound(veterans.first(), lightWeight.first()); // Simulate first player from each team facing each other

            System.out.println(veterans.first().toString() + "\n"); // Print each players statistics from the match and 
            System.out.println(lightWeight.first().toString());
            announceWinner(veterans, lightWeight);                  // announce winner
            

            // Rotate players in a cyclic manner (remove first and add it to the end)
            veterans.rotate();
            lightWeight.rotate();
        }
    }

    /**
     * Helper Method that simulates a round(match) of wrestling 
     * @param wrestler1 - WrestlingMatchEntry object representing first wrestler
     * @param wrestler2 - WrestlingMatchEntry object representing second wrestler
     */
    public static void simulateRound(WrestlingMatchEntry wrestler1, WrestlingMatchEntry wrestler2) {
        int cycles = 0;
        boolean pinOccurred = false;

        while (cycles < 5 && !pinOccurred) {
            performRandomAction(wrestler1);
            performRandomAction(wrestler2);
            
            // Check if either player got a pin
            if (wrestler1.getPins() == true || wrestler2.getPins() == true) {
                System.out.println("\nPIN!!\n");
                pinOccurred = true;
            }   

            cycles++;
        }
    }

    /**
     * Helper method used to simulate wrestler performing random moves throughout the match
     * @param wrestler - WrestlingMatchEntry object
     */
    public static void performRandomAction(WrestlingMatchEntry wrestler) {
        int randomAction = (int) (Math.random() * 5); 
        double randomValue = Math.random();
        int result = (randomValue < 0.5) ? 2 : 3;

        switch (randomAction) {
            case 0:
                wrestler.performTakedown();
                break;
            case 1:
                wrestler.performEscape();
                break;
            case 2:
                wrestler.performNearFall(result);
                break;
            case 3:
                wrestler.performReversal();
                break;
            case 4:
                wrestler.performPin();
                break;
        }
    }


    /**
     * Generics method used to announce the overall winner of the round(match)
     * @param <T>
     * @param vets - Generic circularlylinkedlist for the veterans team
     * @param lws - Generic circularlylinkedlist for the lightweight team
     */
    public static <T extends WrestlingMatchEntry> void announceWinner(CircularlyLinkedList<T> vets, CircularlyLinkedList<T> lws) {
        if (vets.first().getPins()) {
            System.out.println("\nThe winner by submission is . . .\n" + vets.first().getWrestlerName() + "!!!");
        } 
        else if (lws.first().getPins()) {
            System.out.println("\nThe winner by submission is . . .\n" + lws.first().getWrestlerName() + "!!!");
        }      
        else if (vets.first().getPoints() > lws.first().getPoints()) {
            System.out.println("\nThe Winner by a " +
                                vets.first().getPoints() +
                                " - " + lws.first().getPoints() +
                                " decision . . . \n" +
                                vets.first().getWrestlerName() + "!!!");
        } 
        else {
            System.out.println("\nThe Winner by a " +
                                lws.first().getPoints() +
                                " - " + vets.first().getPoints() +
                                " decision . . . \n" +
                                lws.first().getWrestlerName() + "!!!");
        }
    }
    
}