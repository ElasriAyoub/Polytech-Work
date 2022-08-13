package application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import pta.sagi.concours.dao.DaoConcoursJSON;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;
public class ControlDaoConcours {

	@FXML
	ListView<Candidat> listview;
	@FXML
	TextField textbSMin;	
	@FXML
	TextField textbSMax;	
	@FXML
	void initialize(){
	items= FXCollections.observableArrayList();
	listview.setItems(items);	
	}
	
	private IDaoConcours dao;
	private ObservableList<Candidat> items;
	
	public ControlDaoConcours()
	{
		dao=new DaoConcoursJSON("dataJ3.json");
	}
	
	
	
	@FXML
	void OnByRegion(ActionEvent e)
	{
		try {
			int region =Integer.parseInt(textbSMax.getText());		
			items.clear();
			Candidat[] candidats = dao.getCandidats(region);
			items.addAll(candidats);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}
	@FXML
	void OnByScore(ActionEvent e)
	{
		try {
		double smin=Double.parseDouble(textbSMin.getText());
		double smax=Double.parseDouble(textbSMax.getText());		
		items.clear();
		Candidat[] candidats = dao.getCandidatsIn(smin,smax);
		items.addAll(candidats);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
	@FXML
	void OnDel(ActionEvent e)
	{
		int idx=this.listview.getSelectionModel().getSelectedIndex();
		if(idx!=-1)
		{
			Candidat c=items.get(idx);
			dao.delCandidat(c.getNumero());
			items.remove(idx);
		}
	}
}
