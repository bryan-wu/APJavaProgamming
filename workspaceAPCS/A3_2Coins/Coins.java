import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author Bryan Wu
 * @version 9/3/15
 * @author Period: 3
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: None
 */
public class Coins
{
    /**
     * Given amount of money (in cents).
     */
    private int myChange;


    /**
     * This is the constructor for the Coins class.
     * 
     * @param change
     *            Given number of cents
     */
    public Coins( int change )
    {
        myChange = change;
    }


    /**
     * This method calculates the number of each type of coin in the given
     * change. It will aims to use the fewest number of coins possible.
     */
    public void calculate()
    {
        // declarations
        int leftOver; // remaining cents
        int quarters; // number of quarters
        int dimes;
        int nickels;
        int pennies;

        quarters = myChange / 25;
        leftOver = myChange % 25;
        dimes = leftOver / 10;
        leftOver = leftOver % 10;
        nickels = leftOver / 5;
        leftOver = leftOver % 5;
        pennies = leftOver;

        System.out.println( myChange + " cents =>" );
        System.out.println( "Quarter(s)   " + quarters );
        System.out.println( "Dime(s)      " + dimes );
        System.out.println( "Nickel(s)    " + nickels );
        System.out.println( "Penny(s)     " + pennies );
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
     * @return a string representation of this Easter.
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
                str += separator + field.getType().getName() + 
                                " " + field.getName() + ":" + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
    // Please enter the number of cents --> 94
    // 94 cents =>
    // Quarter(s) 3
    // Dime(s) 1
    // Nickel(s) 1
    // Penny(s) 4

    // Please enter the number of cents --> 59
    // 59 cents =>
    // Quarter(s) 2
    // Dime(s) 0
    // Nickel(s) 1
    // Penny(s) 4

    // Please enter the number of cents --> 19
    // 19 cents =>
    // Quarter(s) 0
    // Dime(s) 1
    // Nickel(s) 1
    // Penny(s) 4
}
