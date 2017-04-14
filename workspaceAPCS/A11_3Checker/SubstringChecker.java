/*** Part (a) ***/

/**
 * A SubstringChecker accepts any string that contains a particular substring.
 *
 * @author Bryan Wu
 * @version Oct 16, 2015
 * @author Period: 3
 * @author Assignment: A11_3Checker
 *
 * @author Sources: None
 */
public class SubstringChecker implements Checker
{
    private String str;


    /**
     * SubstringChecker constructor.
     * 
     * @param text
     *            String that SubstringChecker will look for
     */
    public SubstringChecker( String text )
    {
        str = text;
    }


    /**
     * This method checks if a give string contains str.
     * 
     * @param text
     *            String that SubstringChecker will check
     * 
     * @return true if the text contains str
     */
    public boolean accept( String text )
    {
        return text.contains( str );
    }
}
