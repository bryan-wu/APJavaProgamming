
/**
 * Question 24-20
 * 
 * Write a hashCode method for this class that agrees with the equals method and
 * returns different values for Persons of different ages.
 *
 * @author Bryan Wu
 * @version 2/26/16
 * @author Period: 3
 * @author Assignment: JMCh24Exercises Question 20
 *
 * @author Sources: None
 */
public class Person
{
    private String name;

    private int age; // age <= 125


    public Person( String name, int age )
    {
        this.name = name;
        this.age = age;
    }


    public boolean equals( Object other )
    {
        if ( !( other instanceof Person ) )
        {
            return false;
        }
        Person otherPerson = (Person)other;
        return name.equals( otherPerson.name ) && age == otherPerson.age;
    }


    public int hashCode()
    {
        return name.hashCode() + age;
    }

}
