/*** Part (c) ***/

/**
 * A NotChecker accepts any string that does NOT contain a particular substring.
 *
 * @author Bryan Wu
 * @version Oct 20, 2015
 * @author Period: 3
 * @author Assignment: A11_3Checker
 *
 * @author Sources: None
 */
public class NotChecker implements Checker
{
    private Checker checker;


    /**
     * NotChecker constructor.
     * 
     * @param chk
     *            checker
     */
    public NotChecker( Checker chk )
    {
        checker = chk;

    }


    /**
     * This method determines if any string does NOT contain a particular
     * substring.
     * 
     * @param text
     *            text
     * @return return true if does NOT contain a particular substring.
     */
    public boolean accept( String text )
    {
        return !checker.accept( text );
    }
}
