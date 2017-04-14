/**
 * The abstract class <code>Triangle</code> requires methods for calculating the
 * area and the perimeter as specified the type of triangle. A method to
 * calculate the ratio of the area to the perimeter is provided. The class works
 * for equilateral triangles and for right isosceles triangles; which can be
 * specified with the length of a side.
 * 
 * @author Bryan Wu
 * @version 10/15/15
 * 
 * @author 3
 * @author Assignment - Java Methods Chapter 11, Exercise #8 - Triangle
 * 
 * @author Sources - None
 */
public abstract class AbstractTriangle
{
    private double side;


    /**
     * Triangle constructor.
     */
    public AbstractTriangle()
    {
        side = 0;
    }


    /**
     * Triangle constructor.
     * 
     * @param sideLength
     *            length of side
     */
    public AbstractTriangle( double sideLength )
    {
        side = sideLength;
    }


    /**
     * Calculates and returns the perimeter of this Triangle depending on the
     * triangle type.
     * 
     * @return the perimeter of this Triangle
     */
    public abstract double getPerimeter();


    /**
     * Calculates and returns the area of this Triangle depending on the
     * triangle type.
     * 
     * @return the area of this Triangle
     */
    public abstract double getArea();


    /**
     * Calculates and returns the ratio of the area to the perimeter of this
     * Triangle.
     * 
     * @return the ratio of the area to the perimeter of this Triangle
     */
    public double getRatio()
    {
        return getArea() / getPerimeter();
    }


    /**
     * This method returns the side length of a triangle.
     * 
     * @return side length of side
     */
    public double getSide()
    {
        return side;
    }

}
