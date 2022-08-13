package coucheDao;
import java.util.ArrayList;

import entites.Personne;

public class Dao1 implements IDao {
	private Personne[] personnes;

	public Dao1(){
		personnes = new Personne[10];
		personnes[0]=new Personne("Gérard",68);
		personnes[1]=new Personne("Maya",22);
		personnes[2]=new Personne("Alexis",20);
		personnes[3]=new Personne("Corentin",22);
		personnes[4]=new Personne("Arthur",22);
		personnes[5]=new Personne("Corentin",22);
		personnes[6]=new Personne("Maxime",24);
		personnes[7]=new Personne("Lucas",23);
		personnes[8]=new Personne("Juliette",25);
		personnes[9]=new Personne("Thomas",23);		
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
