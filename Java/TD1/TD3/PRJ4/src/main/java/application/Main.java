package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
		@Override
		public void start(Stage primaryStage) {
			try { String form="formDaoConcours.fxml";
			primaryStage.setTitle(form);
			Pane root = (Pane)FXMLLoader.load(getClass().getResource(form));
			Scene scene = new Scene(root,400,300);
			primaryStage.setScene(scene);
			primaryStage.show();
			} catch(Exception e) {e.printStackTrace();}
		}
		
		public static void main(String[] args) 
		{ 
			launch(args); 
		}
}