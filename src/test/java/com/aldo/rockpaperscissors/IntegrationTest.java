package com.aldo.rockpaperscissors;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hamcrest.Matchers;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import org.testfx.service.query.NodeQuery;
import org.testfx.service.query.impl.NodeQueryUtils;

public class IntegrationTest extends ApplicationTest{
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("Rock Paper Scissors");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void humanGameScenario() {
        // given:
        clickOn("#newGame");        
        
        clickOn("#btnPaper");
        clickOn("#btnRock");
        clickOn("#btnScissors");
        
        verifyThat("#pnlAi2", NodeQueryUtils.isVisible());
        verifyThat("#pnlHuman", NodeQueryUtils.isVisible());
        verifyThat("#pnlResult", NodeQueryUtils.isVisible());
    }
    
    @Test
    public void aiGameScenario() {
        // given:
        clickOn("#newAiGame");        
        
        clickOn("#btnAiVsAi");
        
        clickOn("#btnAiVsAi");
        
        verifyThat("#pnlAi", NodeQueryUtils.isVisible());
        verifyThat("#pnlAi2", NodeQueryUtils.isVisible());
        verifyThat("#pnlResult", NodeQueryUtils.isVisible());
    }
}
