package sport.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sport.config.ConfigSport;


public class Main extends Application {

	private AnnotationConfigApplicationContext context;
	
	@Override
	public void stop(){ context.close();}
	
	@Override
	public void start(Stage primaryStage) {
	try {
	context = new AnnotationConfigApplicationContext(ConfigSport.class);
	
	FXMLLoader loader = new FXMLLoader(getClass().getResource("uiSport.fxml"));
	Pane root = (Pane)loader.load();
	Scene scene = new Scene(root,420,400);
	primaryStage.setScene(scene);
	primaryStage.setTitle("Sport");
	
	Controller ctrl = loader.getController();
	context.getAutowireCapableBeanFactory().autowireBean(ctrl);
	
	primaryStage.show();
	} catch(Exception e) { e.printStackTrace(); }
	}
	public static void main(String[] args)
	{
		Application.launch(args); 
	}
}
