package pta.sagi.magasin;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Un objet PanierPlus ajoute des opérations à un Panier
 * 
 * @author bc
 *
 */
public class PanierPlus extends Panier
{
	
	/**
	 * Crée un panier vide
	 */
	public PanierPlus()
	{
		super();
	}
	
	/**
	 * Crée un panier peuplé des produits du tableau
	 * 
	 * @param tab
	 */
	public PanierPlus(IProduit[] tab)
	{
		super(tab);
	}
	
	/**
	 * Total des prix des produits du panier
	 * 
	 * @return
	 */
	public double getTotal()
	{
		double tot=0;
		for(int i=0;i<super.getTaille();i++)
		{
			tot+=get(i).getPrix();
		}
		return tot;
	}
	
	/**
	 * Applique un traitement à l'ensemble des produits
	 * 
	 * @param c
	 */
	public void forEach(Consumer<IProduit> c)
	{
		IProduit[] tab=super.getProduits();
		
		for(IProduit p:tab)
		{
			c.accept(p);
		}
	}
	
	/**
	 * Vérifie une propriété sur l'ensemble des produits
	 * 
	 * @param p  Prédicat s'appliquant à chaque produit
	 * @return true (si prédicat vérifié pour tout le panier)
	 */
	public boolean check(Predicate<IProduit> p)
	{
		IProduit[] tab=super.getProduits();
		
		for(IProduit prod:tab)
		{
			if(!p.test(prod)) return false;
		}
		return true;
	}	
	
	/**
	 * Fournit une chaîne décrivant le panier
	 */
	@Override
	public String toString()
	{
		return String.format("Tot=%.2f ",getTotal()) + super.toString();
	}

}
