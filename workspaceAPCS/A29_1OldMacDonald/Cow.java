/**
 * Implements the minimum requirements specified by the Animal interface
 * 
 * @author George Peck
 * @version June 22, 2003
 * 
 *          Period - 1-7 Assignment - A29.1 - Old MacDonald
 * 
 *          Sources - Roger Frank
 */
public class Cow implements Animal
{
    private String myType;

    private String mySound;


    /**
     * Cow constructor.
     */
    public Cow()
    {
        this( "", "" );
    }


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public Cow( String type, String sound )
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
