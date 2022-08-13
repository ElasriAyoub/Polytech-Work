package sport.application;

import org.springframework.beans.factory.annotation.Autowired;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sport.entites.ChoixEtudiant;
import sport.metier.IMetierSport;

public class Controller {
	
	
	@FXML
	TextField textFieldCapa;
	@FXML
	TextField textFieldSport;
	@FXML
	ListView<ChoixEtudiant> listview;	
	
	@FXML
	private void initialize(){ // méthode d'initialisation
	
		this.textFieldCapa.setText("15,20,20,20,15");
		this.textFieldSport.setText("2");
		
	}
	
	@FXML
	void OnSetCapa(ActionEvent e)
	{ 
		System.out.println("Click sur set capa");
		System.out.println("Valeur du textfield="+this.textFieldCapa.getText());		
	}
	
	@FXML
	void OnGetBySport(ActionEvent e)
	{ 
		
		System.out.println("Click sur get by sport");
		System.out.println("Valeur du textfield="+this.textFieldSport.getText());
		
	}
	
	
}
