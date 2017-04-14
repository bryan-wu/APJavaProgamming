/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author Bryan Wu
 * @version 10/1/15
 * @author Period: 3
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: None
 */
public class Complex
{
    // instance variables

    /**
     * a of a+b*i
     */
    private double a;

    /**
     * b of a+b*i
     */
    private double b;


    // Constructors

    /**
     * @param p1
     *            a of a+b*i
     * @param p2
     *            b of a+b*i
     */
    public Complex( double p1, double p2 )
    {
        a = p1;
        b = p2;
    }


    /**
     * @param a
     *            a of a+b*i
     */
    public Complex( double p1 )
    {
        new Complex( p1, 0 );
    }


    // Methods

    /**
     * Returns square root of a*a + b*b
     * 
     * @return square root of a*a + b*b
     */
    public double abs()
    {
        return Math.sqrt( a * a + b * b );
    }


    /**
     * This method builds and returns the sum of this number and other.
     * 
     * @param other
     *            other Complex to add
     * @return sum of two Complexes
     */
    public Complex add( Complex other )
    {
        return new Complex( other.a + a, other.b + b );
    }


    /**
     * This method builds and returns a new complex number: the product.
     * 
     * @param other
     *            other Complex to multiply
     * @return product of two Complexes
     */
    public Complex multiply( Complex other )
    {
        // multiple = a*c + a*di + bi*c + bi*di
        return new Complex( a * other.a + -b * other.b, a * other.b + b * other.a );
    }


    /**
     * This method builds and returns the sum of this number and other.
     * 
     * @param p1
     *            a of a+b*i
     * @return sum of this Complex number with a double
     */
    public Complex add( double p1 )
    {
        return new Complex( a + p1, b );
    }


    /**
     * This method builds and returns a new complex number: the product.
     * 
     * @param p1
     *            a of a+b*i
     * @return product of a Complex and a double
     */
    public Complex multiply( double p1 )
    {
        return new Complex( p1 * a, p1 * b );
    }


    /**
     * This method returns a string representation of the number in the form a +
     * bi.
     *
     * @return string string representation of the number in the form a + bi.
     */
    public String toString()
    {
        return a + " + " + b + "i";
    }
}
