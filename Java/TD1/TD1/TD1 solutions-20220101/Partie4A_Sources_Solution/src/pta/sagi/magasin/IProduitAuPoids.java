package pta.sagi.magasin;

public interface IProduitAuPoids extends IProduit 
{
	/**
	 * Fournit le prix au Kg du produit
	 * @return prix/Kg  
	 */
	public double getPrixAuKilo();
	
	/**
	 * Fournit le poids d'un produit r (en Kg)
	 * 
	 * @return poids
	 */
	public double getPoidsKg();

}
