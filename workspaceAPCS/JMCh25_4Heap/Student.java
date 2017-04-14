/**
 * Student.java
 * 
 * Stores the following information about students grade name (first and last)
 * Lynbrook id
 * 
 */
public class Student implements Comparable
{
    private String lynbrookId;

    private String firstName;

    private String lastName;

    private int grade;


    public Student( String id, String fName, String lName, int g )
    {
        lynbrookId = id;
        firstName = fName;
        lastName = lName;
        grade = g;
    }


    public Student()
    {
        this( "", "", "", 0 );
    }


    public int getGrade()
    {
        return grade;
    }


    public String getId()
    {
        return lynbrookId;
    }


    /**
     * First compare the grade of each student, and if the grades are equal then
     * compare Lynbrook id's and sort the students in increasing order by their
     * Lynbrook id. Since Lynbrook id's are unique you will not have to sort by
     * the first and last name fields.
     * 
     * @param obj
     *            object
     * @return Positive number if this student has better grades. Negative
     *         number if this student has lower grades. If grades are equal,
     *         returns positive if this student has greater student id--negative
     *         if student has smaller student id
     * 
     */
    public int compareTo( Object obj )
    {
        // String params[] = obj.toString().split( "\\s+" );
        // String otherLynbrookId = "";
        // int otherGrade = 0;
        //
        // for ( String str : params )
        // {
        // if ( str.length() == 7 )
        // {
        // otherLynbrookId = str;
        // }
        // if ( str.length() == 1 && str.matches( "^-?\\d+$" ) )
        // {
        // grade = Integer.parseInt( str );
        // }
        // }
        //
        // if ( grade > otherGrade )
        // {
        // return 1;
        // }
        // if ( grade == otherGrade )
        // {
        // return lynbrookId.compareToIgnoreCase( otherLynbrookId );
        // }
        // if ( grade < otherGrade )
        // {
        // return -1;
        // }
        //
        // return 0;
        Student other = (Student)obj;
        if ( grade - other.getGrade() == 0 )
        {
            return lynbrookId.compareTo( other.getId() );
        }
        return grade - other.getGrade();
    }


    public Object clone()
    {
        return new Student( lynbrookId, firstName, lastName, grade );
    }


    public String toString()
    {
        return lynbrookId + " " + firstName + " " + lastName + " " + grade;
    }
}
