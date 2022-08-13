/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 
 */
public class Personne implements INamed{
    
    private int id;
    private String nom;
    
    public Personne()
    {
        id=0; nom="xxx";
    }
	
	public Personne(int id)
	{
		this.nom ="xxx";
		this.id=id;
	}
	
    public Personne(int id,String nom)
    {
        this(id);        
        this.nom=nom;
    }
    
    @Override
    public String toString()
    {
        return "id=" + Integer.toString(id) + " nom=" + nom;
    }
    
    public int getId(){ return id;}
    public void setId(int id){ this.id= id;}
    
    public String getNom() { return nom;}
    public void setNom(String nom){ this.nom=nom;}    
}
