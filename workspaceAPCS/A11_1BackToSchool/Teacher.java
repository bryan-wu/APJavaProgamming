/**
 * A Teacher class that extends the parent class Person.
 *
 * @author Bryan Wu
 * @version Oct 10, 2015
 * @author Period: 3
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class Teacher extends Person
{
    /**
     * Subject
     */
    private String mySubject;

    /**
     * Salary
     */
    private double mySalary;


    /**
     * @param myName
     *            name
     * @param myAge
     *            age
     * @param myGender
     *            gender
     * @param subject
     *            subject
     * @param salary
     *            salary
     */
    public Teacher( String myName, int myAge, String myGender, String subject,
        double salary )
    {
        super( myName, myAge, myGender );
        mySubject = subject;
        mySalary = salary;

    }


    /**
     * Get subject.
     * 
     * @return subject
     */
    public String getSubject()
    {
        return mySubject;
    }


    /**
     * Get salary.
     * 
     * @return salary
     */
    public double getSalary()
    {
        return mySalary;
    }


    /**
     * Set subject.
     * 
     * @param sbjt
     *            subject
     */
    public void setSubject( String sbjt )
    {
        mySubject = sbjt;
    }


    /**
     * Set salary.
     * 
     * @param sal
     *            salary
     */
    public void setSalary( double sal )
    {
        mySalary = sal;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + 
                        ", salary: " + mySalary;
    }
}
