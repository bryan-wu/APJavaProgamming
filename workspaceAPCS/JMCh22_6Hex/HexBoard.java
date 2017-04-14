/**
 * Defines the board for Hex game.
 * 
 * @author Bryan Wu
 * @version 1/21/16
 * 
 * @author Period - 3
 * @author Assignment - JM Ch22.6 - Hex
 * 
 * @author Sources - None
 */
public class HexBoard extends CharMatrix
{
    /**
     * @param rows
     *            rows
     * @param cols
     *            columns
     */
    public HexBoard( int rows, int cols )
    {
        super( rows, cols );
    }


    /**
     * Check if black.
     * 
     * @param r
     *            row
     * @param c
     *            column
     * @return if black
     */
    public boolean isBlack( int r, int c )
    {
        return charAt( r, c ) == 'b' && isInBounds( r, c );
    }


    /**
     * Check if white.
     * 
     * @param r
     *            row
     * @param c
     *            column
     * @return
     */
    public boolean isWhite( int r, int c )
    {
        return charAt( r, c ) == 'w' && isInBounds( r, c );
    }


    /**
     * Check if gray.
     * 
     * @param r
     *            row
     * @param c
     *            column
     * @return
     */
    public boolean isGray( int r, int c )
    {
        return charAt( r, c ) == 'x' && isInBounds( r, c );
    }


    /**
     * Set to black.
     * 
     * @param r
     *            row
     * @param c
     *            column
     */
    public void setBlack( int r, int c )
    {
        setCharAt( r, c, 'b' );
    }


    /**
     * Set to white.
     * 
     * @param r
     *            row
     * @param c
     *            column
     */
    public void setWhite( int r, int c )
    {
        setCharAt( r, c, 'w' );
    }


    /**
     * Set to gray.
     * 
     * @param r
     *            row
     * @param c
     *            column
     */
    public void setGray( int r, int c )
    {
        setCharAt( r, c, 'x' );
    }


    /**
     * Returns true if there is a contiguous chain of black stones that starts
     * in col 0 and ends in the last column of the board; otherwise returns
     * false.
     */
    public boolean blackHasWon()
    {
        int grayCount = 0;
        // call areaFill for each square in the first column
        for ( int i = 0; i < numRows(); i++ )
        {
            areaFill( i, 0 );
        }
        // count the gray stones in the last column to see if any of the gray
        // blobs touch the last column
        for ( int i = 0; i < numRows(); i++ )
        {
            if ( isGray( i, numCols() - 1 ) )
            {
                grayCount++;
            }
        }
        // restore all gray stones on the board back to black and return true or
        // false, appropriately.
        for ( int i = 0; i < numRows(); i++ )
        {
            for ( int k = 0; k < numCols(); k++ )
            {
                if ( isGray( i, k ) )
                {
                    setBlack( i, k );
                }
            }
        }
        return grayCount > 0;
    }


    /**
     * Fills the contiguous area that contains r,c with gray color. Does nothing
     * if r, c is out of bounds or is not black.
     */
    public void areaFill( int r, int c )
    {
        if ( isInBounds( r, c ) && isBlack( r, c ) )
        {
            setGray( r, c );
            areaFill( r - 1, c - 1 );
            areaFill( r + 1, c + 1 );
            areaFill( r - 1, c );
            areaFill( r + 1, c );
            areaFill( r, c - 1 );
            areaFill( r, c + 1 );
        }
    }


    public String toString()
    {
        String s = "";

        for ( int r = 0; r < numRows(); r++ )
        {
            for ( int c = 0; c < numCols(); c++ )
            {
                if ( isBlack( r, c ) )
                    s += 'B';
                else if ( isWhite( r, c ) )
                    s += 'W';
                else if ( isGray( r, c ) )
                    s += 'X';
                else
                    s += '.';
            }
            s += '\n';
        }
        return s;
    }


    // ****************************************************************

    /**
     * Check if chosen coordinates are in bounds
     * 
     * @param row
     *            row
     * @param col
     *            column
     * @return if chosen spot is in bounds
     */
    private boolean isInBounds( int row, int col )
    {
        return row >= 0 && row < numRows() && col >= 0 && col < numCols();
    }
}
