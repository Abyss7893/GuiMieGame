package com.UI;

import com.Threads.bloodMove;
import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class startChapterController extends changeBackground {

    private myMedia bgm;
    @FXML
    private StackPane btn2;
    @FXML
    private StackPane btn3;

    @FXML
    private StackPane btn1;

    @FXML
    private AnchorPane Pane;

    @FXML
    void showImageCh(MouseEvent event) {
        String path = null;
        if(event.getSource().equals(btn1)) {
            path = "background/chapter/chapter1.png";
            bgm.play(Config.mediaCh1);
        }
        else if(event.getSource().equals(btn3)) {
            path = "background/chapter/chapter3.png";
            bgm.play(Config.mediaCh3);
        }
        else {
            path = "background/chapter/chapter2.png";
            bgm.play(Config.mediaCh2);
        }
        changebg(Pane, path);
    }

    @FXML
    void showCh0(MouseEvent event) {
        changebg(Pane,"background/chapter/chapter0.png");
    }

    @FXML
    void NoNext(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/NoRushing.fxml"));
        Parent root = fxmlLoader.load();
        SubScene subscene = new SubScene(root,400,350);
        subscene.setLayoutX(300);
        subscene.setLayoutY(250);
        Pane.getChildren().addAll(subscene);
    }

    @FXML
    void NextSection(MouseEvent event) throws IOException {
        bgm.stop();
        if(dataBase.isProcessFirst) {
            dataBase.isProcessFirst = false;
            videoToNext(Pane,Config.videoPrimary,Config.pageSection,70000);
        }
        else
            goToPage(Pane,Config.pageSection);
    }

    @FXML
    void initialize() {
        bgm = myMedia.getInstance();
        if(bgm.isPlay(Config.mediaSection))
            bgm.stop();
    }
}
