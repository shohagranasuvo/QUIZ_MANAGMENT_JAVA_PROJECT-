package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class StudentRepo implements IStudentRepo
{
	private String file="repositories/data/students.txt";
	private FileIO fio=new FileIO();
	public void addStudent(Student s)
	{
		Student stds[]=this.getAllStudent();
		for(int i=0;i<100;i++)
		{
			if(stds[i]==null)
			{
				stds[i]=s;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(stds[i]!=null)
			{
				data[i]=stds[i].toStringStudent();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public void updateStudent(Student s)
	{
		Student std=this.searchStudent(s.getUserId());
		if(std!=null)
		{
			this.deleteStudent(s.getUserId());
			this.addStudent(s);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteStudent(String id)
	{
		Student stds[]=this.getAllStudent();
		
		for(int i=0;i<100;i++)
		{
			if(stds[i]!=null)
			{
				if(stds[i].getUserId().equals(id))
				{
					stds[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(stds[i]!=null)
			{
				data[i]=stds[i].toStringStudent();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public Student searchStudent(String id)
	{
		Student stds[]=this.getAllStudent();
		
		for(int i=0;i<100;i++)
		{
			if(stds[i]!=null)
			{
				if(stds[i].getUserId().equals(id))
				{
					return stds[i];
				}
			}
		}
		
		return null;
	}
	public Student[] getAllStudent()
	{
		String data[]=fio.readFile(this.file);
		Student stds[]=new Student[100];
		Student std=new Student();
		
		for(int i=0;i<stds.length;i++)
		{
			if(stds[i]==null)
			{
				if(data[i]!=null)
				{
					stds[i]=std.formStudent(data[i]);
				}
				
			}
		}
		
		return stds;
	}
}
