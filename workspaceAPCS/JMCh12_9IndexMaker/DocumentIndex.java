import java.util.ArrayList;


/**
 * A DocumentIndex object represents the entire index for a document: the list
 * of all its index entries. The index entries should always be arranged in
 * alphabetical order, as in Figure 12-6.
 *
 * @author Bryan Wu
 * @version Nov 6, 2015
 * @author Period: 3
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: None
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{
    // Creates an empty DocumentIndex with the default
    // initial capacity.
    /**
     * Creates an empty DocumentIndex with the default initial capacity.
     */
    public DocumentIndex()
    {
        super();
    }


    // Creates an empty DocumentIndex with a given
    // initial capacity.
    /**
     * Creates an empty DocumentIndex with a given initial capacity.
     * 
     * @param initialCapacity
     *            initialCapacity
     */
    public DocumentIndex( int initialCapacity )
    {
        super( initialCapacity );
    }


    // If word is not yet in this DocumentIndex,
    // creates a new IndexEntry for word, and inserts
    // it into this list in alphabetical order;
    // adds num to this word's IndexEntry by calling
    // its add(num) method.
    /**
     * If word is not yet in this DocumentIndex, creates a new IndexEntry for
     * word, and inserts it into this list in alphabetical order; adds num to
     * this word's IndexEntry by calling its add(num) method.
     * 
     * @param word
     *            word
     * @param num
     *            num
     */
    public void addWord( String word, int num )
    {
        get( foundOrInserted( word ) ).add( num );
        return;
    }


    // For each word in str, calls addWord(word, num).
    /**
     * For each word in str, calls addWord(word, num).
     * 
     * @param str
     *            str
     * @param num
     *            num
     */
    public void addAllWords( String str, int num )
    {
        // non-word character regex
        String[] words = str.split( "\\W+" );

        // gotta love them enchanced for loop
        for ( String word : words )
        {
            if ( word.length() > 0 )
            {
                addWord( word, num );
            }
        }
        return;
    }


    // Tries to find an IndexEntry with a given word in this
    // DocumentIndex. If not found, inserts a new EndexEntry for
    // word at the appropriate place (in lexicographical order).
    // Returns the index of the found or inserted IndexEntry
    /**
     * Tries to find an IndexEntry with a given word in this DocumentIndex. If
     * not found, inserts a new IndexEntry for word at the appropriate place (in
     * lexicographical order). Returns the index of the found or inserted
     * IndexEntry
     * 
     * @param word
     *            word
     * @return the index of the found or inserted IndexEntry
     */
    private int foundOrInserted( String word )
    {
        int indx;
        int stringCompare;
        for ( indx = 0; indx < size(); indx++ )
        {
            // compare strings
            stringCompare = get( indx ).getWord().compareToIgnoreCase( word );

            // return index if word is found
            if ( stringCompare == 0 )
            {
                return indx;
            }

            // if string greater than word stop
            else if ( stringCompare > 0 )
            {
                break;
            }
        }
        add( indx, new IndexEntry( word ) );
        return indx;
    }
}
