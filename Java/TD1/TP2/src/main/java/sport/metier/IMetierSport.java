package sport.metier;

import pta.sagi.sport.entites.ChoixEtudiant;

public interface IMetierSport {
	
	public int[] getCapacites();
	public void setCapacites(int[] cap) throws Exception;
	public ChoixEtudiant[] getBySport(int C);
	public ChoixEtudiant[] getByChoix(int C);
	public void affecterSport() throws Exception;
	
	
}
