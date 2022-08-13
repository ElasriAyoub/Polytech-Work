package pta.sagi.magasin;

/**
 * Interface des produits
 * @author bc
 *
 */
public interface IProduit {
	
	/**
	 * Fournit le prix d'un produit
	 * @return  le prix d'un produit (double)
	 */
	public double getPrix();
	
	/**
	 * Fixe le prix d'un produit
	 * 
	 * @param prix (double)
	 */
	public void setPrix(double prix);
	
	/**
	 * Fournit le nom d'un produit
	 * 
	 * @return nom (String)
	 */
	public String getNom();

}
