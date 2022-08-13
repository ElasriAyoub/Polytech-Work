package pta.sagi.glacier;


public class Boule 
{
    private String _parfum;
    private double _prix;
    
    public Boule(String parfum,double prix){        
      _parfum=parfum;
      _prix=prix; 
    }
    
    public void setParfum(String parfum){ _parfum=parfum; }
    public void setPrix(float prix){ _prix=prix; }
    
    public String getParfum(){ return _parfum;}
    public double getPrix(){ return _prix;}    
    
    @Override
    public String toString(){
    	return String.format("Boule %s %.2f €",_parfum,_prix);
    	//return "Boule " + _parfum + " " + Double.toString(_prix) + "�";
    }
       
    
}
