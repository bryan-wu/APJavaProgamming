import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.AudioClip;


/**
 * When the user presses the "Next" button, the applet displays a message
 * randomly chosen from an array of messages. The applet is implemented in one
 * class, FortuneTeller.
 * 
 * @author Bryan Wu
 * @version 10/20/15
 * 
 * @author Period - 3
 * @author Assignment - Lab 12.3: Fortune Teller
 * 
 * @author Sources - None
 */
@SuppressWarnings("serial")
public class FortuneTeller extends JApplet implements ActionListener
{
    // Declare an array of "fortunes" (strings):
    String[] fortunes = { "Length in arrays is not a method.", "Forever Trump.", "Strike iron while it's hot.",
        "You will give the creator a 100% on this lab." };

    private JTextField display;

    private AudioClip ding;


    /**
     * Initialization method.
     */
    public void init()
    {
        ding = getAudioClip( getDocumentBase(), "ding.wav" );

        display = new JTextField( "  Press \"Next\" to see your fortune...", 30 );
        display.setBackground( Color.WHITE );
        display.setEditable( false );

        JButton go = new JButton( "Next" );
        go.addActionListener( this );

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        c.add( display );
        c.add( go );
    }


    /**
     * ActionPerformed method.
     * 
     * @param e
     *            ActionEvent
     */
    public void actionPerformed( ActionEvent e )
    {
        // Pick a random fortune:
        String fortune = fortunes[(int)( Math.random() * 4 )];
        ding.play();

        display.setText( fortune );
    }
}
