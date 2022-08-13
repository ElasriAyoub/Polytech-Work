package application;

import org.springframework.beans.factory.annotation.Autowired;

import coucheMetier.IMetier;
import entites.Personne;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Control
{
	@Autowired
	IMetier metier; // référence sur le bean Metier
	@FXML
	ListView<Personne> listview;
	@FXML
	void OnMajeurs(ActionEvent e){
		Personne[] tab=metier.getMajeurs();
		listview.getItems().clear();
		for(Personne p:tab) listview.getItems().add(p);
	}
	@FXML
	void OnUpdate(ActionEvent e){
		metier.updateAge();
		listview.getItems().clear();
	}
}
