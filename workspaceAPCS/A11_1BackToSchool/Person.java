/**
 * Person class.
 *
 * @author Bryan Wu
 * @version Oct 10, 2015
 * @author Period: 3
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class Person
{
    private String myName; // name of the person

    private int myAge; // person's age

    private String myGender; // 'M' for male, 'F' for female


    /**
     * Person class constructor.
     * 
     * @param name
     *            name
     * @param age
     *            age
     * @param gender
     *            gender
     */
    public Person( String name, int age, String gender )
    {
        myName = name;
        myAge = age;
        myGender = gender;
    }


    /**
     * Name getter method.
     * 
     * @return myName name
     */
    public String getName()
    {
        return myName;
    }


    /**
     * Age getter method.
     * 
     * @return myAge age
     */
    public int getAge()
    {
        return myAge;
    }


    /**
     * Gender getter method.
     * 
     * @return myGender gender
     */
    public String getGender()
    {
        return myGender;
    }


    /**
     * This method sets myName to name.
     * 
     * @param name
     *            name
     */
    public void setName( String name )
    {
        myName = name;
    }


    /**
     * This method sets myAge to age;
     * 
     * @param age
     *            age
     */
    public void setAge( int age )
    {
        myAge = age;
    }


    /**
     * This method sets myGender to gender.
     * 
     * @param gender
     *            gender
     */
    public void setGender( String gender )
    {
        myGender = gender;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return myName + ", age: " + myAge + ", gender: " + myGender;
    }
}