package coucheMetier;
import coucheDao.IDao;
import entites.Personne;

public interface IMetier {
	public void setDao(IDao dao);	
	public Personne[] getByAge(int age);	
	public Personne[] getMajeurs();
	public void updateAge();
}
