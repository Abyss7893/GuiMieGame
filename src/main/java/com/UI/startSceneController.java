package com.UI;

import com.abyss.Config;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;
public class startSceneController {

    private myMedia bgm;

    @FXML
    private StackPane startButton;

    @FXML
    void nextChapterScene(MouseEvent event) throws IOException {
        bgm.stop();
        Stage nowStage = (Stage) startButton.getScene().getWindow();
        nowStage.close();
        bgm.stop();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/helloChapter.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,720);
        nowStage.setScene(scene);
        nowStage.show();
    }

    @FXML
    void initialize(){
        assert startButton != null : "fx:id=\"startButton\" was not injected: check your FXML file 'helloStart.fxml'.";
        bgm = myMedia.getInstance();
        bgm.playLoop(Config.mediaStartGame);
    }
}
