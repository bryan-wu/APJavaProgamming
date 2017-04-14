/**
 * Implements the minimum requirements specified by the Animal interface.
 *
 * @author Bryan Wu
 * @version Oct 22, 2015
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: Nones
 */
class Pig implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Initializes a newly created Pig object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Pig
     * @param sound
     *            the sound the Pig makes
     */
    public Pig( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * Returns the sound of this Animal
     * 
     * @return A string representation of the sound this Animal makes
     */
    public String getSound()
    {
        return mySound;
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