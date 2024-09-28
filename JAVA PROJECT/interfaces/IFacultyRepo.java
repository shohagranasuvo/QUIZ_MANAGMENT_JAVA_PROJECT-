package interfaces;
import java.lang.*;
import entities.*;

public interface IFacultyRepo
{
    public void addFaculty(Faculty f);
	public void updateFaculty(Faculty f);
	public void deleteFaculty(String id);
	public Faculty searchFaculty(String id);
	public Faculty[] getAllFaculty();
}