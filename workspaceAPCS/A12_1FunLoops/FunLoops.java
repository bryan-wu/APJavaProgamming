
/**
 * A class to solve various loop problems
 *
 * @author Bryan Wu
 * @version Sep 18, 2015
 * @author Period: 3
 * @author Assignment: A12_1FunLoops
 *
 * @author Sources: None
 */
public class FunLoops
{
    /**
     * This method finds a given number of magic numbers.
     * 
     * @param n
     *            number of magic squares to find
     */
    public void magicsquare( int n )
    {
        System.out.println( "Magic Squares" );

        long magicNumbers = 1; // number of magicNumbers found (1 is given)
        long squareCount = 1; // consecutive integers to be squared
        long integerCount = 1; // consecutive integers to be added to intSum
        long intSum = 1; // sum of consecutive integers
        long square;

        // loop until set number of magic numbers are found
        while ( magicNumbers <= n )
        {
            square = squareCount * squareCount;
            while ( intSum < square )
            {
                integerCount += 1;
                // intSum isn't reseted for the sake of efficiency
                intSum += integerCount;
            }
            if ( intSum == square )
            {
                System.out.println( magicNumbers + ": " + square );
                magicNumbers++;
            }
            squareCount++;
        }
    }


    /**
     * This method finds the LCM of two given integers.
     * 
     * @param a
     *            first integer
     * @param b
     *            second integer
     * @return result
     */
    public int lcm( int a, int b )
    {
        int multipleA = a; // multiple of integer a
        int multipleB = b; // multiple of integer b
        int countA = 2;
        int countB = 2;

        while ( multipleA != multipleB )
        {
            // begin by comparing a to b, if a is greater, b is multiplied
            // by countB; if b is greater than a, a is multiplied by countA
            if ( multipleA > multipleB )
            {
                multipleB = b * countB;
                countB++;
            }
            else
            {
                multipleA = a * countA;
                countA++;
            }

        }

        return multipleA;
    }


    /**
     * This is the main method.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare( 4 );
        System.out.println();

        System.out.println( "LCM (15, 18) = " + fun.lcm( 15, 18 ) );
        System.out.println( "LCM (40, 12) = " + fun.lcm( 40, 12 ) );
        System.out.println( "LCM (2, 7) = " + fun.lcm( 2, 7 ) );
        System.out.println( "LCM (100, 5) = " + fun.lcm( 100, 5 ) );
        System.out.println();

        fun.magicsquare( 10 );
    }
}
