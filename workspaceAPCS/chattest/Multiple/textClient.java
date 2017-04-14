package Multiple;

import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

public class textClient
{

    private static Socket socket;

    private static PrintWriter printWriter;
    static String sendMe;
    public static void main( String[] args )
    {
        System.out.println( "hello this is the button client" );
        try
        {
            socket = new Socket( "172.18.240.180", 30480 );
            printWriter = new PrintWriter( socket.getOutputStream(), true );
        }
        catch ( Exception e )
        {
            System.out.println( "did i get here?" );
            System.out.println( e );
        }
        while ( true )
        {
            Scanner scanIn = new Scanner(System.in);
            sendMe = scanIn.nextLine();
            if (sendMe != null)
            printWriter.println( sendMe );
        }
        
    }

}