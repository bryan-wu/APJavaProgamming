/**
 * Simulates a six-sided die.
 *
 * @author Bryan Wu
 * @version 9/10/15
 * @author Period: 7
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: None
 */
public class Die
{
    /**
     * Number of dots.
     */
    private int numDots;


    /**
     * Sets numDots to a random integer from 1 to 6
     */
    public void roll()
    {
        // generates random integer with the condition 1<=integer<=6
        numDots = 1 + (int)( 6 * Math.random() );
    }


    /**
     * Returns the value of the most recent roll.
     * 
     * @return numDots number of dots on die
     */
    public int getNumDots()
    {
        return numDots; // Fix this !!!
    }
}
