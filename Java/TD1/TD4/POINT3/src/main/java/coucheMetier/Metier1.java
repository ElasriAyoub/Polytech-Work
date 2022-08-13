package coucheMetier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;

import coucheDao.IDao;
import entites.Personne;

public class Metier1 implements IMetier {
	
	@Autowired
	private IDao dao;	
	
	public Metier1(){}
	
	public void setDao(IDao dao)	{
		this.dao =dao;
	}
	
	public Personne[] getByAge(int age) 
	{
		Personne[] personnes=dao.getByAge(age);
		Arrays.sort(personnes,new CompareNom());		
		return personnes;
	}

	public Personne[] getMajeurs() {
		Personne[] personnes=dao.getAll();
		Arrays.sort(personnes,new CompareNom());		
		ArrayList<Personne> tab=new ArrayList<Personne>();
		for(Personne p:personnes){
			if(p.getAge()>=18)	tab.add(p);
		}
		return tab.toArray(new Personne[tab.size()]);
	}

	public void updateAge() {
		// TODO Auto-generated method stub
		Personne[] personnes=dao.getAll();
		for(Personne p:personnes) p.setAge(p.getAge()+1);
		dao.setAll(personnes);
	}	
	
}

class CompareNom implements Comparator<Personne>
{
		public int compare(Personne o1, Personne o2) {		
			return o1.getNom().compareTo(o2.getNom());
	}
	
}
