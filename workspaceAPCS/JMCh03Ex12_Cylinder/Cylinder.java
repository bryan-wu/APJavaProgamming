/**
 * This program is extends the Circle class to a Cylinder.
 *
 * @author Bryan Wu
 * @version 8/26/15
 * @author Period: 3
 * @author Assignment: JMCh03Ex12_Cylinder
 *
 * @author Sources: None
 */
public class Cylinder extends Circle
{
    // data fields
    Circle base;

    double height;


    // constructor
    /**
     * Cylinder constructor.
     * 
     * @param r
     *            radius
     * @param h
     *            height
     */
    public Cylinder( double r, double h )
    {
        super( r );
        base = new Circle( r );
        height = h;
    }


    // methods
    /**
     * This method returns the volume of the Cylinder.
     * 
     * @return volume
     */
    public double getVolume()
    {
        return base.getArea() * height;
    }
}
