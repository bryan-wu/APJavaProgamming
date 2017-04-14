
// Question 2-13-a

import java.awt.*;
import javax.swing.*;


/**
 * This program displays a red cross on a white background.
 *
 * @author Bryan Wu
 * @version Aug 24, 2015
 * @author Period: 3
 * @author Assignment: JMCh02Exer13a
 *
 * @author Sources: None
 */
public class Ch2Exer13a extends JPanel
{
    /**
     * Paint the background and rectangles
     * 
     * @param g
     *            Graphics
     */
    public void paintComponent( Graphics g )
    {
        super.paintComponent( g ); // Call JPanel's paintComponent method
                                   // to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        g.setColor( Color.RED );

        // make rectangle start at 1/4 of height and length with double the
        // dimensions
        g.fillRect( xCenter, yCenter / 2, 10, 100 );
        g.fillRect( xCenter / 2, yCenter, 100, 10 );
    }


    /**
     * Main method.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        JFrame window = new JFrame( "Red Cross" );
        window.setBounds( 300, 300, 200, 200 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ch2Exer13a panel = new Ch2Exer13a();
        panel.setBackground( Color.WHITE );
        Container c = window.getContentPane();
        c.add( panel );
        window.setVisible( true );
    }
}
