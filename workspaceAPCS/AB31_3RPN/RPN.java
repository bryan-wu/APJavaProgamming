import java.util.*;


/**
 * RPN Calculator
 *
 * @author Bryan Wu
 * @version 1/12/16
 * @author Period: 3
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: None
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * Calculate the result of the given math problem.
     */
    public void calculate()
    {
        String input = scan.nextLine().trim();
        String result = "";
        while ( !input.equalsIgnoreCase( "q" ) && input.length() > 0 )
        {
            // System.out.println( input );
            result += input + " ";
            myQ.add( input );

            input = scan.nextLine().trim();
        }
        read();
        result += "= " + myStack.peek();
        System.out.println( result );
    }


    /**
     * Reads myQueue into myStack and calls to perform math operations if an
     * operator is given.
     */
    public void read()
    {
        int queueElementCount = myQ.size();
        int num = 0;
        String str;
        while ( queueElementCount > 0 )
        {
            str = myQ.peek();
            try
            {
                num = Integer.parseInt( str );
                myStack.push( num );
            }
            catch ( NumberFormatException e )
            {
                if ( str.equals( "+" ) || str.equals( "-" ) || str.equals( "*" ) || str.equals( "/" ) )
                {
                    mathOps( str );
                }
            }
            myQ.remove();
            queueElementCount--;
        }
    }


    /**
     * This method decides what operation to perform depending on the operator
     * provided.
     * 
     * @param op
     *            Operation
     */
    public void mathOps( String op )
    {
        int num1; // newer num
        int num2; // older num
        int result = 0;
        System.out.println( myQ.peek() );
        num1 = myStack.peek();
        myStack.pop();
        num2 = myStack.peek();
        myStack.pop();
        if ( op.equals( "+" ) )
        {
            result = num2 + num1;
        }
        if ( op.equals( "-" ) )
        {
            result = num2 - num1;
        }
        if ( op.equals( "*" ) )
        {
            result = num2 * num1;
        }
        if ( op.equals( "/" ) )
        {
            result = num2 / num1;
        }
        myStack.push( result );
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();
        rpn.calculate();
    }
}