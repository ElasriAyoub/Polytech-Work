package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigSpring;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Exec extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(ConfigSpring.class);
			FXMLLoader loader  = new FXMLLoader(getClass().getResource("intter.fxml"));
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

}
