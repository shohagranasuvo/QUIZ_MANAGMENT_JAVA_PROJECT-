package repositories;
import java.lang.*;
import entities.*;
import interfaces.*;

public class FacultyRepo implements IFacultyRepo
{
	private String file="repositories/data/facultys.txt";
	private FileIO fio=new FileIO();
	public void addFaculty(Faculty f)
	{
		Faculty flts[]=this.getAllFaculty();
		for(int i=0;i<100;i++)
		{
			if(flts[i]==null)
			{
				flts[i]=f;
				break;
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(flts[i]!=null)
			{
				data[i]=flts[i].toStringFaculty();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public void updateFaculty(Faculty f)
	{
		Faculty flt=this.searchFaculty(f.getUserId());
		if(flt!=null)
		{
			this.deleteFaculty(f.getUserId());
			this.addFaculty(f);
		}
		else
		{
			System.out.println("Not Found");
		}
	}
	public void deleteFaculty(String id)
	{
		Faculty flts[]=this.getAllFaculty();
		
		for(int i=0;i<100;i++)
		{
			if(flts[i]!=null)
			{
				if(flts[i].getUserId().equals(id))
				{
					flts[i]=null;
				}
			}
		}
		
		String data[]=new String[100];
		
		for(int i=0;i<100;i++)
		{
			if(flts[i]!=null)
			{
				data[i]=flts[i].toStringFaculty();
			}
		}
		
		fio.writeFile(this.file,data);
	}
	public Faculty searchFaculty(String id)
	{
		Faculty flts[]=this.getAllFaculty();
		
		for(int i=0;i<100;i++)
		{
			if(flts[i]!=null)
			{
				if(flts[i].getUserId().equals(id))
				{
					return flts[i];
				}
			}
		}
		
		return null;
	}
	public Faculty[] getAllFaculty()
	{
		String data[]=fio.readFile(this.file);
		Faculty flts[]=new Faculty[100];
		Faculty flt=new Faculty();
		
		for(int i=0;i<flts.length;i++)
		{
			if(flts[i]==null)
			{
				if(data[i]!=null)
				{
					flts[i]=flt.formFaculty(data[i]);
				}
				
			}
		}
		
		return flts;
	}
}
