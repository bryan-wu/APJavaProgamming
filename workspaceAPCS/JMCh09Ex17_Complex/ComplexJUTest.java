import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author Bryan Wu
 * @version 10/1/15
 * @author Period: 3
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: None
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    private Complex test1;

    private Complex test2;


    @Test
    public void testConstructor1Param()
    {
        test1 = new Complex( 3.0 );
        test2 = new Complex( 6.0 );
    }


    @Test
    public void testConstructor2Param()
    {
        test1 = new Complex( 3.0, 4.0 );
        test2 = new Complex( 6.0, 7.0 );
    }


    @Test
    public void testAddRealAndComplexNum()
    {
        assertEquals( "9.0 + 4.0i", test1.add( 6 ).toString() );
    }


    @Test
    public void testAdd2ComplexNums()
    {
        assertEquals( "9.0 + 11.0i", test1.add( test2 ).toString() );
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        assertEquals( "-10.0 + 45.0i", test1.multiply( test2 ).toString() );
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        assertEquals( "18.0 + 24.0i", test1.multiply( 6 ).toString() );
    }


    @Test
    public void testAbsoluteValue()
    {
        assertEquals( Math.sqrt( 3 * 3 + 4 * 4 ), test1.abs(), 0.1 );
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
