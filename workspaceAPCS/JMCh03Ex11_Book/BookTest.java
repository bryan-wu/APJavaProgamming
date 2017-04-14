/**
 * This is a class that tests the Book class.
 *
 * @author Bryan Wu
 * @version 8/26/15
 * @author Period: 3
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: None
 */
public class BookTest
{
    /**
     * The main method in this class checks the Book operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Book coolBook = new Book( 3 );
        System.out.println( coolBook.getNumPages() );
        System.out.println( coolBook.getCurrentPage() );
        for ( int i = 0; i < 3; i++ )
        {
            coolBook.nextPage();
            System.out.println( coolBook.getCurrentPage() );
        }
    }
}
