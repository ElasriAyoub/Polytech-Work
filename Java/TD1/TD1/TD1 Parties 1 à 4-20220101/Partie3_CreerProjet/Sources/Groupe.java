/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Enumeration;
/**
 *
 * @author 
 */
public class Groupe{
    
	/**
	 * Stocke les références aux personnes
	 */
    private ArrayList<Personne> personnes;
  
    
    /**
     * crée un groupe vide
     */
    public Groupe()
    {
        personnes = new ArrayList<Personne>();  
    }  
    
    /**
     * Ajoute une personne au groupe
     * @param p  ref à une personne
     * @throws Exception  : lève exception si p null
     */
    public void Add(Personne p) throws Exception
    {
    	if(p==null) throw new Exception("Ref null");
        personnes.add(p);
    }
    
    /**
     * fournit le nombre de personnes du groupe
     * @return (int) taille
     */
    
    public int Taille()
    {
        return personnes.size();
    }
    
    /**
     * Fournit la personne en position idx
     * @param idx position
     * @return Personne
     */
    public Personne getAt(int idx)
    {
        return personnes.get(idx);
    }
    
    /**
     * Fournit les personnes sous forme de tableau
     * @return tableau de personnes
     */
    public Personne[] getPersonnes()
    {
    	return personnes.toArray(new Personne[1]);    	
    }    
    
    
}
