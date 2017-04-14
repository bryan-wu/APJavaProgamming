import java.util.Arrays;


/**
 * Maintains a lookup table for substitutions for the letters ‘A’ through ‘Z’.
 * 
 * @author Bryan Wu
 * @version 2/8/16
 * 
 * @author Period - 3
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 * @author Sources - None
 */
public class Enigma
{
    private char lookupTable[];


    /**
     * @param numLetters
     *            number of letters
     */
    public Enigma( int numLetters )
    {
        lookupTable = new char[numLetters];
    }


    /**
     * Assumes that subs contains 26 characters and saves it as the lookup
     * table.
     * 
     * @param index
     *            index
     * @param ch
     *            character
     */
    public void setSubstitution( int index, char ch )
    {
        lookupTable[index] = ch;
    }


    /**
     * Decodes all the letters in text according to the current lookup table.
     * Decode leaves all characters that are not letters unchanged and preserves
     * the upper or lower case of letters.
     * 
     * @param text
     *            encrypted text
     * @return decoded string, which has the same length as text.
     */
    public String decode( String text )
    {
        // for ( int i = 0; i < lookupTable.length; i++ )
        // {
        // lookupTable[i] = '-';
        // }
        StringBuffer buffer = new StringBuffer( text.length() );
        char c;
        int indx = 0;

        for ( int index = 0; index < text.length(); index++ )
        {
            c = text.charAt( index );
            if ( Character.isLowerCase( c ) )
            {
                indx = Character.getNumericValue( text.charAt( index ) ) - Character.getNumericValue( 'a' );
                buffer.append( ( "" + lookupTable[indx] ).toLowerCase() );
            }
            else if ( Character.isUpperCase( c ) )
            {
                indx = Character.getNumericValue( text.charAt( index ) ) - Character.getNumericValue( 'A' );
                buffer.append( ( "" + lookupTable[indx] ).toUpperCase() );
            }
            else
            {
                buffer.append( c );
            }

        }
        return buffer.toString();
    }


    /**
     * Returns computer-generated hints for each letter in the encrypted text.
     * It works as follows. First it counts the number of occurrences for each
     * of the letters ‘a’ through ‘z’ in text (case blind) and saves these 26
     * counts in an array.
     * 
     * @param text
     *            text
     * @param lettersByFrequency
     *            lettersByFrequency
     * @return computer-generated hints for each letter in the encrypted text
     */
    public String getHints( String text, String lettersByFrequency )
    {
        int letterCounts[] = countLetters( text );
        String result = "";
        int pos;

        for ( int i = 0; i < letterCounts.length; i++ )
        {
            pos = 0;

            for ( int j = 0; j < letterCounts.length; j++ )
            {
                if ( letterCounts[j] < letterCounts[i] || letterCounts[i] == letterCounts[j] && i > j )
                {
                    pos++;
                }
            }
            result += lettersByFrequency.charAt( pos );
        }
        return result;
    }


    /**
     * Counts the number of occurrences for each of the letters ‘a’ through ‘z’
     * in text (case blind) and saves these 26 counts in an array.
     * 
     * @param text
     *            text
     * @return number of occurrences for each of the letters ‘a’ through ‘z’ in
     *         text (case blind) and saves these 26 counts in an array.
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];

        for ( char c : text.toCharArray() )
        {
            if ( c >= 'A' && c <= 'Z' )
            {
                counts[c - 'A']++;

            }
            else if ( c >= 'a' && c <= 'z' )
            {
                counts[c - 'a']++;
            }
        }

        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation

    protected char[] getLookupTable()
    {
        return lookupTable;
    }


    protected int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}