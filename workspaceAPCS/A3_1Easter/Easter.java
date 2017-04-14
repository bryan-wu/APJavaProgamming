import java.lang.reflect.*;
import java.util.Scanner;


/**
 * This program uses an algorithm devised in 1876 and first appeared in
 * Butcher's Ecclesiastical Handbook to determine the date of Easter in a given
 * year.
 *
 * @author Bryan Wu
 * @version Sep 3, 2015
 * @author Period: 3
 * @author Assignment: A3_1Easter
 *
 * @author Sources: None
 */
public class Easter
{
    // A convenient algorithm for determining the date of Easter in a given year
    // was devised in 1876 and first appeared in Butcher’s Ecclesiastical
    // Handbook. This algorithm holds for any year in the Gregorian calendar,
    // which means years including and after 1583. Subject to minor adaptations,
    // the algorithm is as follows:
    //
    // 1. Let y be the year (such as 1583 or 2003).
    // 2. Divide y by 19 and call the remainder a. Ignore the quotient.
    // 3. Divide y by 100 and get a quotient b and a remainder c.
    // 4. Divide b by 4 and get a quotient d and a remainder e.
    // 5. Divide b + 8 by 25 and get a quotient f. Ignore the remainder.
    // 6. Divide b - f + 1 by 3 and get a quotient g. Ignore the remainder.
    // 7. Divide 19 * a + b - d - g + 15 by 30 and get a remainder h. Ignore the
    // quotient.
    // 8. c by 4 and get a quotient i and a remainder k.
    // 9. Divide 32 + 2 * e + 2 * i - h - k by 7 and get a remainder r. Ignore
    // the
    // quotient.
    // 10. Divide a + 11 * h + 22 * r by 451 and get a quotient m. Ignore the
    // remainder.
    // 11. Divide h + r - 7 * m + 114 by 31 and get a quotient n and a remainder
    // p.

    private int y;

    private int a;

    private int b;

    private int c;

    private int d;

    private int e;

    private int f;

    private int g;

    private int h;

    private int i;

    private int k;

    private int r;

    private int m;

    // The value of n gives the month (3 for March and 4 for April) and the
    // value of p + 1 gives the day of the month.
    private int n;

    private int p;


    /**
     * This is a constructor for the Easter class.
     * 
     * @param year
     *            Given year
     */
    public Easter( int year )
    {
        y = year;
    }


    /**
     * This method calculates the date of Easter in a given year and prints the
     * result out.
     */
    public void calculate()
    {
        a = y % 19;
        System.out.println( "a = " + a );
        b = y / 100;
        System.out.println( "b = " + b );
        c = y % 100;
        System.out.println( "c = " + c );
        d = b / 4;
        System.out.println( "d = " + d );
        e = b % 4;
        System.out.println( "e = " + e );
        f = ( b + 8 ) / 25;
        System.out.println( "f = " + f );
        g = ( b - f + 1 ) / 3;
        System.out.println( "g = " + g );
        h = ( 19 * a + b - d - g + 15 ) % 30;
        System.out.println( "h = " + h );
        i = c / 4;
        System.out.println( "i = " + i );
        k = c % 4;
        System.out.println( "k = " + k );
        r = ( 32 + 2 * e + 2 * i - h - k ) % 7;
        System.out.println( "r = " + r );
        m = ( a + 11 * h + 22 * r ) / 451;
        System.out.println( "m = " + m );
        n = ( h + r - 7 * m + 114 ) / 31;
        System.out.println( "n = " + n );
        p = ( h + r - 7 * m + 114 ) % 31;
        System.out.println( "p = " + p );
        System.out.println( "" );
        System.out.println( "Easter in " + y + 
            " falls on " + n + "/" + ( p + 1 ) );
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
     * This is the main method of the Easter class. It prompts the user to input
     * a given year and calls the needed methods to return the date of Easter in
     * the given year.
     * 
     * @param args
     *            args array
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the year (yyyy) --> " );
        int year = console.nextInt();

        Easter bunny = new Easter( year );
        bunny.calculate();
    }
}
