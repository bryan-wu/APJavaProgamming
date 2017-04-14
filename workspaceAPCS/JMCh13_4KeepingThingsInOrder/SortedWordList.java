/**
 * Implements a sorted list of words
 * 
 * @author Bryan Wu
 * @version 11/17/15
 * 
 * @author Period - 3
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - None
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    private int capacity;


    /**
     * No-args constructor.
     */
    public SortedWordList()
    {
        capacity = 0;
    }


    /**
     * One int param constructor
     * 
     * @param cap
     *            capacity of list
     */
    public SortedWordList( int cap )
    {
        capacity = cap;
    }


    /**
     * Redefined contains method that uses Binary Search
     * 
     * @param str
     *            string
     * @return if this contains str
     */
    public boolean contains( String str )
    {
        return this.indexOf( str ) != -1;
    }


    /**
     * Redefined indexOf method that uses Binary Search
     * 
     * @param str
     *            string
     * @return index of str
     */
    public int indexOf( String str )
    {
        int left = 0;
        int middle;
        int right = this.size() - 1;

        while ( left <= right )
        {
            // pretty much the average from integer division
            middle = ( left + right ) / 2;

            // if the middle number is equal, return it
            if ( str.equalsIgnoreCase( this.get( middle ) ) )
            {
                return middle;
            }
            // otherwise,
            else
            {
                // if the string is less than middle, use the left half words
                if ( str.compareToIgnoreCase( this.get( middle ) ) < 0 )
                {
                    right = middle - 1;
                }
                // otherwise use the right half
                else
                {
                    left = middle + 1;
                }
            }
        }
        // if all else fails return -1
        return -1;
    }


    /**
     * It first checks whether word fits alphabetically between the (i -1)-th
     * and (i + 1)-th elements and is not equal to either of them. If this is
     * not so, set should throw an IllegalArgumentException
     * 
     * @param i
     *            i
     * @param word
     *            word
     * @return It first checks whether word fits alphabetically between the (i
     *         -1)-th and (i + 1)-th elements and is not equal to either of
     *         them. If this is not so, set should throw an
     *         IllegalArgumentException
     */
    public String set( int i, String word )
    {

        // check if i is 0 first so that indexOutOfBounds doesnt occur when get
        // is called
        if ( ( i == 0 || ( i - 1 ) >= 0 && word.compareToIgnoreCase( this.get( i - 1 ) ) > 0 )
            && ( ( i + 1 ) <= this.size() && word.compareToIgnoreCase( this.get( i + 1 ) ) < 0 ) )
            return super.set( i, word );
        else
        {
            throw new IllegalArgumentException( "word =" + word + "  i =" + i );
        }
    }


    /**
     * It first checks whether word fits alphabetically between the (i - 1 )-th
     * and i-th elements and is not equal to either of them. If this is not so,
     * throw an IllegalArgumentException.
     * 
     * @param i
     * @param word
     * @return it first checks whether word fits alphabetically between the (i -
     *         1 )-th and i-th elements and is not equal to either of them. If
     *         this is not so, throw an IllegalArgumentException.
     */
    public void add( int i, String word )
    {
        // make sure nothing goes out of bounds
        if ( ( i > 0 && word.compareToIgnoreCase( get( i - 1 ) ) <= 0 )
            || ( i < size() - 1 && word.compareToIgnoreCase( get( i + 1 ) ) >= 0 ) )
        {
            throw new IllegalArgumentException( "word =" + word + "  i =" + i );
        }
        else
        {
            super.add( i, word );
        }
    }


    /**
     * It inserts word into the list in alphabetical order. If word is already
     * in the list, add should not insert it and should return false; otherwise,
     * if successful, add should return true.
     * 
     * @param word
     *            word
     * @return If word is already in the list, add should not insert it and
     *         should return false; otherwise, if successful, add should return
     *         true.
     */
    public boolean add( String word )
    {
        // thank you lecture powerpoint for the sample code
        int left = 0;
        int right = size();

        while ( left < right )
        {
            int middle = ( left + right ) / 2;
            int diff = word.compareToIgnoreCase( get( middle ) );

            // use right half of words if the word is greater than middle
            if ( diff > 0 )
            {
                left = middle + 1;
            }
            // otherwise, use the left half of words
            else if ( diff < 0 )
            {
                right = middle;
            }
            // if all else fails return false
            else
            {
                return false;
            }
        }
        super.add( right, word );
        return true;
    }


    /**
     * This method should insert into this list in alphabetical order all the
     * words from additionalWords that are not already in this list. merge
     * should be efficient.
     * 
     * @param moreWords
     *            moreWords
     */
    public void merge( SortedWordList moreWords )
    {
        for ( String s : moreWords )
        {
            add( s );
        }
    }

}
