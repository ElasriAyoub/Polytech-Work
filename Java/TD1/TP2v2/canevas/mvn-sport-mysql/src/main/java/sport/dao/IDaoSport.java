package sport.dao;

import sport.entites.ChoixEtudiant;

public interface IDaoSport 
{	
	/**
	 * 
	 * @return Fournit le nombre d'étudiants à affecter
	 */
	int getCount();
	
	/**
	 * 
	 * @return Fournit tous les choix 
	 */
	ChoixEtudiant[] getAll();
	
	/**
	 * 
	 * @param choix1 compris entre 1 et 5
	 * @return Fournit les étudiants dont le premier choix est sp1
	 */
	ChoixEtudiant[] getByChoix1(int sp1);		
}
