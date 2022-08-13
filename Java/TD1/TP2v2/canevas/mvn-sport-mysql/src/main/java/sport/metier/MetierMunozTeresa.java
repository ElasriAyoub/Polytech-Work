package sport.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.*;

import sport.dao.IDaoSport;
import sport.entites.ChoixEtudiant;

public class MetierMunozTeresa implements IMetierSport{

	public ArrayList<ChoixEtudiant> s1 = new ArrayList<ChoixEtudiant>();
	public ArrayList<ChoixEtudiant> s2 = new ArrayList<ChoixEtudiant>();
	public ArrayList<ChoixEtudiant> s3 = new ArrayList<ChoixEtudiant>();
	public ArrayList<ChoixEtudiant> s4 = new ArrayList<ChoixEtudiant>();
	public ArrayList<ChoixEtudiant> s5 = new ArrayList<ChoixEtudiant>();
	private int[] capacite;
	
	public MetierMunozTeresa() {
		capacite=new int[] {0,0,0,0,0};
		}
	@Autowired
	public IDaoSport Dao;

	
	@Override
	public void setCapacites(int[] capacites) throws Exception {
		if(capacites.length==5)
		{
			int somme=capacites[0]+capacites[1]+capacites[2]+capacites[3]+capacites[4];
			if(somme >=Dao.getCount())
			{
				for (int i=0; i<capacites.length;i++)
					capacite[i]=capacites[i];
			}
			else
			{
				throw new Exception("Pas assez de places");
			}
		}
		else
		{
			throw new Exception("le tableau doit être de taille=5");
		}
	}

	@Override
	public int[] getCapacites() {

		return capacite;
	}

	@Override
	public ChoixEtudiant[] getByChoix1(int c1) {
		// TODO Auto-generated method stub
		return Dao.getByChoix1(c1);
	}

	@Override
	public ChoixEtudiant[] getBySport(int sport) {
		switch(sport)
		{
		case 1:
			return s1.toArray(new ChoixEtudiant[0]);
		case 2:
			return s2.toArray(new ChoixEtudiant[0]);
		case 3:
			return s3.toArray(new ChoixEtudiant[0]);
		case 4:
			return s4.toArray(new ChoixEtudiant[0]);
		case 5:
			return s5.toArray(new ChoixEtudiant[0]);
		}
		return null;
	}

	@Override
	public void affecterSports() throws Exception {
		ChoixEtudiant[] tabCE=Dao.getAll();
		if(tabCE.length>0)
		{
			Collections.shuffle(Arrays.asList(tabCE));
			for( ChoixEtudiant c : tabCE)
			{
				int choix1=c.getChoix()[0]-1;
				int choix2=c.getChoix()[1]-1;
				if (capacite[choix1]>0)
				{
					c.setSport(choix1+1);
					
				}
				else if(capacite[choix2]>0)
					c.setSport(choix2+1);
				else
				{
					for(int i=0; i<5;i++)
					{
						if(capacite[i]>0)
							c.setSport(i+1);
					}
				}
				capacite[c.getSport()-1]--;
				if(c.getSport()==1) {s1.add(c);}
				if(c.getSport()==2) {s2.add(c);}
				if(c.getSport()==3) {s3.add(c);}
				if(c.getSport()==4) {s4.add(c);}
				if(c.getSport()==5) {s5.add(c);}
					
			}
		}
		else
			throw new Exception("Liste vide");
	}
	

}
