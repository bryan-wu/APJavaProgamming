/**
 * As we saw briefly in Chapter 19, a priority queue can be used for sorting.
 * All you have to do is add all the items to a priority queue in any order,
 * then remove them one by one. The items will be returned in ascending order.
 * If the priority queue is implemented as a min-heap, this sorting algorithm
 * will run in O(n log n) time. It is possible to apply this algorithm to an
 * array, without creating a separate priority queue. This efficient algorithm,
 * proposed by J. Williams in 1964, is called Heapsort.
 *
 * @author Bryan Wu
 * @version Mar 8, 2016
 * @author Period: 3
 * @author Assignment: JMCh25_5Heapsort
 *
 * @author Sources: J. Williams
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    public static void sort( double[] a )
    {
        int length = a.length;
        for ( int i = length / 2; i >= 1; i-- )
        {
            reheapDown( a, i, length );
        }
        while ( length > 1 )
        {
            // swap a[0] with a[n-1]:
            double temp = a[0];
            a[0] = a[length - 1];
            a[length - 1] = temp;
            length--;
            reheapDown( a, 1, length );
        }
    }


    // Should be private - made public for testing
    /**
     * Should be private - made public for testing
     * 
     * @param a
     *            a
     * @param i
     *            i
     * @param n
     *            n
     */
    public static void reheapDown( double[] a, int i, int n )
    {
        int b = i - 1;
        // initiate brain sizzling . . .
        while ( 2 * b + 1 < n )
        {
            if ( 2 * b + 2 == n )
            {
                if ( a[b] > a[2 * b + 1] )
                {
                    return;
                }

                else
                {
                    double t = a[b];
                    a[b] = a[2 * b + 1];
                    a[2 * b + 1] = t;
                    return;
                }
            }
            if ( a[b] >= a[2 * b + 1] && a[b] >= a[2 * b + 2] )
            {
                return;
            }
            if ( a[2 * b + 1] > a[2 * b + 2] )
            {
                double t = a[b];
                a[b] = a[2 * b + 1];
                a[2 * b + 1] = t;
                b = 2 * b + 1;
            }
            else
            {
                double t = a[b];
                a[b] = a[2 * b + 2];
                a[2 * b + 2] = t;
                b = 2 * ( b + 2 );
            }
        }
    }
}
