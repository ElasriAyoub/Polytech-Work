package exec;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;
import pta.sagi.concours.entites.ParserCandidat;
import pta.sagi.concours.ui.IUserInterfaceConcours;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;

import org.springframework.beans.factory.annotation.Autowired;

import pta.sagi.concours.metier.IMetierConcours;

public class Controller {

	@Autowired
	IMetierConcours metier; // injection du bean Metier
	
	@FXML
	TextField textFieldRegion; // zone de saisie de la région
	
	@FXML
	TextField textFieldAdd;
	
	@FXML
	ListView<Candidat> listview; // listview
	
	@FXML
	void OnByRegion(ActionEvent e) // gestionnaire bouton ByRegion
	{
		try {
			int region = Integer.parseInt(textFieldRegion.getText());
			Candidat[] cands=metier.getCandidats(region);
			listview.getItems().clear();
			for(Candidat c:cands){ listview.getItems().add(c); }
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	@FXML
	void OnTop(ActionEvent e) // gestionnaire bouton ByRegion
	{
		try {
			int region = Integer.parseInt(textFieldRegion.getText());
			Candidat[] cands=metier.getTop(region);
			listview.getItems().clear();
			for(Candidat c:cands){ listview.getItems().add(c); }
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}	
	
	@FXML
	void OnSet(ActionEvent e) // gestionnaire bouton ByRegion
	{
		try {
			listview.getItems().clear();
			int size = Integer.parseInt(textFieldRegion.getText());
			metier.setTopSize(size);
			System.out.println(metier.getTopSize());
		
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	@FXML
	void OnAdd(ActionEvent e) // gestionnaire bouton ByRegion
	{
		try {
			listview.getItems().clear();
			/*String[] arrOfStr = null;
			String text = ((TextInputControl) textFieldAdd).getText();
	        arrOfStr = text.split(";");
			if(arrOfStr.length !=4 )
			{
				listview.getItems().clear();
			}
			else
			{
	        Candidat c = new Candidat(arrOfStr[0], Integer.parseInt(arrOfStr[1]),Double.parseDouble(arrOfStr[2]),Integer.parseInt(arrOfStr[3]));        
			listview.getItems().add(c); 
			metier.add(c);
			}*/
			String text = ((TextInputControl) textFieldAdd).getText();
			ParserCandidat pars;
			Candidat c;
			c=ParserCandidat.parse(text);
			listview.getItems().add(c); 
			metier.add(c);
		}	
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}	
	
}
