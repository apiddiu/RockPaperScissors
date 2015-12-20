package com.aldo.rockpaperscissors;

import com.aldo.rockpaperscissors.game.Game;
import com.aldo.rockpaperscissors.game.GameResultListener;
import com.aldo.rockpaperscissors.gameConfiguration.GameConfiguration;
import com.aldo.rockpaperscissors.gameConfiguration.Weapons;
import com.aldo.rockpaperscissors.gameExecution.GameInitializer;
import com.aldo.rockpaperscissors.gameExecution.MovePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class FXMLController implements Initializable, GameResultListener, MovePicker {

    private Weapons lastPlayerMove;
    private Game game;

    @FXML
    private Label lblResult;

    @FXML
    private void startNewGame(ActionEvent event) {
        game = GameInitializer.humanGameExecution(this, this);
        System.out.println("Start New Game");
    }

    @FXML
    private void startNewAiGame(ActionEvent event) {
        game = GameInitializer.aiGameExecution(this);
        System.out.println("Start New AI Game");
    }

    @FXML
    private void playRock(ActionEvent event) {
        lastPlayerMove = Weapons.ROCK;
        System.out.println("Playing ROCK");
        game.run();
    }

    @FXML
    private void playPaper(ActionEvent event) {
        lastPlayerMove = Weapons.PAPER;
        System.out.println("Playing PAPER");
        game.run();
    }

    @FXML
    private void playScissors(ActionEvent event) {
        lastPlayerMove = Weapons.SCISSORS;
        System.out.println("Playing SCISSORS");
        game.run();
    }

    @Override
    public void draw(int w1, int w2) {
        showResult(w1, w2, "DRAW");
    }

    @Override
    public void player1Wins(int w1, int w2) {
        showResult(w1, w2, "player1 WINS");
    }

    @Override
    public void player2Wins(int w1, int w2) {
        showResult(w1, w2, "player2 WINS");
    }

    @Override
    public int pickMove() {
        return lastPlayerMove.getPosition();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void showResult(int w1, int w2, String result) {
        lblResult.setVisible(false);
        slow();
        lblResult.setText(String.format("Player1 played: %s - Player2 played %s - Result: %s",
                GameConfiguration.retrieveMove(w1).name(),
                GameConfiguration.retrieveMove(w2).name(),
                result));
        lblResult.setVisible(true);
    }

    private void slow() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException ex) {
        }
    }
}
