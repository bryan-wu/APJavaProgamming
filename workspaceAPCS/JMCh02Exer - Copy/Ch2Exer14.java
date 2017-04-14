import java.awt.*;
import javax.swing.*;


/**
 * This applet shows a string of text inside a box.
 *
 * @author Bryan Wu
 * @version Aug 24, 2015
 * @author Period: 3
 * @author Assignment: JMCh02Exer14
 *
 * @author Sources: None
 */
public class Ch2Exer14 extends JApplet
{
    /**
     * This method initializes the Container c and sets the background.
     */
    public void init()
    {
        Container c = getContentPane();
        c.setBackground( Color.WHITE );
    }


    /**
     * This method creates a box and string.
     * 
     * @param g
     *            Graphics
     */
    public void paint( Graphics g )
    {
        super.paint( g ); // call JApplet's paint method
                          // to paint the background
        g.setColor( Color.BLUE );
        g.fillRect( 25, 40, 150, 45 ); // draw a rectangle 150 by 45
        g.setColor( Color.WHITE );
        g.drawString( "Hello, Applet!", 60, 65 );
    }
}
