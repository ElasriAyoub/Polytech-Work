package exec;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigSpring;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import pta.sagi.concours.dao.IDaoConcours;
import pta.sagi.concours.entites.Candidat;
import pta.sagi.concours.ui.IUserInterfaceConcours;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class ExecConcours extends Application {

	private AnnotationConfigApplicationContext context;
	
	public void stop() {
		context.close();
	}
	
	public void start(Stage primaryStage) {
		try {
			context= new AnnotationConfigApplicationContext(ConfigSpring.class);
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("interface.fxml"));
			Pane root =(Pane)loader.load();
			Scene scene = new Scene(root,500,400);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Concours");
			Controller ctrl = loader.getController();
			context.getAutowireCapableBeanFactory().autowireBean(ctrl);;
			primaryStage.show();
		}
		catch(Exception e) {e.printStackTrace();}
		}
	public static void main(String[] args) { launch(args);}
}
