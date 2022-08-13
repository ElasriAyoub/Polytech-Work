package sport.entites;

public class ChoixEtudiant 
{
	private int id;
	private String nom;
	private String prenom;
	private int[] choix;
	private int sport;	
		
	public ChoixEtudiant(){	choix=new int[2];}
	
	/**	 
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param choix1
	 * @param choix2
	 * @param sport
	 */
	public ChoixEtudiant(int id,String nom,String prenom,int choix1,int choix2,int sport)
	{	
		setId(id);
		setNom(nom);
		setPrenom(prenom);
		choix=new int[2];
		choix[0]=Math.max(1,Math.min(5,choix1));
		choix[1]=Math.max(1,Math.min(5,choix2));
		this.sport=Math.max(1,Math.min(5,sport));		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
		
	/**
	 * 
	 * @return Retourne le sport
	 */
	public int getSport()
	{
		return sport;
	}
	
	/**
	 * Définit le sport et met à jour la satisfaction 
	 * @param sport
	 */
	public void setSport(int sport)
	{
		this.sport = Math.max(1,Math.min(5,sport));		
	}	

	/**
	 * Retourne les choix1 et 2 dans un tableau
	 * @return
	 */
	public int[] getChoix()
	{
		return choix;
	}	
	
	/**
	 * Définit les choix 1 et 2
	 * @param choix1  Doit être compris entre 1 et 5
 	 * @param choix2 Doit être compris entre 1 et 5
	 */
	public void setChoix(int choix1,int choix2)
	{
		choix[0]=Math.max(1,Math.min(5,choix1));
		choix[1]=Math.max(1,Math.min(5,choix2));		
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
}
