package application;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pta.sagi.sport.entites.ChoixEtudiant;
import sport.metier.IMetierSport;

public class Controller {

	@Autowired
	IMetierSport metier; // injection du bean Metier
	
	@FXML
	TextField textField; // zone de saisie de la région

	@FXML
	TextField textField2; // zone de saisie de la région

	
	@FXML
	ListView<ChoixEtudiant> listview; // listview
	
	@FXML
	void OnClick(ActionEvent e) // gestionnaire bouton ByRegion
	{	
		try
		{
			listview.getItems().clear();
			metier.affecterSport();
			int region  = Integer.parseInt(textField.getText());
			ChoixEtudiant[] Candi = metier.getByChoix(region);
			for(ChoixEtudiant c: Candi)
			{
				listview.getItems().add(c);
			}
		}catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}
	
	@FXML
	void OnSet(ActionEvent e) // gestionnaire bouton ByRegion
	{	
		try
		{	int[] capacit = new int[5];
			int i=0;
			String set  = textField2.getText();
			listview.getItems().clear();
			String[] cap = set.split(";");
			for(String a: cap)
			{
				capacit[i] = Integer.parseInt(a);
				i++;
			}
			try {
				metier.setCapacites(capacit);
				System.out.print(capacit.toString());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}catch(Exception E)
		{
			System.out.println(E.getMessage());
		}
	}	
}
