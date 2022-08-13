package coucheDao;
import java.util.Random;
import java.util.ArrayList;
import entites.Personne;

public class Dao2 implements IDao {

	private Personne[] personnes;		
	
	public Dao2()
	{
		personnes=new Personne[18];		
		String[] prenoms = new String[]{"Marie","Pierre", "Lucie", "Louis","Gustave","Léon"};		
		Random rand = new Random();
		for(int i=0;i<18;i++)
		{	personnes[i]= new Personne(prenoms[rand.nextInt(6)],rand.nextInt(50)+2);
		}		
	}
	
	

	public Personne[] getAll() {		
		return personnes.clone(); 
	}


	public void setAll(Personne[] personnes) {		
		if(personnes!=null){
			this.personnes = personnes.clone();
		}			
	}
	
	public Personne[] getByAge(int age) {
		ArrayList<Personne> pers=new ArrayList<Personne>();
		for(Personne p:this.personnes){
			if(p.getAge()==age)	pers.add(p);			
		}
		return pers.toArray(new Personne[pers.size()]);
	}
}
