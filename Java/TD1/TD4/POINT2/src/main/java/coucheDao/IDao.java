package coucheDao;

import entites.Personne;

public interface IDao {

	public Personne[] getAll();
	public void setAll(Personne[] personnes);
	public Personne[] getByAge(int age);
	
}
