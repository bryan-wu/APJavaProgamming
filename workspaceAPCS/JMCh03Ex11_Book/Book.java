/**
 * This program simulates flipping through pages of a book. This program serves
 * to show the use of a class's fields, constructors, and methods.
 *
 * @author Bryan Wu
 * @version 8/26/15
 * @author Period: 3
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: None
 */
public class Book
{
    // data fields
    int numPages;

    int currentPage;


    /**
     * Constructor.
     * 
     * @param pages
     */
    public Book( int pages )
    {
        numPages = pages;
        currentPage = 1;
    }


    // methods
    public int getNumPages()
    {
        return numPages;
    }


    public int getCurrentPage()
    {
        return currentPage;
    }


    public void nextPage()
    {
        if ( currentPage < numPages )
        {
            currentPage++;
        }
    }
}
