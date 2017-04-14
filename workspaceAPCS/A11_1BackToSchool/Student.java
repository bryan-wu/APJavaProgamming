/**
 * Student Class.
 *
 * @author Bryan Wu
 * @version Oct 10, 2015
 * @author Period: 3
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class Student extends Person
{
    private String myIdNum; // Student Id Number

    private double myGPA; // grade point average


    /**
     * Student Class Constructor.
     * 
     * @param name
     *            name
     * @param age
     *            age
     * @param gender
     *            gender
     * @param idNum
     *            id number
     * @param gpa
     *            GPA
     */
    public Student( String name, int age, String gender, String idNum, 
        double gpa )
    {
        // use the super class' constructor
        super( name, age, gender );

        // initialize what's new to Student
        myIdNum = idNum;
        myGPA = gpa;
    }


    /**
     * This method returns id number.
     * 
     * @return myIdNum id number
     */
    public String getIdNum()
    {
        return myIdNum;
    }


    /**
     * This method returns GPA.
     * 
     * @return myGPA GPA
     */
    public double getGPA()
    {
        return myGPA;
    }


    /**
     * This method set myIdNum to idNum.
     * 
     * @param idNum
     *            id number
     */
    public void setIdNum( String idNum )
    {
        myIdNum = idNum;
    }


    /**
     * This method sets myGpa to gpa.
     * 
     * @param gpa
     *            GPA
     */
    public void setGPA( double gpa )
    {
        myGPA = gpa;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", student id: " + myIdNum + 
                        ", gpa: " + myGPA;
    }
}
