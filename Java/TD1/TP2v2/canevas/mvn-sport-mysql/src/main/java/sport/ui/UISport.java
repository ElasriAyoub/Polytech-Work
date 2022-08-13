package sport.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;

import sport.entites.ChoixEtudiant;
import sport.metier.IMetierSport;

public class UISport implements IUISport
{
	

	@Override
	public void run(){
		
		// définir la capacité d'accueil pour les 5 sports
		
		
		
		//
		int choix;		
		String prompt="1:Affectation 2:BySport 3:ByChoix1 0:Quit";
		String line;
		BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));					
		do
		{
			System.out.println(prompt);
			try{
				line=clavier.readLine().trim();
				choix= Integer.parseInt(line); }
			catch(Exception e){	choix=0; }
		
			switch(choix)
			{
			case 1:
				//TODO
				break;			
			case 2:	
				//TODO
				break;
			case 3:
				//TODO			
			break;			
			default:				
				break;
			}
		}while(choix!=0);
		
		System.out.println("Bye!");
	}
	

}
