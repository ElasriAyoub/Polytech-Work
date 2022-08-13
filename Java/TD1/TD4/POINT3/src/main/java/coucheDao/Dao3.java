package coucheDao;

import java.io.File;
import java.util.ArrayList;
import com.fasterxml.jackson.databind.ObjectMapper;

import entites.Personne;

public class Dao3 implements IDao
{

	String fName ="personnes1.json";
	
	public Personne[] getAll() {
		// TODO Auto-generated method stub
		try{
			File file = new File(fName);
					
			ObjectMapper om = new ObjectMapper();
			Personne[] lesCandidats = om.readValue(file,Personne[].class);
			return lesCandidats;
			}catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	}

	public void setAll(Personne[] personnes) {
		// TODO Auto-generated method stub
		
		try{
		File file = new File(fName);
				
		ObjectMapper om = new ObjectMapper();							
		om.writeValue(file, personnes);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Personne[] getByAge(int age) {
		try{
			File file = new File(fName);
		ObjectMapper om = new ObjectMapper();
		Personne[] lesCandidats = om.readValue(file,Personne[].class);
		ArrayList<Personne> pers=new ArrayList<Personne>();
		for(Personne p:pers){
			if(p.getAge()==age)	pers.add(p);			
		}
		return pers.toArray(new Personne[pers.size()]);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new Personne[0];
		}
	}
	

}
