import java.awt.*;
import javax.swing.*;


/**
 * This program draws an ornament of nested triangles
 * 
 * @author Bryan Wu
 * @version 9/15/15
 * 
 * @author Period - 3
 * @author Assignment - Ch04 Ex4-16 Ornament
 * 
 * @author Sources - None
 */
public class Ornament extends JPanel
{

    /**
     * Paint background and call drawTriangles method.
     * 
     * @param g
     *            Graphics
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        drawTriangles( g, 100, 80, 64 );
    }


    /**
     * Draws an ornament made of triangles in Graphics g with the base midpoint
     * at (x, y) and base half-length r.
     * 
     * @param g
     *            Graphics
     * @param x
     *            Base midpoint x-coordinate
     * @param y
     *            Base midpoint y-coordinate
     * @param r
     *            Base half-length
     */
    public void drawTriangles( Graphics g, int x, int y, int r )
    {
        int xCoord = x;
        int yCoord = y;
        int hLength = r;

        // if r is equal to the half-length of the base of the
        // smallest triangle, we're done
        if ( r == 4 )
        {
            // stop
            return;
        }
        // otherwise draw triangles
        else
        {
            // draw big, outer triangle
            g.drawLine( xCoord, yCoord, xCoord + hLength, yCoord );
            g.drawLine( xCoord, yCoord, xCoord - hLength, yCoord );
            g.drawLine( xCoord, yCoord - hLength, xCoord + hLength, yCoord );
            g.drawLine( xCoord, yCoord - hLength, xCoord - hLength, yCoord );

            // draw first triangle
            g.drawLine( x - r / 2, y - r / 2, x, y );
            g.drawLine( x - r / 2, y - r / 2, x - r, y );

            // draw first triangle
            g.drawLine( x + r / 2, y - r / 2, x, y );
            g.drawLine( x + r / 2, y - r / 2, x + r, y );

            // draw triangle on the right side
            drawTriangles( g, x - r / 2, y, r / 2 );

            // draw triangle on the left side
            drawTriangles( g, x + r / 2, y, r / 2 );
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
        JFrame w = new JFrame( "Triangles" );
        w.setBounds( 300, 300, 200, 120 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ornament panel = new Ornament();
        panel.setBackground( Color.WHITE );
        Container c = w.getContentPane();
        c.add( panel );
        w.setResizable( false );
        w.setVisible( true );
    }
}
