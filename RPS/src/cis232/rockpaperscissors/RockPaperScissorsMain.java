package cis232.rockpaperscissors;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RockPaperScissorsMain extends Application 
{
	@Override
	public void start(Stage stage) throws Exception
	{
		Parent parent = FXMLLoader.load(getClass().getResource("rockpaperscissors.fxml"));
		
		//Setup scene
		Scene scene = new Scene(parent);
		
		//Setup stage
		stage.setTitle("Rock Paper Scissors");
		stage.setScene(scene);
		stage.show();
	}
	public static void main(String[] args)
	{
		launch(args);
	}

}
