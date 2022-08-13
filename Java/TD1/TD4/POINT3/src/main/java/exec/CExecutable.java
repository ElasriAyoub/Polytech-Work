package exec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Config;
import coucheMetier.IMetier;
import entites.Personne;

public class CExecutable {

	public static void PrintData(Personne[] tabP){
		System.out.println("Données:");
		for(Personne p:tabP) System.out.println(p.toString());
	}
	
	public static void main(String[] args) {		
			
		  try
		  {		
			IMetier metier=null;	
			AnnotationConfigApplicationContext ctx;
			ctx = new AnnotationConfigApplicationContext(Config.class);
			metier = ctx.getBean(IMetier.class);	
			
			
			int choix;
			String prompt="0:Quit 1:Majeurs 2:UpdateAge";
			String line;
			BufferedReader clavier = 
				new BufferedReader(new InputStreamReader(System.in));						
			do
			{
				System.out.println(prompt);
				try{
				  line=clavier.readLine().trim();
				  choix= Integer.parseInt(line); 
				}
				catch(Exception e){	choix=0; }
				
				switch(choix)
				{
				case 1:				
					PrintData(metier.getMajeurs());
					break;			
				case 2:	
					metier.updateAge();
					break;		
				default:
					choix=0;
					break;
				}
			}while(choix!=0);			
			System.out.println("Bye!");
			ctx.close();
		  }		
		  catch(Exception ex){
			System.out.println(ex.getMessage());
			System.exit(11); }				
		  
		  
	}

}
