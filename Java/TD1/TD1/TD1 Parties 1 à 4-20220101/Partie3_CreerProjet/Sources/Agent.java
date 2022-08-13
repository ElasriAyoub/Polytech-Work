/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author 
 */
public class Agent extends Personne 
{
    private String fonction;
    
    public Agent()
    {
        super(-1,"007");
        fonction = "aucune";
    }
    public Agent(int id,String nom, String fonction)
    {
        super(id,nom);
        this.fonction=fonction;
    }
    
    @Override
    public String toString()
    {
        return "Agent=(" + super.toString() +") fonction=" + fonction;
    }
    
    public String getFonction(){ return fonction;}
    
    public void setFonction(String fonction){ this.fonction = fonction;}    
    
}
