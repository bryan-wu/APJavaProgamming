import java.lang.reflect.*;


/**
 * This class implements a vendor that sells one kind of item. A vendor carries
 * out sales transactions.
 * 
 * @author Bryan Wu
 * @version 9/28/15
 * 
 * @author Period - 3
 * @author Assignment - Java Methods Ch09 - SnackBar
 * 
 * @author Sources - None
 */
public class Vendor
{
    // Fields:
    /**
     * number of items in stock
     */
    private int stock;

    /**
     * price of item in cents
     */
    private int cost;

    /**
     * cents deposited
     */
    private int deposit;

    /**
     * cents of change
     */
    private int change;

    /**
     * value of sales made in cents
     */
    private static int sales;


    /**
     * Constructor for Vendor class.
     * 
     * @param c
     *            price of a single item in cents
     * @param s
     *            number of items to place in stock
     */
    public Vendor( int c, int s )
    {
        cost = c;
        stock = s;
        sales = 0;
    }


    /**
     * This method sets the quantity of items in stock.
     * 
     * @param s
     *            number of items to place in stock
     */
    public void setStock( int s )
    {
        stock = s;
        return;
    }


    /**
     * This method Returns the number of items currently in stock.
     * 
     * @return stock number of items currently in stock
     */
    public int getStock()
    {
        return stock;
    }


    /**
     * This method adds a specified amount (in cents) to the deposited amount.
     * 
     * @param depositAdd
     *            number of cents to add to the deposit
     */
    public void addMoney( int depositAdd )
    {
        if ( stock > 0 )
        {
            deposit += depositAdd;
        }
    }


    /**
     * This method returns the currently deposited amount (in cents).
     * 
     * @return deposit number of cents in the current deposit
     */
    public int getDeposit()
    {
        return deposit;
    }


    /**
     * This method implements a sale. If there are items in stock and the
     * deposited amount is greater than or equal to the single item price, then
     * adjusts the stock and calculates and sets change and returns true;
     * otherwise refunds the whole deposit (moves it into change) and returns
     * false.
     * 
     * @return successful sale (true) or failure (false)
     */
    public boolean makeSale()
    {
        if ( stock > 0 && deposit >= cost )
        {
            if ( deposit > cost )
            {
                change = deposit - cost;
            }
            deposit = 0;
            stock -= 1;
            sales += cost;
            return true;
        }
        else
        {
            change = deposit;
            deposit = 0;
            return false;
        }

    }


    /**
     * Return the total sales in dollar and cent format.
     * 
     * @return sales Total value of items sold in cents.
     */
    public static double getTotalSales()
    {
        return sales * .01;
    }


    /**
     * This method returns and zeroes out the amount of change (from the last //
     * sale or refund).
     * 
     * @return temp number of cents in the current change
     */
    public int getChange()
    {
        int temp = change;
        change = 0;
        return temp;
    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Vendor.
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
                str += separator + field.getName() + ":" + field.get( this );
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
