import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Scanner;
import javax.swing.*;


/**
 * This is a class that tests the PollDisplayPanel class.
 *
 * @author Bryan Wu
 * @version 9/3/15
 * @author Period: 3
 * @author Assignment: JMCh06_10PieChart
 *
 * @author Sources: None
 */
public class PollTest
{
    /**
     * The main method in this class checks the PollDisplayPanel operations for
     * consistency.
     * 
     * @param args
     */
    public static void main( String[] args )
    {
        PollDisplayPanel votingMachine = new 
                        PollDisplayPanel( "Tami", "Brian", "Liz" );
        votingMachine.vote1();
        votingMachine.vote2();
        votingMachine.vote2();
        System.out.println( votingMachine );
    }
}
