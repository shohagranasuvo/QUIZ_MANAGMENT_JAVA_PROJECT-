package repositories;
import java.io.*;
import java.util.*;

public class FileIO{

public void createFile (String fileLocation)
    {try{
        
        File stdFile = new File(fileLocation);
        if(stdFile.createNewFile())
        { 

            System.out.println("New File Crteate ");


        }
        else{

            System.out.println("File Already Exist");
        }


     }

    
    catch(Exception e ){

        e.printStackTrace();
    }
}









public List readFile (String FileLocation){
   List<String>  Data = new ArrayList();


    try {

        FileReader frc=new FileReader(FileLocation);
        BufferedReader brc = new BufferedReader(frc);

        String tem="";
        int i=0;
        while ((tem =brc.readLine())!=null) 
        {
            Data.add(tem);
            i++;
            
            
            
        }


        
    } 
    
    
    catch (Exception e) {
        e.printStackTrace();
    }



return Data ;

}

public void writeFile(String file, List <String>data )
	{
		try
		{
			FileWriter fwr=new FileWriter(file);
		
			for(String line : data)
			{
				if(line!=null)
				{
					 fwr.write(line + System.lineSeparator());
				}
			}
			
			fwr.flush();
			fwr.close();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}




}


  


















