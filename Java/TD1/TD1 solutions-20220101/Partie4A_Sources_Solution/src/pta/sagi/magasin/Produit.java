package pta.sagi.magasin;

/**
 * Classe décrivant des produits
 * 
 * @author bc
 *
 */
public class Produit implements IProduit
{

	private String _nom;
	private double _prix;
	
	/**
	 * Initialise un produit avec un nom et un prix
	 * 
	 * @param nom
	 * @param px
	 */
	public Produit(String nom,double px)
	{
		_nom=nom;
		_prix=Math.abs(px);		
	}
	
	@Override
	public double getPrix() {		
		return _prix;
	}
	
	@Override
	public void setPrix(double prix)
	{
		_prix=Math.abs(prix);
	}

	@Override
	public String getNom() {
		// 
		return _nom;
	}
	
	@Override 
	public String toString()
	{
		return String.format("%s:%.2f€",_nom,_prix);
	}

}
