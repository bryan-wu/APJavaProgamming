/**
 * The ASCIIArt program prints the name "George", the initials GKP and a some
 * fish to standard output using ascii characters to make a picture.
 * 
 * @author TODO enter your name
 * @version TODO enter the date Period:
 * @author TODO enter your period
 * 
 * @author Assignment:  ASCIIArt
 * 
 * @author Sources: TODO: list collaborators
 */
public class ASCIIArt
{
    public ASCIIArt()
    {
        System.out.println( "George's ASCII Art" );
        System.out.println();
    }

    public void firstName()
    {
        // print out George using letters
        System.out.println( " GGGG   " );
        System.out.println( "G    G  " );
        System.out.println( "G        eee    ooo   r rr    ggg    eee " );
        System.out.println( "G       e   e  o   o  r   r  g   g  e   e" );
        System.out.println( "G  GGG  eeeee  o   o  r      g   g  eeeee" );
        System.out.println( "G    G  e      o   o  r      g   g  e    " );
        System.out.println( " GGGG    eee    ooo   r       gggg   eee " );
        System.out.println( "                                 g" );
        System.out.println( "                              g  g" );
        System.out.println( "                               gg" );
    }

    public void initials()
    {
        // System.out.print doesn't attach a trailing newline character. We can
        // do this on our own with \n. The \t's are used for inserting tabs
        System.out.print( "\n\t\tor...\n\n" );

        // print out GKP using "tiles"
        System.out.println( " _/_/_/_/  _/    _/  _/_/_/" );
        System.out.println( "_/         _/  _/    _/   _/" );
        System.out.println( "_/   _/_/  _/_/      _/_/_/" );
        System.out.println( "_/     _/  _/  _/    _/" );
        System.out.println( " _/_/_/    _/    _/  _/" );

        System.out.print( "\n\t\tor...\n" );
        // print out GKP using brackets
        System.out.println( "  _______________________" );
        // Java uses a double back slash (\\) to denote an actual backslash
        // character. The reason for this is because \ is an escape sequence for
        // special ascii characters
        System.out.println( " /                       \\" );
        System.out.println( "|  [][][]  []  [] [][][]  |" );
        System.out.println( "| []       [] []  []   [] |" );
        System.out.println( "| []  [][] [][]   [][][]  |" );
        System.out.println( "| []    [] [] []  []      |" );
        System.out.println( "|  [][][]  []  [] []      |" );
        System.out.println( " \\_______________________/" );
    }

    public void fish()
    {
        System.out.print( "\n\t\tor...\n" );
        // print out some ascii fish...just because
        System.out.println( "                          ,     " );
        System.out.println( "               ()       _/{     " );
        System.out.println( "        ,_         o  .'   './`>" );
        System.out.println( "        _}\\_ O       / a ((  =< " );
        System.out.println( "   <`\\.'    '. o     '.,__,.'\\_>" );
        System.out.println( "    >    )) e \\           \\)    " );
        System.out.println( "   <_/'.,___,.'                 " );

        System.out.println();
    }

    public static void main( String[] args )
    {
        ASCIIArt asciiArtist = new ASCIIArt();
        asciiArtist.firstName();
        asciiArtist.initials();
        asciiArtist.fish();
    } // main
} // ASCIIArt
