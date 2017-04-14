import java.util.ArrayList;


/**
 * A digit class that represents a single digit with a given base. The digit
 * class has two constructors. The default constructor sets the base at 10 and
 * the value to 0. The other constructor accepts a decimal value and a base.
 * Create a toString method and an increment method. The increment method should
 * return a boolean: true if there is a carry and false if not. For both
 * classes, you can assume that the bases are restricted to binary, octal,
 * decimal or hexadecimal and the values are non-negative.
 * 
 * @author Bryan Wu
 * @version 4/1/16
 * 
 * @author Period - 3
 * @author Assignment - A21_1Numbers
 * 
 * @author Sources - None
 */
public class Digit
{
    private int base;

    private int value;


    /**
     * The default constructor sets the base at 10 and the value to 0.
     */
    public Digit()
    {
        this( 0, 10 );
    }


    /**
     * @param v
     *            value
     * @param b
     *            base
     */
    public Digit( int v, int b )
    {
        value = v;
        base = b;
        int tempBase = b;
        int tempVal = v;
        int quotient = tempVal / tempBase;
        ArrayList<Digit> temp = new ArrayList<Digit>();

        while ( quotient > 0 )
        {
            int remainder = tempVal % tempBase;
            temp.add( new Digit( quotient, b ) );
        }
    }


    /**
     * Return a boolean: true if there is a carry and false if not.
     * 
     * @return true if there is a carry and false if not.
     */
    public boolean increment()
    {
        if ( value + 1 >= base )
        {
            value = 0;
            return true;
        }
        return false;
    }


    public String toString()
    {
        if ( value < 10 )
        {
            return value + "";
        }
        char c = (char)( value - 10 + 'A' );
        return c + "";
    }
}