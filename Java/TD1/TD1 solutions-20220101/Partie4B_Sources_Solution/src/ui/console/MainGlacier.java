/*
 */
package ui.console;

import java.io.IOException;


import pta.sagi.glacier.*;

/**
 * @author bertrand cottenceau
 */
public class MainGlacier {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException 
    {
    	try {
    	Glace g = new Glace();
    	g.add(new Boule("Vanille",1.5));
    	g.add(new Boule("Chocolat",2));
    	
    	IGlace maglace = g;
    	System.out.println(maglace);
    	
    	maglace=new G_Caramel(maglace);
    	System.out.println(maglace);
    	System.out.printf("prix %f \n",maglace.getPrix());
    	}
    	catch(Exception ex)
    	{
    		System.out.println(ex.getMessage());
    	}
    	
    }
    
}
