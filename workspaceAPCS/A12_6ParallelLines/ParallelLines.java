import java.awt.*;
import javax.swing.*;


/**
 * This class uses nested for loops and to draw an illusion of parallel lines
 * and black and whites boxes.
 *
 * @author Bryan Wu
 * @version Sep 22, 2015
 * @author Period: 3
 * @author Assignment: A12_6ParallelLines
 *
 * @author Sources: None
 */
public class ParallelLines extends JPanel
{

    /**
     * This method stores the width and height of the window and calls the
     * method that draws the illusion.
     * 
     * @param g
     *            Graphics drawer
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background

        int width = getWidth();
        int height = getHeight();

        drawIllusion( g, width, height );
    }


    /**
     * This method draws the illusion using nested for loops.
     * 
     * @param g
     *            Graphics drawer
     * @param width
     *            width of window
     * @param height
     *            height of window
     */
    public void drawIllusion( Graphics g, int width, int height )
    {
        int squareSide = width / 15; // side length of each square
        int xCoord;
        int yCoord = squareSide; // y coordinate of first row with offset
        int offset = 0;

        for ( int row = 0; row < 8; row++ )
        {

            // calculate the offset in increments of thirds of the square's side
            // length depending on the row #. we can use mod 4 because the
            // filled squares can be seen as being placed in sets of 4.
            if ( row % 4 == 0 )
            {
                // no offset
                offset = 0;
            }
            if ( row % 4 == 1 )
            {
                offset = squareSide / 3;
            }
            if ( row % 4 == 2 )
            {
                offset = 2 * squareSide / 3;
            }
            if ( row % 4 == 3 )
            {
                offset = squareSide / 3;
            }

            // calculate the start of the row of squares and add a horizontal
            // offset
            xCoord = squareSide + offset;

            for ( int col = 0; col < 7; col++ )
            {
                // draw the square
                g.fillRect( xCoord, yCoord, squareSide, squareSide );

                // calculate and position for the next square
                xCoord += 2 * squareSide;
            }

            yCoord += squareSide;

            // calculate the location and draw the line. 2 is added to row in
            // the y coordinates to skip the first two lengths of squareSide
            // that are used as an offset
            g.drawLine( squareSide, squareSide * ( row + 2 ), 15 * squareSide, 
                squareSide * ( row + 2 ) );
        }
    }


    /**
     * Main method.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "ParallelLines" );
        w.setBounds( 100, 100, 640, 480 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        ParallelLines panel = new ParallelLines();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( true );
        w.setVisible( true );
    }
}
