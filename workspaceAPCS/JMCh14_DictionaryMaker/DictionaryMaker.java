import java.util.Scanner;
import java.io.*;


/**
 * Converts text file into dictionary.
 * 
 * @author Bryan Wu
 * @version 11/16/15
 * 
 * @author Period - 3
 * @author Assignment - JM Ch14 - DictionaryMaker
 * 
 * @author Sources - None
 */
public class DictionaryMaker
{
    private static final int MINLENGTH = 3, MAXLENGTH = 5;

    public static Scanner fileIn; // public for test purposes

    public static PrintWriter fileOut; // public for test purposes


    /**
     * This is the main method.
     * 
     * @param args
     *            args
     * @throws IOException
     */
    public static void main( String[] args ) throws IOException
    {
        Scanner kboard = new Scanner( System.in );

        System.out.println();
        System.out.print( "Enter input file name: " );
        String fileName = kboard.next();

        openInputFile( fileName );
        if ( fileIn == null )
        {
            System.out.println( "*** Can't open " + fileName + " ***" );
            return;
        }

        createOutputFile( "RamblecsDictionary.java" );
        if ( fileOut == null )
        {
            fileIn.close();
            System.out.println( "*** Can't create RamblecsDictionary.java ***" );
            return;
        }

        int count = copyWords();
        System.out.println( "Done: " + count + " words." );

        fileIn.close();
        fileOut.close();
    }


    /**
     * Opens a file fileName (in the current folder) and places a reference to
     * it into fileIn
     */
    public static void openInputFile( String fileName )
    {
        File file = new File( fileName );
        try
        {
            fileIn = new Scanner( file );
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
    }


    /**
     * Creates a new file fileName (in the current folder) and places a
     * reference to it into fileOut
     */
    public static void createOutputFile( String fileName )
    {
        File file = new File( fileName );
        try
        {
            fileOut = new PrintWriter( file );
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
    }


    /**
     * Reads all words from fileIn, selects the words that have from MINLENGTH
     * to MAXLENGTH letters, converts them into upper case and writes the words
     * into fileOut in Java syntax
     * 
     * @return number of words processed
     */
    public static int copyWords()
    {
        fileOut.println( "public class RamblecsDictionary" );
        fileOut.println( "{" );
        fileOut.println( "\tpublic String words[] =" );
        fileOut.println( "\t{" );

        int count = 0;
        while ( fileIn.hasNextLine() )
        {
            String word = fileIn.nextLine();
            if ( word.length() >= MINLENGTH && word.length() <= MAXLENGTH )
            {
                count++;
                word = word.toUpperCase();
                fileOut.println( "\t" + "\"" + word + "\",r" );
            }
        }

        fileOut.println( "\t};" );
        fileOut.println( "}" );
        return count;
    }
}
