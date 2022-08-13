package coucheMetier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import coucheDao.IDao;
import entites.Personne;

public class Metier2 implements IMetier {	
	private IDao dao;

	public void setDao(IDao dao)	{
		this.dao =dao;
	}
	public Metier2() {}
	
	public Personne[] getByAge(int age) 
	{		
		return dao.getByAge(age);
	}

	public Personne[] getMajeurs() {
		Personne[] personnes=dao.getAll();
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