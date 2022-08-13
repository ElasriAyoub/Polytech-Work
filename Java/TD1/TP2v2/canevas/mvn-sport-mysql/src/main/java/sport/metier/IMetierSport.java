package sport.metier;

import sport.entites.ChoixEtudiant;

public interface IMetierSport
{	
	/**
	 * 
	 * @param capacites = tableau indiquant quelles sont les capacités
	 * d'accueil dans chaque sport ex: [15,20,20,20,15]
	 * 
	 * @exception lève une exception s'il n'y a pas suffisamment 
	 * de places pour affecter tous les étudiants 
	 *  (somme des capa >= nombre d'étudiants)
	 */
	void setCapacites(int[] capacites ) throws Exception;	
	
	/**
	 * 
	 * @return renvoie le tableau des capacités par sport
	 */
	int[] getCapacites();
	
	/**
	 * 
	 * @param c1 le sport en premier choix
	 * @return l'ensemble des étudiants ayant mis ce sport en choix 1
	 */
	ChoixEtudiant[] getByChoix1(int c1);
	
	/**
	 * 
	 * @param sport
	 * @return
	 */
	ChoixEtudiant[] getBySport(int sport);
			
	/**
	 * Lit les choix dans DAO et affecte les étudiants aux différents 
	 * sports, ceci en fonction de leurs voeux et des places disponibles
	 * dans chaque sport
	 * 
	 *  @exception lève une exception s'il n'y a pas suffisamment 
	 * de places et donc que l'affectation n'est pas possible
	 */
	void affecterSports() throws Exception;	
	
}
