/**
 * This class helps to create and verify lipograms. It shows the original text,
 * below it the same text with all letters e replaced with #, and to the right,
 * the list of all ‘offending’ words (with an e in them). The user can load a
 * lipogram text from a file or type it in or cut and paste it from another
 * program. There is also a menu command to save the text.
 * 
 * @author Bryan Wu
 * @version 10/6/15
 * 
 * @author Period - 3
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - None
 */
public class LipogramAnalyzer
{
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        // replace each occurrence of the letter with a #
        return text.replaceAll( letter + "", "#" );
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        int spaceIndex = 0; // index of first space character
        String textCopy = text; // copy of text to be modified
        String result = "";
        String offenses = ""; // use this to check for duplicates
        String word; // word of text that will checked for occurrence of letter
        // once

        while ( textCopy.contains( letter + "" ) )
        {
            // will return -1 if space character not found
            if ( textCopy.indexOf( ' ' ) > 0 )
            {
                spaceIndex = textCopy.indexOf( ' ' );
                word = textCopy.substring( 0, spaceIndex );
                textCopy = textCopy.substring( spaceIndex + 1 );
            }

            else
            {
                word = textCopy;
                textCopy = "";
            }

            if ( word.contains( letter + "" ) )
            {

                if ( !offenses.contains( word ) )
                {
                    result += word + "\n";
                    offenses += word + " ";
                }
            }

        }

        return result;

    }


    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace. It is made public for test purposes.
     * 
     * @param pos
     *            location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        String word = "";
        int startIndex;
        int endIndex;
        if ( Character.isLetter( text.charAt( pos ) ) )
        {
            startIndex = text.lastIndexOf( ' ', pos ) + 1; // start of the word
            endIndex = text.indexOf( ' ', pos ); // end of the word
            word = text.substring( startIndex, endIndex );
        }

        return word;
    }
}
