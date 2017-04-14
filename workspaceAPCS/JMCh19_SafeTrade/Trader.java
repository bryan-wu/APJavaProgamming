import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock trader: it can request quotes and place orders with the
 * brokerage. It can also receive messages and store them in its mailbox (a
 * Queue<String>) and tell its TraderWindow to display them.
 *
 * @author Bryan Wu
 * @version Mar 17, 2016
 * @author Period: 3
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName;

    private String password;

    private TraderWindow myWindow;

    private Queue<String> mailbox;


    /**
     * Constructs a new trader, affiliated with a given brokerage, with a given
     * screen name and password.
     * 
     * @param b
     *            brokerage
     * @param name
     *            name
     * @param pswd
     *            password
     */
    public Trader( Brokerage b, String name, String pswd )
    {
        brokerage = b;
        screenName = name;
        password = pswd;
        mailbox = new LinkedList<String>();
    }


    /**
     * Compares this trader to another by comparing their screen names case
     * blind.
     */
    public int compareTo( Trader other )
    {
        return screenName.compareToIgnoreCase( other.getName() );
    }


    /**
     * Indicates whether some other trader is "equal to" this one, based on
     * comparing their screen names case blind. This method will throw a
     * ClassCastException if other is not an instance of Trader.
     */
    public boolean equals( Object other )
    {
        if ( other.getClass().getName().equals( "Trader" ) )
        {
            return screenName.equalsIgnoreCase( ( (Trader)other ).getName() );
        }
        else
        {
            throw new ClassCastException();
        }
    }


    /**
     * Returns the screen name for this trader.
     * 
     * @return the screen name for this trader.
     */
    protected String getName()
    {
        return screenName;
    }


    /**
     * Returns the password for this trader.
     * 
     * @return the password for this trader.
     */
    protected String getPassword()
    {
        return password;
    }


    /**
     * Requests a quote for a given stock symbol from the brokerage by calling
     * brokerage's getQuote.
     * 
     * @param symbol
     *            symbol
     */
    protected void getQuote( String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    /**
     * Returns true if this trader has any messages in its mailbox.
     * 
     * @return true if this trader has any messages in its mailbox.
     */
    protected boolean hasMessages()
    {
        return !mailbox.isEmpty();
    }


    /**
     * Creates a new TraderWindow for this trader and saves a reference to it in
     * myWindow. Removes and displays all the messages, if any, from this
     * trader's mailbox by calling myWindow.show(msg) for each message.
     */
    protected void openWindow()
    {
        myWindow = new TraderWindow( this );
        while ( !mailbox.isEmpty() )
        {
            myWindow.showMessage( mailbox.remove() );

        }
    }


    /**
     * Places a given order with the brokerage by calling brokerage's
     * placeOrder.
     * 
     * @param order
     *            order
     */
    protected void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    /**
     * Logs out this trader.
     */
    public void quit()
    {
        brokerage.logout( this );
    }


    /**
     * Adds msg to this trader's mailbox and displays all messages. If this
     * trader is logged in (myWindow is not null) removes and shows all the
     * messages in the mailbox by calling myWindow.showMessage(msg) for each msg
     * in the mailbox.
     * 
     * @param msg
     *            message
     */
    public void receiveMessage( String msg )
    {
        mailbox.add( msg );
        for ( String str : mailbox )
        {
            myWindow.showMessage( str );
        }
        if ( myWindow != null )
        {
            while ( !mailbox.isEmpty() )
            {
                myWindow.showMessage( mailbox.remove() );
            }
        }
    }


    //
    // The following are for test purposes only
    //
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) )
                    str += separator + field.getType().getName() + " " + field.getName();
                else
                    str += separator + field.getType().getName() + " " + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }
}
