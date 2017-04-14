import java.util.*;


/**
 * The MailServer class represents a mechanism for queuing and dispatching
 * messages. A MailServer is a queue of messages (MailServer implements Queue
 * <Message>), and it has a method to dispatch a message to the appropriate
 * recipient. A MailServer also keeps a set of all “registered” subscribers.
 *
 * @author Bryan Wu
 * @version Jan 19, 2016
 * @author Period: 3
 * @author Assignment: JMCh21_6ActorsWorld
 *
 * @author Sources: None
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors = new HashSet<Actor>();


    /**
     * This method adds actor to the Set actors
     * 
     * @param actor
     *            actor
     */
    public void signUp( Actor actor )
    {
        actors.add( actor );
    }


    /**
     * Dispatch message to actors.
     * 
     * @param msg
     *            message
     */
    protected void dispatch( Message msg )
    {
        if ( msg.getRecipient() == null )
        {
            // Iterator<Actor> iter = actors.iterator();
            for ( Actor actor : actors )
            {
                actor.receive( msg );
            }
        }
        else
        {
            for ( Actor actor : actors )
            {
                if ( msg.getRecipient().equals( actor ) )
                {
                    actor.receive( msg );
                }
            }
        }

    }


    // for testing purposes only
    /**
     * Returns actors on this MailServer
     * 
     * @return actors
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
