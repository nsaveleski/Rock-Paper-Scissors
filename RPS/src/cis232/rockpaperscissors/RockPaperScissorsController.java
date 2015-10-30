package cis232.rockpaperscissors;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class RockPaperScissorsController {

	@FXML
	private Label player1;

	@FXML
	private Label player2;

	@FXML
	private ImageView image1;

	@FXML
	private ImageView image2;
	
	@FXML
    private Label gamePoints;
	
	int point1 = 0;
	int point2 = 0;
	int player1game = 0;
	int player2game = 0;

	String player1Choice = null;
	String player2Choice = null;

	Image rockImage = new Image(getClass().getResourceAsStream("Rock.jpg"));
	Image paperImage = new Image(getClass().getResourceAsStream("Paper.jpg"));
	Image scissorsImage = new Image(getClass().getResourceAsStream("Scissors.jpg"));
	Image initialImage1 = new Image(getClass().getResourceAsStream("maxresdefault.jpg"));
	Image initialImage2 = new Image(getClass().getResourceAsStream("target.jpg"));

	boolean gameEnded = false;

	@FXML
	void keyReleasedListener(KeyEvent event) 
	{
		if(gameEnded)
		{
			return;
		}
		String rock = "rock";
		String paper = "paper";
		String scissors = "scissors";

		String userInput = event.getText();

		if (userInput.equalsIgnoreCase("a")) {
			player1Choice = rock;
		} else if (userInput.equalsIgnoreCase("s")) {
			player1Choice = paper;
		} else if (userInput.equalsIgnoreCase("d")) {
			player1Choice = scissors;
		}

		else if (userInput.equalsIgnoreCase("j")) {
			player2Choice = rock;
		} else if (userInput.equalsIgnoreCase("k")) {
			player2Choice = paper;
		} else if (userInput.equalsIgnoreCase("l")) {
			player2Choice = scissors;
		}

		if (player1Choice != null && player2Choice != null) {
			String result = player1Choice + player2Choice;
			switch (result) {
			case "rockpaper":
				player2.setText("Player 2 WON");
				player1.setText("Player 1 SUCKS");
				image1.setImage(rockImage);
				image2.setImage(paperImage);
				point2++;
				break;

			case "paperrock":
				player1.setText("Player 1 WON");
				player2.setText("Player 2 SUCKS");
				image1.setImage(paperImage);
				image2.setImage(rockImage);
				point1++;
				break;

			case "rockscissors":
				player1.setText("Player 1 WON");
				player2.setText("Player 2 SUCKS");
				image1.setImage(rockImage);
				image2.setImage(scissorsImage);
				point1++;
				break;

			case "scissorsrock":
				player2.setText("Player 2 WON");
				player1.setText("Player 1 SUCKS");
				image1.setImage(scissorsImage);
				image2.setImage(rockImage);
				point2++;
				break;
			case "scissorspaper":
				player1.setText("Player 1 WON");
				player2.setText("Player 2 SUCKS");
				image1.setImage(scissorsImage);
				image2.setImage(paperImage);
				point1++;
				break;

			case "paperscissors":
				player2.setText("Player 2 WON");
				player1.setText("Player 1 SUCKS");
				image1.setImage(paperImage);
				image2.setImage(scissorsImage);
				point2++;
				break;
			}
			gameEnded = true;
		}
	}
	
	public void newGameListener()
	{
		player1Choice = null;
		player2Choice = null;
		
		image1.setImage(initialImage1);
		image2.setImage(initialImage2);
		
		if(point1 < point2)
		{
			player1game++;
		}else if(point2 < point1){
			player2game++;
		}
		gameEnded = false;
		
		gamePoints.setText(String.format("Player 1 points: %d  |  Player 2 points: %d", player1game, player2game));
		player1.setText("");
		player2.setText("");
		point1 = 0;
		point2 = 0;
	}
}

