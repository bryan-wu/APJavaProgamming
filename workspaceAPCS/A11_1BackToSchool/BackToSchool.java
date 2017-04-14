/**
 * A testing class with a main() that constructs all of the classes (Person,
 * Student, Teacher, and CollegeStudent) and calls their toString() method.
 *
 * @author Bryan Wu
 * @version Oct 10, 2015
 * @author Period: 3
 * @author Assignment: A11_1BackToSchool
 *
 * @author Sources: None
 */
public class BackToSchool
{
    /**
     * Main method
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        Person bob = new Person( "Coach Bob", 27, "M" );
        System.out.println( bob );

        Student lynne = new Student( "Lynne Brooke", 16, "F", "HS95129", 3.5 );
        System.out.println( lynne );

        Teacher mrJava = new Teacher( "Duke Java", 34, "M", 
            "Computer Science", 50000 );
        System.out.println( mrJava );

        CollegeStudent ima = new CollegeStudent( "Ima Frosh", 18, "F", 
            "UCB123", 4.0, 1, "English" );
        System.out.println( ima );
    }
}
