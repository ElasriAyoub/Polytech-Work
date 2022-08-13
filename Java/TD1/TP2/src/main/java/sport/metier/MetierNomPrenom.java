package sport.metier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;

import pta.sagi.sport.dao.IDaoSport;
import pta.sagi.sport.entites.ChoixEtudiant;

public class MetierNomPrenom implements IMetierSport {

	@Autowired
	IDaoSport dao; 
	
	private static ChoixEtudiant[] A;
	private int[] _cap;
	private final int tailleMax= 5;
	
	public MetierNomPrenom() 
	{
		_cap = new int[tailleMax];
		//A = dao.getAll();
	}
	
	@Override
	public int[] getCapacites() {
		return _cap;
		}

	@Override
	public void setCapacites(int[] cap) throws Exception{
		int size = dao.getCount();
		int somme = 0;
		for(int i= 0; i< cap.length ; i++)
			somme += cap[i];
		
		if(cap.length == tailleMax && size < somme)
			_cap = cap;
		else
			throw new Exception("Espace Insuffisant");
	}

	@Override
	public ChoixEtudiant[] getBySport(int C) {
		
		
		ArrayList<ChoixEtudiant> Etud= new ArrayList<ChoixEtudiant>(); 
		ChoixEtudiant[] B = A.clone();
		for(ChoixEtudiant cap : B)
		{
			if(cap.get_choixsport() == C )
				Etud.add(cap);	
		} 
		return Etud.toArray(new ChoixEtudiant[0]);				
	}

	@Override
	public ChoixEtudiant[] getByChoix(int C) {
		ArrayList<ChoixEtudiant> Etud= new ArrayList<ChoixEtudiant>(); 
		ChoixEtudiant[] B = dao.getAll();
	   for(ChoixEtudiant cap : B)
		{
			if(cap.get_C1() == C )
				Etud.add(cap);	
		}
		return Etud.toArray(new ChoixEtudiant[0]);		
	}

	@Override
	public void affecterSport() throws Exception {
		
		A=dao.getAll();
		Collections.shuffle(Arrays.asList(A));
		for(ChoixEtudiant C: A)
		{
			if(_cap[C.get_C1()-1]>0)
			{
					C.set_choixsport(C.get_C1());
					_cap[C.get_C1()-1] --;
			}
			else if(_cap[C.get_C2()-1]>0)
			{
				C.set_choixsport(C.get_C2());
				_cap[C.get_C2()-1] --;
			}
			else
			{
				for(int i=0; i< _cap.length;i++)
				{
					if((i+1)!=C.get_C1() && (i+1)!= C.get_C2())
						if(_cap[(i)] > 0)
						{
							C.set_choixsport(i+1);
							_cap[i]--;
							break;
						}
							
				}
				throw new Exception("Pas de places Disponibles"); 
			}
					
	}

	}
}
