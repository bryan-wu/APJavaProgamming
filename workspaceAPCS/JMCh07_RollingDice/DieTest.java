/**
 * This class tests the methods of the Die Class.
 *
 * @author Bryan Wu
 * @version Sep 11, 2015
 * @author Period: 3
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: None
 */
public class DieTest
{
    /**
     * Main method for testing of Die class.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        Die testdie = new Die();
        testdie.roll();
        System.out.println( testdie.getNumDots() );
        testdie.roll();
        System.out.println( testdie.getNumDots() );
    }
}
