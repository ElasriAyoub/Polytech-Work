/* 
 */
package pta.sagi.glacier;


/** 
 * @author bertrand cottenceau
 */
public class Glace implements IGlace
{
    private byte _nbBoules;
    private Boule[] _boules;
    
    /**
     * Crée un objet Glace de capacité tailleMax et de taille 0
     * @param tailleMax 
     * 			nombre maximal de boules
     */
    public Glace(int tailleMax)
    {
        _boules = new Boule[tailleMax];           
        _nbBoules=0;        
    }
    
    /**
     * Crée une glace de capacité 3 boules
     */
    public Glace(){
        this(3);
    }
    
    /**
     * Crée une glace avec 1 boule (capacité 1)  
     * @param b 
     */
    public Glace(Boule b){
        this(1);
        try {
        add(b);
        }
        catch(Exception ex)
        {
        	
        }
    }
  
    /**
     * Ajoute une boule à la glace (si la taille<capacité)
     * @param b
     */
    public void add(Boule b) throws Exception
    {
        if(b!=null && _nbBoules<_boules.length)
        {
            _boules[_nbBoules]=b;
            _nbBoules++;
        }     
        else
        {
        	throw new Exception("Ajout impossible (capacité==taille)");
        }
    }

    /**
     * Fournit une boule de la glace (ou null)
     * @param i numéro de la boule
     * @return une boule ou null
     */
    public Boule get(int i)
    {
    	if(i>=0 && i<getTaille())
    	{
    		return _boules[i];
    	}
    	else return null;    	
    }
    
    
    /**
     * Fournit la taille, cad le nombre de boules de la glace
     * @return
     */
    public int getTaille()
    {
    	return this._nbBoules;
    }
    
    /** 
     * Fournit la capacité, cad le nombre max de boules que peut stocker la glace
     * @return
     */
    public int getCapacite()
    {
    	return _boules.length;
    }
    
    
    /**
     * Fournit le prix de la glace
     * @return prix (double)
     */    
    @Override
    public double getPrix(){
       double prix=0;
       for(byte i=0;i<_nbBoules;i++){           
           prix+=_boules[i].getPrix();
       }
       return prix;           
    }

    /**
     * Fournit une chaîne qui décrit la glace
     */       
    @Override
    public String toString()
    {
    	return String.format("Glace %d boules %.2f €",_nbBoules,getPrix());
    }    
}
