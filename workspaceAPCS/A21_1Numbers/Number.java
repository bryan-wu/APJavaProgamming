import java.util.*;


/**
 * A number class that represents a number with a given base. The number class
 * has two constructors. The default constructor sets the base at 10 and the
 * value to 0. The other constructor accepts a decimal value and a base. The
 * constructors will have to create all of the digits (as objects of the digit
 * class) and store them in some kind of list. Create a toString method and an
 * increment method. These two methods will use the corresponding methods of the
 * digit class to do most of the work for them. For both classes, you can assume
 * that the bases are restricted to binary, octal, decimal or hexadecimal and
 * the values are non-negative.
 * 
 * @author Bryan Wu
 * @version 4/1/16
 * 
 * @author Period - 3
 * @author Assignment - A21_1Numbers
 * 
 * @author Sources - None
 */
public class Number
{
    private int base;

    private int value;

    private LinkedList<Digit> digits = new LinkedList<Digit>();


    /**
     * The default constructor sets the base at 10 and the value to 0.
     */
    public Number()
    {
        this( 0, 10 );
        digits.add( new Digit( 0, 10 ) );
    }


    /**
     * s
     * 
     * @param v
     *            value
     * @param b
     *            base
     */
    public Number( int v, int b )
    {
        value = v;
        base = b;
        digits = new LinkedList<Digit>();
        int remainder = 0;
        while ( v > 0 )
        {
            remainder = v % b;
            v /= b;
            digits.add( 0, new Digit( remainder, b ) );
        }
    }


    /**
     * Increment
     */
    public void increment()
    {
        for ( int i = digits.size() - 1; i >= 0; i-- )
        {
            if ( digits.get( i ).increment() == false )
            {
                return;
            }
        }
        digits.add( 0, new Digit( 1, base ) );
    }


    public String toString()
    {
        String str = "";
        for ( Digit d : digits )
        {
            str += d.toString();
        }
        return str;
    }
}
