import java.util.*;


/**
 * A complete farm to test all your animals.
 *
 * @author Bryan Wu
 * @version Oct 22, 2015
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
public class Farm
{
    private Animal[] a = new Animal[3];


    /**
     * Farm constructor.
     */
    public Farm()
    {
        // a[0] = new Cow( "cow", "moo moo" );
        a[0] = new NamedCow( "cow", "Elsie", "moo" );
        // a[1] = new Chick( "chick", "cluck cluck" );
        a[1] = new Chick( "chick", "cluckity cluck", "cheep" );
        a[2] = new Pig( "pig", "oink oink" );
    }


    /**
     * This method tests the getType() and getSound() methods of each animal.
     */
    public void animalSounds()
    {
        for ( int i = 0; i < a.length; i++ )
        {
            System.out.println( a[i].getType() + " goes " + a[i].getSound() );
        }
        // NamedCow named = (NamedCow)a[0];
        // System.out.println( named.getType() + " is named " + named.getName()
        // );
    }
}
