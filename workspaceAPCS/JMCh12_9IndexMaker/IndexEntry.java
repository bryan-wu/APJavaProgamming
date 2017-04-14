import java.util.ArrayList;


public class IndexEntry
{
    private String word;

    private ArrayList<Integer> numsList;


    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    /**
     * Constructs an IndexEntry for a given word (converted to upper case); sets
     * numsList to an empty ArrayList.
     * 
     * @param word
     *            word
     */
    public IndexEntry( String word )
    {
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    // Returns the word of this IndexEntry object.
    /**
     * This method returns the word of this IndexEntry object.
     * 
     * @return word word
     */
    public String getWord()
    {
        return word;
    }


    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    /**
     * If num is not already in the list, adds num at the end of this
     * IndexEntry's list of numbers.
     * 
     * @param num
     *            num
     */
    public void add( int num )
    {
        if ( !numsList.contains( (Integer)num ) )
        {
            numsList.add( num );
        }
        return;
    }


    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    /**
     * Converts this IndexEntry into a string in the following format: the word
     * followed by a space, followed by numbers separated by a comma and a
     * space.
     */
    public String toString()
    {
        String result = word + " ";
        for ( int i = 0; i < numsList.size() - 1; i++ )
        {
            result += " " + numsList.get( i ) + ",";
        }
        result += " " + numsList.get( numsList.size() - 1 );
        return result;
    }
}
