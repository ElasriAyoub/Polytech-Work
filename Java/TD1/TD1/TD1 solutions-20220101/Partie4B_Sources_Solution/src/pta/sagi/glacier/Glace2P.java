package pta.sagi.glacier;

public class Glace2P extends Glace 
{
	public Glace2P()
	{
		super(2);
	}
	
	public Glace2P(Boule b1,Boule b2)
	{
		super(2);
		try {
		add(b1);
		add(b2);
		}
		catch(Exception ex) {}
	}
	

}
