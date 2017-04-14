/**
 * Calculates the area and the perimeter of an equilateral triangle as specified
 * by the abstract Triangle superclass.
 * 
 * @author Bryan Wu
 * @version 10/15/15
 * 
 * @author 3
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - None
 */
public class EquilateralTriangle extends AbstractTriangle
{

    /**
     * EquilateralTriangle constructor.
     */
    public EquilateralTriangle()
    {
        super();
    }


    /**
     * EquilateralTriangle constructor.
     * 
     * @param sideLength
     *            length of triangle
     */
    public EquilateralTriangle( double sideLength )
    {
        super( sideLength );
    }


    /**
     * Calculates and returns the perimeter of this EquilateralTriangle.
     * 
     * @return the perimeter of this Triangle
     */
    public double getPerimeter()
    {
        return 3 * getSide();
    }


    /**
     * Calculates and returns the area of this EquilateralTriangle.
     * 
     * @return the area of this Triangle
     */
    public double getArea()
    {
        return Math.sqrt( 3 ) / 4 * getSide() * getSide();
    }
}
