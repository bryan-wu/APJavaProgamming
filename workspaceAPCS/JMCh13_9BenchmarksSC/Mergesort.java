public class Mergesort extends StepCount
{
    private double[] temp;


    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm.
    public void sort( double[] a )
    {
        addSteps( 2 );

        int n = a.length;
        temp = new double[n];
        recursiveSort( a, 0, n - 1 );
    }


    // Recursive helper method: sorts a[from], ..., a[to]
    private void recursiveSort( double[] a, int from, int to )
    {
        addSteps( 1 );
        if ( to - from < 2 ) // Base case: 1 or 2 elements
        {
            addSteps( 2 );
            if ( to > from && a[to] < a[from] )
            {
                addSteps( 3 );
                double aTemp = a[to]; // swap a[to] and a[from]
                a[to] = a[from];
                a[from] = aTemp;
            }
        }
        else // Recursive case
        {
            addSteps( 1 );
            int middle = ( from + to ) / 2;
            recursiveSort( a, from, middle );
            recursiveSort( a, middle + 1, to );
            merge( a, from, middle, to );
        }
    }


    // Merges a[from] ... a[middle] and a[middle+1] ... a[to]
    // into one sorted array a[from] ... a[to]
    private void merge( double[] a, int from, int middle, int to )
    {
        addSteps( 3 );
        int i = from, j = middle + 1, k = from;

        // While both arrays have elements left unprocessed:
        addSteps( 2 );
        while ( i <= middle && j <= to )
        {
            addSteps( 1 );
            if ( a[i] < a[j] )
            {
                addSteps( 2 );
                temp[k] = a[i]; // Or simply temp[k] = a[i++];
                i++;
            }
            else
            {
                addSteps( 2 );
                temp[k] = a[j];
                j++;
            }
            addSteps( 1 );
            k++;
        }

        // Copy the tail of the first half, if any, into temp:
        addSteps( 1 );
        while ( i <= middle )
        {
            addSteps( 3 );
            temp[k] = a[i]; // Or simply temp[k++] = a[i++]
            i++;
            k++;
        }

        // Copy the tail of the second half, if any, into temp:
        addSteps( 1 );
        while ( j <= to )
        {
            addSteps( 3 );
            temp[k] = a[j]; // Or simply temp[k++] = a[j++]
            j++;
            k++;
        }

        // Copy temp back into a
        addSteps( 1 );
        for ( k = from; k <= to; k++ )
        {
            addSteps( 3 );
            a[k] = temp[k];
        }
    }
}
