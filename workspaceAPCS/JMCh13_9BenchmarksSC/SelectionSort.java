public class SelectionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Selection Sort.
    public void sort( double[] a )
    {
        addSteps( 1 ); // initialize outer = 0
        for ( int n = a.length; n > 1; n-- )
        {
            addSteps( 3 );
            // 1 - boundary check of outer loop;
            // 2 - increment, outer++
            // 3 - initialization of inner loop

            // Find the index iMax of the largest element
            // among a[0], ..., a[n-1]:

            int iMax = 0;
            for ( int i = 1; i < n; i++ )
            {
                addSteps( 3 );
                // 1 - boundary check of outer loop;
                // 2 - increment, outer++
                // 3 - initialization of inner loop
                if ( a[i] > a[iMax] )
                {
                    iMax = i;
                }
            }

            addSteps( 3 );
            // Swap a[iMax] with a[n-1]:
            swap( a, iMax, n - 1 );

            // Decrement n (accomplished by n-- in the for loop).
        }
    }
}
