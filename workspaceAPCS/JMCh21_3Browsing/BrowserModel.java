import java.util.Stack;


/**
 * This class defines BrowserModel for the back and forward methods.
 *
 * @author Bryan Wu
 * @version Jan 19, 2016
 * @author Period: 3
 * @author Assignment: JMCh21_3Browsing
 *
 * @author Sources: None
 */
public class BrowserModel
{
    private BrowserView view;

    private Stack<Integer> backStk;

    private Stack<Integer> forwardStk;

    private int topLine;


    /**
     * constructor Browserview
     *
     * @param bv
     *            a browser view
     */
    public BrowserModel( BrowserView bv )
    {
        backStk = new Stack<Integer>();
        forwardStk = new Stack<Integer>();
        view = bv;
        view.update( 0 );
    }


    /**
     * This method follows the link.
     *
     * @param n
     *            line #
     */
    public void followLink( int n )
    {
        backStk.push( (Integer)topLine );
        topLine = n;
        view.update( topLine );
        forwardStk.removeAllElements();
    }


    /**
     * This method sends the window to the top of the screen.
     */
    public void home()
    {
        backStk.push( (Integer)topLine );
        topLine = 0;
        view.update( topLine );
        forwardStk.removeAllElements();
    }


    /**
     * This method lets the user go back to the previous link.
     */
    public void back()
    {
        if ( hasBack() )
        {
            forwardStk.push( (Integer)topLine );
            topLine = backStk.pop();
            view.update( topLine );
        }
    }


    /**
     * This method lets the user go back to the link after back() has been
     * called.
     */
    public void forward()
    {
        if ( hasForward() )
        {
            backStk.push( (Integer)topLine );
            topLine = forwardStk.pop();
            view.update( topLine );
        }
    }


    /**
     * This method checks if backStk has elements.
     *
     * @return true if backStk has elements
     */
    public boolean hasBack()
    {
        return !backStk.empty();
    }


    /**
     * This method checks if forwardStk has elements.
     *
     * @return true if forwardStk has elements
     */
    public boolean hasForward()
    {
        return !forwardStk.empty();
    }


    // The following are for test purposes only
    /**
     * Returns backStk.
     * 
     * @return backStk backStk
     */
    protected Stack<Integer> getBackStk()
    {
        return backStk;
    }


    /**
     * Returns forwardStk.
     * 
     * @return forwardStk forwardStk
     */
    protected Stack<Integer> getForwardStk()
    {
        return forwardStk;
    }


    /**
     * Returns topLine.
     * 
     * @return topLine topLine
     */
    protected int getTopLine()
    {
        return topLine;
    }
}
