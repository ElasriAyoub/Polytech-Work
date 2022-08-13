package myPackage;

public class DossierBancaire {
	
	//Constructeur
    public DossierBancaire()
    {
    	m_solde=0;
    }

    public void deposer(double value) 
    	{
    	m_solde+=value;
    	eparn.setM_soldeEpargne(eparn.getM_soldeEpargne() + value*0.6);
    	court.setM_soldeCourant(court.getM_soldeCourant() + value*0.4);
    	}
    public double get_solde() {return m_solde;}
    public void remunerer() 
    {
    	m_solde+=eparn.getM_soldeEpargne() * 0.032;
    }

    public void retirer(double value) throws Exception
    {
    	if(court.getM_soldeCourant() >= value)
    	{
    		m_solde = m_solde - value;
    		court.setM_soldeCourant(court.getM_soldeCourant() - value);
    	}
    	else
    		throw new Exception("Solde insuffisant");
    }
    private double m_solde;
    Epargne eparn = new Epargne();
    Courant court = new Courant();;
}
