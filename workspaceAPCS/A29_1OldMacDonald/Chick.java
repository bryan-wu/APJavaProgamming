/**
 * Implements the minimum requirements specified by the Animal interface.
 *
 * @author Bryan Wu
 * @version Oct 20, 2015
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
class Chick implements Animal
{
    private String myType;

    private String mySound1;

    private String mySound2;


    /**
     * Constructor of a Chick object so that it represents an Animal of the
     * specified type that can make one of two specified sounds.
     * 
     * @param type
     *            type
     * @param sound1
     *            sound
     * @param sound2
     *            sound2
     */
    public Chick( String type, String sound1, String sound2 )
    {
        myType = type;
        mySound1 = sound1;
        mySound2 = sound2;
    }


    /**
     * Constructor of a Chick object so that it represents an Animal of the
     * specified type that makes the specified sounds.
     * 
     * @param type
     *            the type of Chick
     * @param sound
     *            the sound the Chick makes
     */
    public Chick( String type, String sound )
    {
        this( type, sound, "" );
    }


    /**
     * Returns the sound of this Animal
     * 
     * @return A string representation of the sound this Animal makes
     */
    public String getSound()
    {
        double randNum = Math.random();
        if ( mySound2.length() == 0 || randNum >= 0.5 )
        {
            return mySound1;
        }
        else
        {
            return mySound2;
        }
    }


    /**
     * Returns the type of this Animal
     * 
     * @return A string representation of this Animal's type
     */
    public String getType()
    {
        return myType;
    }
}