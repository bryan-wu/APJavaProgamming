import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;


/**
 * A program that accomplishes the following:
 * 
 * Load the text file digital.txt representing the 20 x 20 grid of black and
 * white squares.
 * 
 * Ask the user for the starting coordinate of an attempted erasure. If this
 * starting coordinate is part of an object, the program should erase the entire
 * object (change black to white).
 * 
 * Print out the grid afterwards.
 *
 * @author Bryan Wu
 * @version 11/12/15
 * @author Period: 3
 * @author Assignment: AB24_1EraseObject_GridWorld
 *
 * @author Sources: None
 */
public class EraseObject extends World<Tile>
{
    private static final Color IMGOBJ_COLOR = Color.BLACK;

    private static final Color ERASE_COLOR = Color.WHITE;


    /**
     * Constructs a default 20x20 grid containing black tiles at the locations
     * given in the file "digital.txt".
     */
    public EraseObject()
    {
        this( new BoundedGrid<Tile>( 20, 20 ), "digital.txt" );
    }


    /**
     * Constructs an EraseObject World with the provided grid. Populates the
     * world with black tile objects at the locations given in the specified
     * file (fName).
     * 
     * @param bg
     *            bounded grid used by this World
     * @param fName
     *            name of file containing location information for tile
     *            placement in this World
     */
    public EraseObject( BoundedGrid<Tile> bg, String fName )
    {
        setGrid( bg );
        getData( fName );

        setMessage( "Click on the object to be erased" );
    }


    /**
     * Overrides
     * <code>info.gridworld.world.World&lt;Tile&lt;.locationClicked</code> This
     * method is called when the user clicks on a location in the WorldFrame.
     * Invokes the recursive erase procedure on the clicked location.
     * 
     * @param loc
     *            the grid location that the user selected
     * @return true - the world consumes the click
     */
    public boolean locationClicked( Location loc )
    {
        Grid<Tile> gr = getGrid();

        setMessage( "Tile clicked at " + loc );
        erase( gr, loc.getRow(), loc.getCol() );

        return true;
    }


    /**
     * Loads the data from the specified file containing tile locations into the
     * this grid.
     * 
     * The first entry in the provided text file is the number of pairs that
     * follow (i.e., 55). Each subsequent line contains a pair of integers,
     * separated by a blank space. Each pair is a row and column coordinate that
     * specifies the location of a black tile in the starting grid.
     * 
     * @param fName
     *            name of file containing tile locations
     */
    private void getData( String fName )
    {
        File file = new File( fName );
        Scanner scan;
        int numPairs = 0;
        int row = 0;
        int col = 0;

        try
        {
            scan = new Scanner( file );

            // check for number that gives number of pairs
            if ( scan.hasNextInt() )
            {
                numPairs = scan.nextInt();
                for ( int i = 0; i < numPairs; i++ )
                {
                    row = scan.nextInt();
                    col = scan.nextInt();
                    getGrid().put( new Location( row, col ), 
                        new Tile( IMGOBJ_COLOR ) );
                }
            }
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }

    }


    /**
     * Recursively changes the color of a series of adjacent tiles (erases)
     * starting at the given coordinates if this coordinate is part of the
     * object. The method should erase the entire object (remove black).
     *
     * @param gr
     *            grid containing sequences of adjacent tiles
     * @param row
     *            row coordinate to begin erasure
     * @param col
     *            column coordinate to begin erasure
     */
    private void erase( Grid<Tile> gr, int row, int col )
    {
        Location loc = new Location( row, col );

        if ( gr.isValid( loc ) && gr.get( loc ) != null 
                        && gr.get( loc ).getColor().equals( IMGOBJ_COLOR ) )
        {
            gr.put( loc, new Tile( ERASE_COLOR ) );

            // erase up
            erase( gr, row - 1, col );
            // erase down
            erase( gr, row + 1, col );
            // erase left
            erase( gr, row, col - 1 );
            // erase right
            erase( gr, row, col + 1 );

        }

    }


    /**
     * This is the main method.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        new EraseObject().show();
    }
}
