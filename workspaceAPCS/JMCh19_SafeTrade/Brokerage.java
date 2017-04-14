import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a brokerage: keeps a TreeMap of registered traders and a TreeSet
 * of logged-in traders. It receives quote requests and trade orders from
 * traders and relays them to the StockExchange.
 *
 * @author Bryan Wu
 * @version Mar 17, 2016
 * @author Period: 3
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: None
 */
public class Brokerage implements Login
{
    private Map<String, Trader> traders;

    private Set<Trader> loggedTraders;

    private StockExchange exchange;


    /**
     * Constructs new brokerage affiliated with a given stock exchange.
     * Initializes the map of traders to an empty map (a TreeMap), keyed by
     * trader's name; initializes the set of active (logged-in) traders to an
     * empty set (a TreeSet).
     * 
     * @param e
     *            exchange
     */
    public Brokerage( StockExchange e )
    {
        exchange = e;
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
    }


    /**
     * Tries to register a new trader with a given screen name and password. If
     * successful, creates a Trader object for this trader and adds this trader
     * to the map of all traders (using the screen name as the key).
     * 
     * @param name
     *            the screen name of the user.
     * @param password
     *            the password for the user.
     * @return 0 if successful, or an error code (a negative integer) if failed:
     *         <br>
     *         -1 -- invalid screen name (must be 4-10 chars)<br>
     *         -2 -- invalid password (must be 2-10 chars)<br>
     *         -3 -- the screen name is already taken.
     */
    public int addUser( String name, String password )
    {
        if ( name.length() < 4 || name.length() > 10 )
        {
            return -1;
        }
        else if ( password.length() < 2 || password.length() > 10 )
        {
            return -2;
        }
        else if ( traders.containsKey( name ) )
        {
            return -3;
        }
        else
        {
            traders.put( name, new Trader( this, name, password ) );
            return 0;
        }
    }


    /**
     * Requests a quote for a given stock from the stock exchange and passes it
     * along to the trader by calling trader's receiveMessage method.
     * 
     * @param symbol
     *            the stock symbol.
     * @param trader
     *            the trader who requested a quote.
     */
    protected void getQuote( String symbol, Trader trader )
    {
        trader.receiveMessage( exchange.getQuote( symbol ) );
    }


    /**
     * Tries to login a trader with a given screen name and password. If no
     * messages are waiting for the trader, sends a "Welcome to SafeTrade!"
     * message to the trader. Opens a dialog window for the trader by calling
     * trader's openWindow() method. Adds the trader to the set of all logged-in
     * traders.
     * 
     * @param name
     *            the screen name of the user.
     * @param password
     *            the password for the user.
     * @return 0 if successful, or an error code (a negative integer) if failed:
     *         <br>
     *         -1 -- screen name not found<br>
     *         -2 -- invalid password<br>
     *         -3 -- user is already logged in.
     */
    public int login( String name, String password )
    {
        if ( !traders.containsKey( name ) )
        {
            return -1;
        }
        if ( !traders.get( name ).getPassword().equals( password ) )
        {
            return -2;
        }
        for ( Trader t : loggedTraders )
        {
            if ( t.getName().equals( name ) )
            {
                return -3;
            }
        }
        Trader t = new Trader( this, name, password );
        t.openWindow();
        loggedTraders.add( t );
        if ( !traders.get( name ).hasMessages() )
        {
            t.receiveMessage( "Welcome to SafeTrade!" );
        }
        return 0;
    }


    /**
     * Removes a specified trader from the set of logged-in traders.
     * 
     * @param trader
     *            trader
     */
    protected void logout( Trader trader )
    {
        loggedTraders.remove( trader );
    }


    /**
     * Places an order at the stock exchange.
     * 
     * @param order
     *            order
     */
    protected void placeOrder( TradeOrder order )
    {
        exchange.placeOrder( order );
    }


    //
    // The following are for test purposes only
    //
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }


    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }


    protected StockExchange getExchange()
    {
        return exchange;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
