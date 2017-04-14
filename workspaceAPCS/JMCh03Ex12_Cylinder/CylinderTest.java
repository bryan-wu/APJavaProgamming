import java.util.Scanner;


/**
 * This is a class that tests the Cylinder class.
 *
 * @author Bryan Wu
 * @version 8/26/15
 * @author Period: 3
 * @author Assignment: JMCh03Ex12_Cylinder
 *
 * @author Sources: None
 */
public class CylinderTest
{
    /**
     * The main method in this class checks the Cylinder operations for
     * consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        Scanner kb = new Scanner( System.in );

        System.out.print( "Enter the radius and the height: " );
        double r = kb.nextDouble();
        double h = kb.nextDouble();

        Cylinder cyl = new Cylinder( r, h );
        double volume = cyl.getVolume();
        System.out.println( "radius = " + r + " height = " + h + 
            " volume = " + volume );
    }
}
