public class InsertionSort extends StepCount
{

    // Sorts a[0], ..., a[size-1] in ascending order
    // using Insertion Sort.
    public void sort( double[] a )
    {
        addSteps( 1 ); // initialize outer = 0
        for ( int n = 1; n < a.length; n++ )
        {
            addSteps( 3 );
            // 1 - boundary check of outer loop;
            // 2 - increment, outer++
            // 3 - initialization of inner loop

            addSteps( 1 );
            // Save the next element to be inserted:
            double aTemp = a[n];

            // Going backward from a[n-1], shift elements to the
            // right until you find an element a[i] <= aTemp:
            int i = n;
            while ( i > 0 && aTemp < a[i - 1] )
            {
                addSteps( 5 );
                // 1 - boundary check of outer loop;
                // 2 - increment, outer++

                a[i] = a[i - 1];
                i--;
            }

            // Insert the saved element after a[i]:
            addSteps( 1 );
            a[i] = aTemp;
        }
    }
}
