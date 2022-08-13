package pta.sagi.glacier;

public class G_Caramel implements IGlace
{
	private IGlace _glace;

	public G_Caramel(IGlace g) 
	{
		_glace =g;		
	}
	
	@Override
	public double getPrix()
	{
		return _glace.getPrix()+0.9;
	}
	
	public String toString()
	{
		return _glace.toString() + "  [+ Caramel 0.9]";
	}	

}
