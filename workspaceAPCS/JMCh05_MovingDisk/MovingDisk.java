import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This program uses JPanel to represent a spinning disk moving in an arc path.
 * The background turns Cyan when the Disk is visible and turns Black when the
 * Disk isn't visible.
 *
 * @author Bryan Wu
 * @version Aug 31, 2015
 * @author Period: 3
 * @author Assignment: JMCh05_MovingDisk
 *
 * @author Sources: None
 */
public class MovingDisk extends JPanel implements ActionListener
{
    /**
     * Time value.
     */
    private int time;


    /**
     * MovingDisk Constructor.
     */
    public MovingDisk()
    {
        time = 0;
        Timer clock = new Timer( 30, this );
        clock.start();
    }


    /**
     * This creates the disk and the path that the disk will follow. This also
     * changes the background color.
     * 
     * @param g
     *            Graphics
     */
    public void paintComponent( Graphics g )
    {
        int x = 150 - (int)( 100 * Math.cos( 0.005 * Math.PI * time ) );
        int y = 130 - (int)( 75 * Math.sin( 0.005 * Math.PI * time ) );
        int r = 20;

        Color sky;
        if ( y > 130 )
        {
            sky = Color.BLACK;
        }
        else
        {
            sky = Color.CYAN;
        }
        setBackground( sky );
        super.paintComponent( g );

        g.setColor( Color.ORANGE );
        g.fillOval( x - r, y - r, 2 * r, 2 * r );
    }


    /**
     * This is animates the drawing by updating frames.
     * 
     * @param e
     *            ActionEvent
     */
    public void actionPerformed( ActionEvent e )
    {
        time++;
        repaint();
    }


    /**
     * This is the main method. It creates a sample MovingDisk to run.
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        JFrame w = new JFrame( "Moving Disk" );
        w.setSize( 300, 150 );
        w.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        Container c = w.getContentPane();
        c.add( new MovingDisk() );
        w.setResizable( false );
        w.setVisible( true );
    }

}
