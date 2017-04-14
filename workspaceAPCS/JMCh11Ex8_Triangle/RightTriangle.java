/**
 * Calculates the area and the perimeter of a right triangle as specified by the
 * abstract Triangle superclass.
 * 
 * @author Bryan Wu
 * @version 10/15/15
 * 
 * @author 3
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - None
 */
public class RightTriangle extends AbstractTriangle
{
    /**
     * RightTriangle constructor.
     */
    public RightTriangle()
    {
        super();
    }


    /**
     * RightTriangle constructor.
     * 
     * @param sideLength
     *            length of side
     */
    public RightTriangle( double sideLength )
    {
        super( sideLength );
    }


    /**
     * Calculates and returns the perimeter of this RightTriangle.
     * 
     * @return perimeter
     */
    public double getPerimeter()
    {
        return ( 2 + Math.sqrt( 2.0 ) ) * getSide();
    }


    /**
     * Calculates and returns the area of this RightTriangle.
     * 
     * @return area
     */
    public double getArea()
    {
        return getSide() * getSide() / 2;
    }
}
