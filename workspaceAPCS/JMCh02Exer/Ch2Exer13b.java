
// Question 2-13-b

import java.awt.*;
import javax.swing.*;


/**
 * This program displays a gray target on a white background.
 *
 * @author Bryan Wu
 * @version Aug 24, 2015
 * @author Period: 3
 * @author Assignment: JMCh02Exer13b
 *
 * @author Sources: None
 */
public class Ch2Exer13b extends JPanel
{

    /**
     * Paints background and target.
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
        g.setColor( Color.GRAY );
        g.fillOval( xCenter, yCenter, 50, 50 );
        g.setColor( Color.WHITE );
        g.fillOval( ( xCenter ) + 10, ( yCenter ) + 10, 30, 30 );
        g.setColor( Color.GRAY );
        g.fillOval( ( xCenter ) + 20, ( yCenter ) + 20, 10, 10 );
    }


    /**
     * Main method.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        JFrame window = new JFrame( "Target" );
        window.setBounds( 300, 300, 200, 200 );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Ch2Exer13b panel = new Ch2Exer13b();
        panel.setBackground( Color.WHITE );
        Container c = window.getContentPane();
        c.add( panel );
        window.setVisible( true );
    }
}
