import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This applet displays a solid black box moving horizontally from right to left
 * across the screen.
 *
 * @author Bryan Wu
 * @version Aug 24, 2015
 * @author Period: 3
 * @author Assignment: JMCh02Exer15
 *
 * @author Sources: None
 */
public class Ch2Exer15 extends JApplet implements ActionListener
{
    private int xPos, yPos; // hold the coordinates of the banner


    /**
     * Initialization method.
     */
    public void init()
    {
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        xPos = c.getWidth();
        yPos = c.getHeight() / 2;
        Timer clock = new Timer( 300, this ); // fires every 30 milliseconds
        clock.start();
    }


    /**
     * This method is called automatically after a repaint request. It draws a
     * black box.
     * 
     * @param g
     *            Graphics
     */
    public void paint( Graphics g )
    {
        super.paint( g );
        g.setColor( Color.BLACK );
        g.fillRect( xPos, yPos, 30, 30 );
    }


    /**
     * This method is called automatically when the timer fires. It "animates"
     * the black box by repositioning the string from right to left.
     * 
     * @param e
     *            ActionEvent
     */
    public void actionPerformed( ActionEvent e )
    {
        Container c = getContentPane();

        // Adjust the horizontal position of the banner:
        xPos -= 10;
        if ( xPos < -40 )
        {
            xPos = c.getWidth();
        }

        // Set the vertical position of the banner:
        yPos = c.getHeight() / 2;

        repaint();
    }
}
