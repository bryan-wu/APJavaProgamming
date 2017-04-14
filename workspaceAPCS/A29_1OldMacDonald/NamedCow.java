/**
 * NamedCow extends the Cow class, adding a constructor, a field for the Cow's
 * name, and a new method: getName.
 *
 * @author Bryan Wu
 * @version Oct 22, 2015
 * @author Period: 3
 * @author Assignment: A29_1OldMacDonald
 *
 * @author Sources: None
 */
class NamedCow extends Cow
{
    private String myName;


    /**
     * @param type
     *            type
     * @param name
     *            name
     * @param sound
     *            sound
     */
    public NamedCow( String type, String name, String sound )
    {
        super( type, sound );
        myName = name;
    }


    /**
     * This method returns the name of the cow.
     * 
     * @return myName name of cows
     */
    public String getName()
    {
        return myName;
    }
}
