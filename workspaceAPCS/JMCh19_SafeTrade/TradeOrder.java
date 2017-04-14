import java.lang.reflect.*;


/**
 * Represents a buy or sell order for trading a given number of shares of a
 * specified stock.
 */
public class TradeOrder
{
    private Trader trader;

    private String symbol;

    private boolean buyOrder;

    private boolean marketOrder;

    private int numShares;

    private double price;


    public TradeOrder(
        Trader trader,
        String symbol,
        boolean buyOrder,
        boolean marketOrder,
        int numShares,
        double price )
    {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }


    /**
     * 
     * getter for price
     * 
     * @return the current price
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * 
     * getter for shares
     * 
     * @return the current shares
     */
    public int getShares()
    {
        return numShares;
    }


    /**
     * 
     * getter for symbol
     * 
     * @return the current symbol
     */
    public String getSymbol()
    {
        return symbol;
    }


    /**
     * 
     * getter for trader
     * 
     * @return the current trader
     */
    public Trader getTrader()
    {
        return trader;
    }


    /**
     * 
     * checks if order is buy order
     * 
     * @return if it is a buy order or not
     */
    public boolean isBuy()
    {
        return buyOrder;
    }


    /**
     * 
     * checks if order is sell order
     * 
     * @return if it is a sell order or not
     */
    public boolean isSell()
    {
        return !buyOrder;
    }


    /**
     * 
     * checks if order is limit order
     * 
     * @return if it is a limit order or not
     */
    public boolean isLimit()
    {
        return !marketOrder;
    }


    /**
     * 
     * checks if order is market order
     * 
     * @return if it is a market order or not
     */
    public boolean isMarket()
    {
        return marketOrder;
    }


    /**
     * 
     * subtracts shares in the order
     * 
     * @param the
     *            number of shares to subtract from numShares
     */
    public void subtractShares( int shares )
    {
        numShares = -shares;
    }


    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
