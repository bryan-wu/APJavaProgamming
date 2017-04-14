import java.util.*;


/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author Bryan Wu
 * @version 10/9/15
 * 
 * @author Period - 3
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - None
 */
public class JMCh10Exercises
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }


    // 10-2(a)
    /**
     * A method that returns true if a given string is not empty and ends with a
     * star ('*'), false otherwise.
     * 
     * @param s
     *            string to test
     * @return returns true if a given string is not empty and ends with a star
     *         ('*'), false otherwise.
     */
    public boolean endsWithStar( String s )
    {
        return s.length() > 0 && s.charAt( s.length() - 1 ) == '*';
    }


    // 10-2(b)
    /**
     * A method that returns true if a given string has at least two characters
     * and ends with two stars, false otherwise
     * 
     * @param s
     *            string to test
     * @return returns true if a given string has at least two characters and
     *         ends with two stars, false otherwise
     */
    public boolean endsWith2Stars( String s )
    {
        return s.length() >= 2 && s.charAt( s.length() - 1 ) == '*' && s.charAt( s.length() - 2 ) == '*';
    }


    // 10-6
    /**
     * A scroll method that takes a string as a parameter, moves the first
     * character to the end of the string, and returns the new string.
     * 
     * @param s
     *            string to scroll
     * @return string with first character moved to the end
     */
    public String scroll( String s )
    {
        return s.substring( 1 ) + s.charAt( 0 );
    }


    // 10-7
    /**
     * Takes a name string and returns a string where the first name is placed
     * first followed by one space and then the last name.
     * 
     * @param name
     *            holds a person's last name and first name, separated by a
     *            comma
     * @return returns a string where the first name is placed first followed by
     *         one space and then the last name.
     */
    public String convertName( String name )
    {

        return name.substring( name.indexOf( ',' ) + 2 ) + " " + name.substring( 0, name.indexOf( ',' ) );
    }


    // 10-8
    /**
     * A method that takes such a string and makes and returns a “negative”
     * string in which all the 0's are replaced with 1's and all the 1's with
     * 0's
     * 
     * @param str
     *            string contains only '0' and '1' characters and spaces
     * @return str returns a “negative” string in which all the 0's are replaced
     *         with 1's and all the 1's with 0's
     */
    public String negate( String str )
    {
        str = str.replaceAll( "0", "#" );
        str = str.replaceAll( "1", "0" );
        str = str.replaceAll( "#", "1" );

        return str;
    }


    // 10-9
    /**
     * A method that determines whether all the characters in a string are the
     * same, using only library String methods, but no loops or recursion.
     * 
     * @param s
     *            string to test
     * @return whether all the characters in a string are the same, using only
     *         library String methods, but no loops or recursion.
     */
    public boolean isConstant( String s )
    {
        char firstChar = s.charAt( 0 );
        s = s.replaceAll( firstChar + "", "" );

        return s.length() == 0;
    }


    // 10-10s
    /**
     * a method that tries to find opening and closing comment marks.
     * 
     * @param str
     *            string
     * @return str If both are found, the method removes the first opening mark,
     *         the last closing mark, and all the characters between them from
     *         the string and returns the new string. If it fails to find both
     *         marks, the method returns the original string unchanged.
     */
    public String removeComment( String str )
    {
        int firstCommentIndex = str.indexOf( "/*" );
        int secondCommentIndex = str.indexOf( "*/" );
        if ( firstCommentIndex >= 0 && secondCommentIndex >= 0 )
        {
            if ( firstCommentIndex < secondCommentIndex )
            {
                str = str.substring( 0, firstCommentIndex ) + str.substring( secondCommentIndex + 2 );
            }
        }

        return str;
    }


    // 10-11
    /**
     * A method cutOut that removes the first occurrence of a given substring
     * (if found) from a given string.
     * 
     * @param s
     *            string to cut
     * @param s2
     *            what string to cut out of s
     * @return s removes the first occurrence of a given substring (if found)
     *         from a given string and returns
     */
    public String cutOut( String s, String s2 )
    {
        // make string from beginning, to first occurrence of s2, then
        // concatenate a string made from the end of s2 in the string to the end
        // of s
        if ( s.indexOf( s2 ) >= 0 )
        {
            s = s.substring( 0, s.indexOf( s2 ) ) + s.substring( s.indexOf( s2 ) + s2.length() );
        }

        return s;
    }


    // 10-14
    /**
     * A method removeTag that checks whether a given string starts with an
     * apparent HTML tag (a character or word in angle brackets) and ends with a
     * matching closing HTML tag (the same character or word preceded by the "\"
     * character, all in angle brackets).
     * 
     * @param str
     *            string to modify
     * @return str If yes, the method removes both tags and returns the result;
     *         otherwise the method returns the original string unchanged.
     */
    public String removeHtmlTags( String str )
    {
        // indexes of first pair of brackets
        int index1stBracket1 = str.indexOf( "<" );
        int index2ndBracket1 = str.indexOf( ">" );
        char c = str.charAt( str.indexOf( "<" ) + 1 );

        // indexes of second pair of brackets
        int index1stBracket2 = str.indexOf( "<", index1stBracket1 + 1 );
        int index2ndBracket2 = str.indexOf( ">", index2ndBracket1 + 1 );

        if ( index1stBracket1 >= 0 && index2ndBracket1 >= 0 && index1stBracket1 < index2ndBracket1 )
        {
            if ( index1stBracket2 >= 0 && index2ndBracket2 >= 0 && index1stBracket2 < index2ndBracket2 )
            {
                if ( str.charAt( index1stBracket2 + 1 ) == '/' && c == str.charAt( index1stBracket2 + 2 ) )
                {
                    str = str.substring( 0, index1stBracket1 ) + str.substring( index2ndBracket1 + 1, index1stBracket2 )
                        + str.substring( index2ndBracket2 + 1 );
                }
            }
        }

        return str;
    }


    // 10-15
    /**
     * A method that tests whether a given string contains only digits
     * 
     * @param s
     *            string to test for digits
     * @return tests whether a given string contains only digits
     */
    public boolean onlyDigits( String s )
    {
        int digitCount = 0;
        for ( int i = 0; i < s.length(); i++ )
        {
            if ( Character.isDigit( s.charAt( i ) ) )
            {
                digitCount++;
            }
        }

        return digitCount == s.length();
    }


    // 10-20
    /**
     * This method tests for a valid ISBN.
     * 
     * @param isbn
     *            ISBN string
     * @return returns true if isbn represents a valid ISBN, false otherwise.
     */
    public static boolean isValidISBN( String isbn )
    {
        int sum = 0;
        int num;
        String str;

        if ( isbn.length() != 10 )
        {
            return false;
        }

        for ( int i = 10; i > 0; i-- )
        {
            str = isbn.substring( 10 - i, 10 - i + 1 );

            // unless the character is X or x, the string will be considered an
            // invalid ISBN if the character cannot be parsed as an integer
            if ( str.equals( "X" ) || str.equals( "x" ) )
            {
                num = 10;
            }
            else
            {
                try
                {
                    num = Integer.parseInt( str );
                }
                catch ( NumberFormatException e )
                {
                    return false;
                }
            }
            sum += i * num;
        }

        return ( sum % 11 == 0 );
    }


    // 10-22
    /**
     * This method wills first create a temporary StringBuffer object from abc,
     * then shuffle the characters in that string buffer, then convert the
     * string buffer back into a string and return the result.
     * 
     * @param s
     * @return returns a new string with all the characters from abc rearranged
     *         in random order.
     */
    public String shuffle( String s )
    {
        StringBuffer str = new StringBuffer( s );

        int n = str.length();
        int randIndex;
        char randChar;
        char temp;
        str.ensureCapacity( 1 );

        while ( n > 1 )
        {
            randIndex = (int)( Math.floor( Math.random() * str.length() ) );
            System.out.println( randIndex );
            randChar = str.charAt( randIndex );
            temp = str.charAt( n - 1 );
            str.deleteCharAt( n - 1 );
            str.insert( n - 1, randChar );
            str.deleteCharAt( randIndex );
            str.insert( temp, randIndex );
            n--;
        }

        return str.toString();
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {
        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println( "endsWithStar(" + end1Star + ") = " + exercise.endsWithStar( end1Star ) );
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println( "endsWithStar(" + ends0Star + ") = " + exercise.endsWithStar( ends0Star ) );
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println( "endsWith2Stars(" + end2Str + ") = " + exercise.endsWith2Stars( end2Str ) );
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println(
                            "endsWith2Stars(" + endsWith1Star + ") = " + exercise.endsWith2Stars( endsWith1Star ) );
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out.println(
                            "scroll(\"" + scrollStr + "\") --> " + "\"" + exercise.scroll( scrollStr ) + "\"" );
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println(
                            "convertName(\"" + convStr + "\") --> " + "\"" + exercise.convertName( convStr ) + "\"" );
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out
                            .println( "negate(\"" + negStr + "\") --> " + "\"" + exercise.negate( negStr ) + "\"" );
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println( "isConstant(\"" + constStr1 + "\") = " + exercise.isConstant( constStr1 ) );
                        System.out.println( "isConstant(\"" + constStr2 + "\") = " + exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println( "removeComment(\"" + comment + "\") --> " + "\""
                            + exercise.removeComment( comment ) + "\"" );
                        System.out.println( "removeComment(\"" + notComment + "\") --> " + "\""
                            + exercise.removeComment( notComment ) + "\"" );
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println( "cutOut(\"" + cutstr + "\", \"" + cutOutstr + "\") --> " + "\""
                            + exercise.cutOut( cutstr, cutOutstr ) + "\"" );
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println( "removeHtmlTags(\"" + htmlStr + "\") --> " + "\""
                            + exercise.removeHtmlTags( htmlStr ) + "\"" );
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println( "onlyDigits(\"" + digitStr + "\") = " + exercise.onlyDigits( digitStr ) );
                        System.out.println( "onlyDigits(\"" + dStr + "\") = " + exercise.onlyDigits( dStr ) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out
                            .println( "isValidISBN(\"" + validISBN + "\") = " + exercise.isValidISBN( validISBN ) );
                        System.out
                            .println( "isValidISBN(\"" + invalidISBN + "\") = " + exercise.isValidISBN( invalidISBN ) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println( "shuffle(\"" + str + "\") --> " + "\"" + exercise.shuffle( str ) + "\"" );
                        System.out.println( "shuffle(\"" + str + "\") --> " + "\"" + exercise.shuffle( str ) + "\"" );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
