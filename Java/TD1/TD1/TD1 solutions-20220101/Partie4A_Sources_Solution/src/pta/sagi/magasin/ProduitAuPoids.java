package pta.sagi.magasin;

/**
 * 
 * @author bc
 *
 */
public class ProduitAuPoids extends Produit implements IProduitAuPoids  

{
	public double _poidsKg;
	
	/**
	 * 
	 * @param nom du produit
	 * @param pxKg prix du produit au Kg
	 * @param poidsKg poids en Kg
	 */
	public ProduitAuPoids(String nom, double pxKg,double poidsKg) 
	{
		super(nom, pxKg*poidsKg);
		_poidsKg=Math.abs(poidsKg);
	}

	/**
	 * Fournit le prix au Kg
	 * @return prix/Kg
	 */
	@Override
	public double getPrixAuKilo() {
		return getPrix()/getPoidsKg();	
	}

	/**
	 * Fournit le poids du produit
	 */
	@Override
	public double getPoidsKg() {
		
		return _poidsKg;
	}
	
	/**
	 * Fournit une chaîne qui décrit le produit
	 * @return 
	 */
	@Override 
	public String toString()
	{
		return super.toString() + String.format("(%.3fkg)",_poidsKg);
	}

}
