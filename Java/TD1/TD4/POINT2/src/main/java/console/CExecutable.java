package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import coucheDao.Dao2;
import coucheDao.Dao3;
import coucheDao.IDao;
import coucheMetier.IMetier;
import coucheMetier.Metier1;
import coucheMetier.Metier2;
import entites.Personne;

public class CExecutable {

		public static void PrintData(Personne[] tabP){
			System.out.println("Donnees:");
			for(Personne p:tabP) System.out.println(p.toString());
		}

		public static void main(String[] args)  throws IOException 
		{		
		// CREATION COUCHES de l'APPLICATION
		IDao dao= new Dao3();  
		IMetier metier = new Metier1(); 		
		metier.setDao(dao);			
			
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
	}
	

}
