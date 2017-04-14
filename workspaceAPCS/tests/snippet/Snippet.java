package snippet;

import java.util.ArrayList;

public class Snippet
{
    public static void main( String[] args )
    {
        
    }
    
    public ArrayList<String> getNames()
    {
        ArrayList<String> list = null;
        String name = "";
        while (!name.equals( "quit" ))
        {
            list.add( name );
        }
        return list;
    }
}

