
/**
 * This class translates english phrases into pig latin.
 *
 * @author Bryan Wu
 * @version Oct 15, 2015
 * @author Period: 3
 * @author Assignment: JMCh10_PigLatinator
 *
 * @author Sources: None
 */
public class PiglatinAnalyzer
{
    private String text;


    /**
     * Constructor: saves the text string
     * 
     * @param text
     *            text
     */
    public PiglatinAnalyzer( String text )
    {
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */
    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        String translation = "";
        int start = 0;
        int end = 0;

        // keep going until end
        while ( start < phraseToTranslate.length() )
        {
            //
            if ( Character.isLetter( phraseToTranslate.charAt( start ) ) )
            {
                for ( end = start; end < phraseToTranslate.length(); end++ )
                {
                    if ( !Character.isLetter( phraseToTranslate.charAt( end ) ) )
                    {
                        // exit loop
                        break;
                    }
                }
                // create a word from first letter to first non letter
                // (non-inclusive)
                String englishWord = phraseToTranslate.substring( start, end );
                translation += wordToPigLatin( englishWord );
                
                // starting at the end
                start = end;
            }
            else
            {
                translation += phraseToTranslate.charAt( start );
                start++;
            }
        }
        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        String pigLatinWord = "";
        String start = "";
        String end = "";

        if ( hasNoVowels( englishWord ) )
        {
            // ayy lmao
            pigLatinWord = englishWord + "ay";
        }
        else if ( startsWithVowel( englishWord ) )
        {
            pigLatinWord = englishWord + "yay";
        }
        else
        {
            int pos = 0;
            while ( pos < englishWord.length() )
            {
                if ( isVowel( englishWord.charAt( pos ) ) )
                {
                    start = englishWord.substring( 0, englishWord.indexOf( englishWord.charAt( pos ) ) );
                    start = start.toLowerCase();
                    end = englishWord.substring( englishWord.indexOf( englishWord.charAt( pos ) ) );

                    // capitalize end if first is already capitalized in texts
                    if ( Character.isUpperCase(englishWord.charAt( 0 ) ) )
                    {
                        end = Character.toUpperCase( end.charAt( 0 ) ) + end.substring( 1 );
                    }
                    pigLatinWord = end + start + "ay";
                    
                    // exit loop
                    break;
                }
                pos++;
            }
        }
        return pigLatinWord;
    }


    /**
     * This method determines if a string starts with a vowel.
     * 
     * @param str
     *            str
     * @return true if the string starts with a vowel
     */
    public boolean startsWithVowel( String str )
    {
        return str.startsWith( "A" ) || str.startsWith( "E" ) || str.startsWith( "I" ) || str.startsWith( "O" )
            || str.startsWith( "U" ) || str.startsWith( "a" ) || str.startsWith( "e" ) || str.startsWith( "i" )
            || str.startsWith( "o" ) || str.startsWith( "u" );
    }


    /**
     * This method determines if a string has any vowels.
     * 
     * @param str
     * @return true if the string has no vowels
     */
    public boolean hasNoVowels( String str )
    {
        return !str.contains( "A" ) && !str.contains( "E" ) && !str.contains( "I" ) && !str.contains( "O" )
            && !str.contains( "U" ) && !str.contains( "a" ) && !str.contains( "e" ) && !str.contains( "i" )
            && !str.contains( "o" ) && !str.contains( "u" );
    }


    /**
     * This method determines if a character is a vowel.
     * 
     * @param c
     *            character
     * @return true if character is vowel
     */
    public boolean isVowel( char c )
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

}
