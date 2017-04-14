/**
 * This class is for the method that finds a given number of Mersenne primes.
 *
 * @author Bryan Wu
 * @version 9/25/15
 * @author Period: 3
 * @author Assignment: JMCh08_PerfectNumbers
 *
 * @author Sources: None
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * 
     * @param n
     *            number to check if prime
     * @return true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( long n )
    {
        if ( n <= 1 )
        {
            return false;
        }

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
            {
                return false;
            }
            m++;
        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     * // Returns the n-th Fibonacci number. // Precondition: n >= 1 public
     * static long fibonacci(int n) { if (n == 1 || n == 2) return 1; else
     * return fibonacci(n - 1) + fibonacci(n - 2); } Rewrite it without
     * recursion, using one loop.
     *
     * @param n
     *            Fibonacci number to find
     * @return n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        long n1 = 1; // (n-1)
        long n2 = 0; // (n-2)
        long result = 0;
        if ( n >= 1 )
        {
            for ( int fibCount = 2; fibCount <= n; fibCount++ )
            {
                result = n1 + n2;
                n2 = n1;
                n1 = result;
            }
        }

        return result;
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n
     *            number to test
     * @return true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( long n )
    {

        long powerCount = 1;
        long exp1; // perfect number multiple euclid 2^(n-1)
        long exp2; // Mersenne primes (2^n-1)
        long num = 0;

        while ( num < n )
        {
            exp1 = 1; // perfect number multiple euclid 2^(n-1)
            exp2 = 1; // Mersenne primes (2^n-1)
            for ( int i = 0; i < powerCount; i++ )
            {
                exp2 *= 2;
            }
            exp1 = exp2 / 2;
            exp2 -= 1;
            if ( isPrime( exp2 ) )
            {
                num = exp1 * exp2;
                if ( num == n )
                {
                    return true;
                }
            }

            powerCount++;

        }
        return num == n;

    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n
     *            number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n
     *            number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        long powerCount = 1;
        long exp2; // Mersenne primes (2^n-1)
        int count = 0;

        while ( count < n )
        {
            exp2 = 1; // Mersenne primes (2^n-1)
            for ( int i = 0; i < powerCount; i++ )
            {
                exp2 *= 2;
            }
            exp2 -= 1;
            if ( isPrime( exp2 ) )
            {
                System.out.print( exp2 + " " );
                count++;
            }
            powerCount++;

        }

        System.out.println();
    }


    /**
     * Prints the first n even perfect numbers
     * 
     * @param n
     *            number of perfect even numbers to print
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );
        int count = 0;
        for ( long k = 2; count < n; k += 2 )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /*********************************************************************/

    /**
     * This is the main method.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
 * 19-th Fibonacci number = 4181 Perfect numbers: 6 28 496 8128 Mersenne primes:
 * 3 7 31 127 8191 131071 524287 Even perfect numbers: 6 28 496 8128 33550336
 * 8589869056 137438691328
 */