package pta.sagi.magasin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Un panier stocke des reférences à des produits (IProduit)
 * 
 * @author bc
 *
 */

public class Panier 
{
	/**
	 * Référence à une collection de produits
	 */
	private ArrayList<IProduit> _produits;
	
	/**
	 * Crée un panier vide (0 produit)
	 */
 	public Panier()
 	{
 		_produits = new ArrayList<IProduit>();
 	}
 	
 	/**
 	 * Crée un panier peuplé des produits du tableau
 	 * 
 	 * @param tab
 	 */
 	public Panier(IProduit[] tab)
 	{
 		_produits = new ArrayList<IProduit>();
 		List<IProduit> list = Arrays.asList(tab);
 		for(IProduit p:list){	add(p); 	} 		
 	}
 	
 	/**
 	 * Ajoute le produit au panier (évite de stocker des ref null)
 	 * @param p reference à un produit
 	 */
 	public void add(IProduit p)
 	{
 		if(p!=null) _produits.add(p);
 	}
 	
 	/**
 	 * Fournit le nombre de produits
 	 * 
 	 * @return
 	 */
 	public int getTaille()
 	{
 		return _produits.size();
 	}
 	
 	/**
 	 * Fournit le produit d'indice idx ou null
 	 * 
 	 * @param idx
 	 * @return un produit (ou null si indice incorrect)
 	 */
 	public IProduit get(int idx)
 	{
 		if(idx>=0 && idx<getTaille())
 		{
 			return _produits.get(idx);
 		}
 		else return null;
 	}
 	
 	/**
 	 * Fournit tous les produits sous la forme d'un tableau
 	 * 
 	 * @return
 	 */
 	public IProduit[] getProduits()
 	{
 		return _produits.toArray(new IProduit[0]);
 	}
 	
 	/**
 	 * Fournit une chaîne décrivant le panier et ses produits
 	 */
 	@Override
 	public String toString()
 	{
 		String str=String.format("%d articles \n", getTaille());
 		for(IProduit p:_produits)
 		{
 			str+=p.toString() + "\n";
 		}
 		return str;
 	}

}
