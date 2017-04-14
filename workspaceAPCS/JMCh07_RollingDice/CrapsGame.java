/**
 * Implements the game of Craps logic.
 *
 * @author Bryan Wu
 * @version 9/10/15
 * @author Period: 3
 * @author Assignment: JMCh07_RollingDice
 *
 * @author Sources: None
 */
public class CrapsGame
{
    /**
     * Point.
     */
    private int point = 0;


    /**
     * Calculates the result of the next dice roll in the Craps game. The
     * parameter total is the sum of dots on two dice. point is set to the saved
     * total, if the game continues, or 0, if the game has ended. Returns 1 if
     * player won, -1 if player lost, 0 if player continues rolling.
     * 
     * @param total
     *            total
     * @return result
     */
    public int processRoll( int total )
    {
        int result = 0;

        // check if a point has been set
        if ( point == 0 )
        {
            // player wins if the total is 7 or 11
            if ( total == 7 || total == 11 )
            {
                point = 0;
                result = 1;
            }

            else
            {
                // player loses if the total is 2, 3, or 12
                if ( total == 2 || total == 3 || total == 12 )
                {
                    point = 0;
                    result = -1;
                }

                // point has been set and player will continue rolling
                else
                {
                    point = total;
                    result = 0;
                }

            }

        }

        else
        {
            // lose if 7 rolled
            if ( total == 7 )
            {
                point = 0;
                result = -1;
            }

            // win if point is rolled
            else
            {
                if ( total == point )
                {
                    point = 0;
                    result = 1;
                }

                // continue rolling if total is anything else
                else
                {
                    result = 0;
                }
            }

        }

        return result;
    }


    /**
     * Returns the saved point.
     * @return point
     */
    public int getPoint()
    {
        return point;
    }
}