package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ConfigJfx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	
	private AnnotationConfigApplicationContext context;
	
	@Override
	public void stop(){ context.close(); }
	
	@Override
	public void start(Stage primaryStage) {
	
		try {
			context = new AnnotationConfigApplicationContext(ConfigJfx.class);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ui.fxml"));
			Pane root = (Pane)loader.load();
			Scene scene = new Scene(root,500,300);
			primaryStage.setScene(scene);
			primaryStage.setTitle("JavaFx Spring");
			Control top = loader.getController();
			context.getAutowireCapableBeanFactory().autowireBean(top);
			primaryStage.show();
			} catch(Exception e) {
			e.printStackTrace();
			}
		}
	
	public static void main(String[] args){
		Application.launch(args);
	}
}
