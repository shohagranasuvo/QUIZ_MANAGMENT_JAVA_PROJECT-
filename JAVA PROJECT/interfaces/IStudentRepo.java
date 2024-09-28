package interface;
import java.lang.*;
import entities.*;

public interface IStudentRepo 
{
    public void addStudent (Student s);
    public void upgradeStudent (Student s);
    public void deleteStudent (String id);
    public Student SearchStudent (String id);
    public Student [] getAllStudent ();

}