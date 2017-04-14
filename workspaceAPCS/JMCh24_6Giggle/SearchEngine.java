import java.util.*;


/**
 * This is the Search Engine.
 * 
 * @author Bryan Wu
 * @version 2/12/16
 * 
 * @author Period - 3
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - None
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    // Constructor(s)
    /**
     * @param url
     *            url
     */
    public SearchEngine( String url )
    {
        myIndex = new HashMap<String, List<String>>( 20000 );
        myURL = url;
    }


    // Methods
    /**
     * Return myURL.
     * 
     * @return myURL
     */
    public String getURL()
    {
        return myURL;
    }


    /**
     * Extracts all words from line, and, for each word, adds line to its list
     * of lines in myIndex. This method obtains a set of all words in line by
     * calling a private method parseWords(line) (see below). Use a LinkedList
     * <String> object to represent a list of lines associated with a word.
     * 
     * @param line
     *            line
     */
    public void add( String line )
    {
        Set<String> words = parseWords( line );
        LinkedList<String> key = new LinkedList<String>();

        for ( String word : words )
        {
            if ( !myIndex.containsKey( key ) )
            {
                myIndex.put( word, key );
            }
            myIndex.get( word ).add( line );
        }
    }


    /**
     * Returns the list of lines associated with word in myIndex.
     * 
     * @param word
     *            word
     * @return Returns the list of lines associated with word in myIndex.
     */
    public List<String> getHits( String word )
    {
        return myIndex.get( word );
    }


    /**
     * Returns a set of all words in line. Use the same technique for extracting
     * all the words from line as you did in the Index Maker lab in Section
     * <...>: call line.split("\\W+"). Add all the elements from the resulting
     * array to a TreeSet. Skip empty words and convert each word to lower case
     * before adding it to the set. parseWords uses a set, as opposed to a list,
     * because we don’t want to index the same line multiple times when the same
     * word occurs several times in it. When we add words to the set, duplicates
     * are automatically eliminated.
     * 
     * @param line
     *            line
     * @return a set of all words in line
     */
    private Set<String> parseWords( String line )
    {
        String[] words = line.split( "\\W+" );
        TreeSet<String> wordsTree = new TreeSet<String>();
        for ( String str : words )
        {
            if ( !str.isEmpty() )
            {
                str = str.toLowerCase();
                wordsTree.add( str );
            }
        }
        return wordsTree;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
