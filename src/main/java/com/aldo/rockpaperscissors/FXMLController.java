package com.aldo.rockpaperscissors;

import com.aldo.rockpaperscissors.gameEngine.Game;
import com.aldo.rockpaperscissors.gameEngine.GameResultObserver;
import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import com.aldo.rockpaperscissors.gameConfiguration.Weapons;
import com.aldo.rockpaperscissors.gameExecution.GameInitializer;
import com.aldo.rockpaperscissors.gameExecution.GameRunner;
import com.aldo.rockpaperscissors.gameExecution.MovePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FXMLController implements Initializable, GameResultObserver, MovePicker {

    private Weapons lastPlayerMove;
    private Game game;
    private GameRunner aiGame;

    @FXML
    private TitledPane pnlHuman;

    @FXML
    private TitledPane pnlAi;

    @FXML
    private TitledPane pnlAi2;

    @FXML
    private TitledPane pnlResult;

    @FXML
    private Label lblResult;

    @FXML
    private Label lblPlayer1Play;

    @FXML
    private Label lblPlayer2Play;

    @FXML
    private Label lblPlayer1;

    @FXML
    private Label lblPlayer2;

    @FXML
    private Label lblDraw;

    @FXML
    private ImageView imgPlayer1;

    @FXML
    private ImageView imgPlayer2;
    
    public FXMLController(){
        game = GameInitializer.humanGameExecution(this, this, this::updatePlayer1, this::updatePlayer2, this::updateDraws);
        aiGame = GameInitializer.aiGameExecution(this, this::updatePlayer1, this::updatePlayer2, this::updateDraws);
    }

    @FXML
    private void startNewGame(ActionEvent event) {
        reset();
        game = GameInitializer.humanGameExecution(this, this, this::updatePlayer1, this::updatePlayer2, this::updateDraws);
        System.out.println("Start New Game");
        turnOff(pnlAi);
        turnOn(pnlHuman);
        turnOn(pnlAi2);
        turnOn(pnlResult);
    }

    @FXML
    private void startNewAiGame(ActionEvent event) {
        reset();
        aiGame = GameInitializer.aiGameExecution(this, this::updatePlayer1, this::updatePlayer2, this::updateDraws);


        turnOff(pnlHuman);
        turnOn(pnlAi);
        turnOn(pnlAi2);
        turnOn(pnlResult);
    }

    @FXML
    private void playRock(ActionEvent event) {
        lastPlayerMove = Weapons.ROCK;
        game.run();
    }

    @FXML
    private void playPaper(ActionEvent event) {
        lastPlayerMove = Weapons.PAPER;
        game.run();
    }

    @FXML
    private void playScissors(ActionEvent event) {
        lastPlayerMove = Weapons.SCISSORS;
        game.run();
    }

    @FXML
    private void playAiVsAi(ActionEvent event) {
        toggleAiGame();
    }

    private void toggleAiGame() {
        aiGame.toggle();
    }

    @Override
    public void draw(int w1, int w2) {
        Platform.runLater(() -> showResult(w1, w2, "DRAW"));
    }

    @Override
    public void player1Wins(int w1, int w2) {
        Platform.runLater(() -> showResult(w1, w2, "player1 WINS"));
    }

    @Override
    public void player2Wins(int w1, int w2) {
        Platform.runLater(() -> showResult(w1, w2, "player2 WINS"));
    }

    @Override
    public int pickMove() {
        return lastPlayerMove.getPosition();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainApp.addAppCloseObserver(() -> aiGame.stop());
    }

    private void showResult(int w1, int w2, String result) {
        Weapons weapon1 = GameConfiguration.retrieveMove(w1);
        Weapons weapon2 = GameConfiguration.retrieveMove(w2);

        lblPlayer1Play.setText(String.format("Player1 played: %s", weapon1.name()));
        lblPlayer2Play.setText(String.format("Player2 played: %s", weapon2.name()));

        lblResult.setText(String.format("Game Result: %s", result));

        imgPlayer1.setImage(new Image(weapon1.getImageUrl()));
        imgPlayer2.setImage(new Image(weapon2.getImageUrl()));
    }

    private void updatePlayer1(int playerPoints) {
        Platform.runLater(() -> lblPlayer1.setText(String.format("Player1: %d", playerPoints)));
    }

    private void updatePlayer2(int playerPoints) {
        Platform.runLater(() -> lblPlayer2.setText(String.format("Player2: %d", playerPoints)));
    }

    private void updateDraws(int draws) {
        Platform.runLater(() -> lblDraw.setText(String.format("Draws: %d", draws)));
    }

    private void reset() {
        aiGame.stop();
        lblResult.setText("Game Result:");
        lblPlayer1Play.setText("Player1 played:");
        lblPlayer2Play.setText("Player2 played:");
        lblPlayer1.setText("Player1:");
        lblPlayer2.setText("Player2:");
        lblDraw.setText("Draws:");
        imgPlayer1.setImage(new Image("images/Unknown.png"));
        imgPlayer2.setImage(new Image("images/Unknown.png"));
    }

    private void turnOff(Control control) {
        control.setManaged(false);
        control.setVisible(false);
    }

    private void turnOn(Control control) {
        control.setManaged(true);
        control.setVisible(true);
    }
}
