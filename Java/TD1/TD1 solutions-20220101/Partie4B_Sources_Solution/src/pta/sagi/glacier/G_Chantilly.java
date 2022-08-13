package pta.sagi.glacier;

public class G_Chantilly implements IGlace 
{
	private IGlace _glace;

	public G_Chantilly(IGlace g) 
	{
		_glace =g;		
	}
	
	@Override
	public double getPrix()
	{
		return _glace.getPrix()+0.75;
	}
	
	public String toString()
	{
		return _glace.toString() + "  [+ Chantilly 0.75]";
	}	

}
