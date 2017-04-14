import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This is an applet that emulates a banner ad scrolling from right to left: it
 * displays a message alternating “East or West” and “Java is Best” every 2
 * seconds.
 *
 * @author Bryan Wu
 * @version Aug 24, 2015
 * @author Period: 3
 * @author Assignment: JMCh02Exer16
 *
 * @author Sources: None
 */
public class Ch2Exer16 extends JApplet implements ActionListener
{
    private int xPos, yPos; // hold the coordinates of the banner

    private int msgID = 1;


    /**
     * Initialization method.
     */
    public void init()
    {
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
        xPos = c.getWidth() / 2 - 30;
        yPos = c.getHeight() / 2;
        Timer clock = new Timer( 2000, this ); // fires every 2 seconds
        clock.start();

    }


    /**
     * This method is called automatically after a repaint request. It creates
     * "East or West" and "Java is Best" strings.
     * 
     * @param g
     *            Graphics
     */
    public void paint( Graphics g )
    {
        super.paint( g );

        g.setColor( Color.BLACK );

        if ( msgID == 1 )
        {
            g.drawString( "East or West", xPos, yPos );
        }
        else // if msgID == -1
        {
            g.drawString( "Java is Best", xPos, yPos );
        }
    }


    /**
     * This method is called automatically when the timer fires. It "animates"
     * the string by repositioning the string from right to left.
     * 
     * @param e
     *            ActionEvent
     */
    public void actionPerformed( ActionEvent e )
    {
        Container c = getContentPane();

        // Adjust the horizontal position of the banner:
        xPos -= 20;
        if ( xPos < -40 )
        {
            xPos = c.getWidth();
        }

        // Set the vertical position of the banner:
        yPos = c.getHeight() / 2;

        msgID = -msgID;

        repaint();
    }
}
