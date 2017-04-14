/**
 * A CollegeStudent subclass that extends the Student class.
 *
 * @author Bryan Wu
 * @version Oct 10, 2015
 * @author Period: 3
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class CollegeStudent extends Student
{
    /**
     * Major
     */
    private String myMajor;

    /**
     * Year
     */
    private int myYear;


    /**
     * @param myName
     *            name
     * @param myAge
     *            age
     * @param myGender
     *            gender
     * @param myIdNum
     *            idNumber
     * @param myGPA
     *            GPA
     * @param year
     *            year
     * @param major
     *            major
     */
    public CollegeStudent(
        String myName,
        int myAge,
        String myGender,
        String myIdNum,
        double myGPA,
        int year,
        String major )
    {
        super( myName, myAge, myGender, myIdNum, myGPA );
        myYear = year;
        myMajor = major;
    }


    // myName, myAge, myGender, myIdNum, myGPA, year, and major.

    /**
     * Get year.
     * 
     * @return year
     */
    public int getYear()
    {
        return myYear;
    }


    /**
     * Get major.
     * 
     * @return major
     */
    public String getMajor()
    {
        return myMajor;
    }


    /**
     * Set year.
     * 
     * @param yr
     *            year
     */
    public void setYear( int yr )
    {
        myYear = yr;
    }


    /**
     * Set major.
     * 
     * @param maj
     *            major
     */
    public void setMajor( String maj )
    {
        myMajor = maj;
    }


    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
