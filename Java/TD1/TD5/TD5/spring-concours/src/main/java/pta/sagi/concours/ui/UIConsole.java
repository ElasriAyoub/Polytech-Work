package pta.sagi.concours.ui;


import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import pta.sagi.concours.entites.Candidat;
import pta.sagi.concours.metier.IMetierConcours;
import pta.sagi.concours.metier.MetierConcours;

public class UIConsole implements IUserInterfaceConcours{
	
	@Autowired
	private IMetierConcours metier;
	
	public void run()
	{
		metier.setTopSize(3); // définit la taille du Top
		int choix;
		String prompt="0:Quit 1:Liste/Region 2:Top3/Region 3:Add";
		String line;
		int region;
		BufferedReader clavier =new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println(prompt);
			try{
				line=clavier.readLine().trim();
				choix= Integer.parseInt(line);
				}
				catch(Exception e){ choix=0; }
				
				
				switch(choix)
				{
					case 1:
							System.out.println("Liste:Region ?");
							try{
								line=clavier.readLine().trim();
								region= Integer.parseInt(line);
								Candidat[] cands=metier.getCandidats(region);
								for(Candidat c:cands)
								{
									System.out.println(c);
								}
							}
							catch(Exception e){
								System.out.println(e.getMessage());
							}
							break;
					case 2:
						System.out.println("Top:Region ?");
						try{
							line=clavier.readLine().trim();
							region= Integer.parseInt(line);
							Candidat[] cands=metier.getTop(region);
							for(Candidat c:cands)
							{
								System.out.println(c);
							}
						}
						catch(Exception e){
							System.out.println(e.getMessage());
						}
						break;
					case 3:
						System.out.println("Add");
						break;
					default:
						choix=0;
						break;
					} }
					while(choix!=0);
					System.out.println("Bye!");
				}
	}

