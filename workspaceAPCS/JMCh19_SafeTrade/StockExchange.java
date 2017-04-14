import java.lang.reflect.*;
import java.util.*;


/**
 * Represents a stock exchange. A <code>StockExchange</code> keeps a
 * <code>HashMap</code> of stocks, keyed by a stock symbol. It has methods to
 * list a new stock, request a quote for a given stock symbol, and to place a
 * specified trade order.
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;


    /**
     * constructor for stockexchange, sets up hashmap of listed stocks
     */
    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }


    /**
     * 
     * adds new stock to the listed stocks
     * 
     * @param symbol
     *            the symbol of new stock
     * @param name
     *            the name of new stock
     * @param price
     *            the price of new stock
     */
    public void listStock( String symbol, String name, double price )
    {
        listedStocks.put( symbol, new Stock( symbol, name, price ) );
    }


    /**
     * 
     * gets the quote of a stock using the symbol
     * 
     * @param symbol
     *            the symbol of the stock you want the quote from
     * @return the quote from the inputed stock
     */
    public String getQuote( String symbol )
    {
        return listedStocks.get( symbol ).getQuote();
    }


    /**
     * 
     * Places in order by calling stock.placeOrder where stock is the stock in
     * order
     * 
     * @param TradeOrder
     *            the order to be place
     */
    public void placeOrder( TradeOrder order )
    {
        if ( listedStocks.get( order.getSymbol() ) != null )
        {
            listedStocks.get( order.getSymbol() ).placeOrder( order );
        }
        else
        {
            order.getTrader().receiveMessage( order.getSymbol() + " not found" );
        }
    }


    //
    // The following are for test purposes only
    //
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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
