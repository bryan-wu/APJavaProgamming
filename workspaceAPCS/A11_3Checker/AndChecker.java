/*** Part (b) ***/

/**
 * AndChecker is a Checker that is constructed with two objects of classes that
 * implement the Checker interface (such as SubstringChecker or AndChecker
 * objects).
 *
 * @author Bryan Wu
 * @version Oct 19, 2015
 * @author Period: 3
 * @author Assignment: A11_3Checker
 *
 * @author Sources: None
 */
public class AndChecker implements Checker
{
    private Checker checker1;

    private Checker checker2;


    /**
     * AndChecker constructor.
     * 
     * @param chk1
     *            One checker to include.
     * @param chk2
     *            Another checker to include.s
     */
    public AndChecker( Checker chk1, Checker chk2 )
    {
        checker1 = chk1;
        checker2 = chk2;
    }


    /**
     * The AndChecker accept method returns true if and only if the string is
     * accepted by both of the Checker objects with which it was constructed.
     * 
     * @param text
     *            String that AndChecker will checks
     * 
     * @return true if each of the checkers contain their substring
     */
    public boolean accept( String text )
    {
        return checker1.accept( text ) && checker2.accept( text );
    }
}
