/**
 * The class <code>TriangleStarter</code> has methods for calculating the
 * area,the perimeter, and their ratio. The class works for equilateral
 * triangles and for right isosceles traingles; the type of the triangle is
 * passed in a string to the constructor. the class also has a main method for
 * test purposes.
 * 
 * @author George Peck
 * @version Oct 19, 2007
 * 
 * @author Sources - Maria & Gary Litvin
 */
public class Triangle
{
    private String type;

    private double side;


    /**
     * Triangle constructor.
     * 
     * @param triangleType
     *            a string describing type of Triangle. Acceptable types are
     *            "equilateral" and "right"
     * @param sideLength
     *            value of length of side
     */
    public Triangle( String triangleType, double sideLength )
    {
        type = triangleType;
        side = sideLength;
    }


    /**
     * Calculates and returns the perimeter of this Triangle depending on the
     * triangle type.
     * 
     * @return the perimeter of this Triangle
     * @throws IllegalArgumentException
     *             if triangle type is invalid
     */
    public double getPerimeter()
    {
        if ( "equilateral".equals( type ) )
        {
            return 3 * side;
        }
        else if ( "right".equals( type ) )
        {
            return ( 2 + Math.sqrt( 2.0 ) ) * side;
        }
        else
        {
            throw new IllegalArgumentException( "Invalid triangle type" );
        }
    }


    /**
     * Calculates and returns the area of this Triangle depending on the
     * triangle type.
     * 
     * @return the area of this Triangle
     * @throws IllegalArgumentException
     *             if triangle type is invalid
     */
    public double getArea()
    {
        if ( "equilateral".equals( type ) )
        {
            return Math.sqrt( 3 ) / 4 * side * side;
        }
        else if ( "right".equals( type ) )
        {
            return side * side / 2;
        }
        else
        {
            throw new IllegalArgumentException( "Invalid triangle type" );
        }
    }


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
     * Test method for the TriangleStarter class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Triangle equilateralTr = new Triangle( "equilateral", 12 );
        Triangle rightTr = new Triangle( "right", 12 );
        System.out.println( "Equilateral " + equilateralTr.getRatio() );
        System.out.println( "Right isosceles " + rightTr.getRatio() );
    }
}
