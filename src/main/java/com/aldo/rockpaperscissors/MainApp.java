package com.aldo.rockpaperscissors;

import java.util.ArrayList;
import java.util.Collection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    
    private static Collection<AppCloseObserver> appCloseObservers = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Rock Paper Scissors");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        System.out.println("Stage is closing");
        appCloseObservers.forEach(o -> o.onClose());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static void addAppCloseObserver(AppCloseObserver observer){
        appCloseObservers.add(observer);
    }

}
