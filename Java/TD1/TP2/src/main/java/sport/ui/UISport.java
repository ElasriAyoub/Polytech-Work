package sport.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigSpring;
import pta.sagi.sport.entites.ChoixEtudiant;
import sport.metier.IMetierSport;

public class UISport implements IUISport{

	public static void PrintData(ChoixEtudiant[] tabP){
		System.out.println("Données:");
		for(ChoixEtudiant p:tabP) System.out.println(p.toString());
	}
	

	public static void main(String[] args) {		
		try
			  {		
				IMetierSport metier=null;	
				AnnotationConfigApplicationContext ctx;
				ctx = new AnnotationConfigApplicationContext(ConfigSpring.class);
				metier = ctx.getBean(IMetierSport.class);	
				
				
				int choix;
				ChoixEtudiant[] art ;
				String prompt="1:Affectation 2:BySport 3:ByChoix1 0:Quit";
				String line;
				Scanner clav= new Scanner(System.in);
				BufferedReader clavier = 
					new BufferedReader(new InputStreamReader(System.in));		
				int sport;
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
						System.out.println("Affectation");
						int[] cap = {4,9,2,4,6};
						try {
							metier.setCapacites(cap);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						metier.affecterSport();
						break;			
					case 2:	
						System.out.println("Donner le numero de sport : ");
						sport = clav.nextInt();
						art = metier.getBySport(sport);
						PrintData(art);
						break;		
					case 3:	
						System.out.println("Donner le numero de choix : ");
						sport = clav.nextInt();
						art = metier.getByChoix(sport);
						PrintData(art);
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
				System.exit(1); } 
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
