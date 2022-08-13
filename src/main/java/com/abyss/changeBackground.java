package com.abyss;

import com.Threads.bloodMove;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class changeBackground{
    public void changebg(Pane p, String path) {
        if(path == null)
            p.setBackground(null);
        else {
            Image img = new Image(path);
            BackgroundImage bImg = new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            Background bg = new Background(bImg);
            p.setBackground(bg);
        }
    }

    public void changebg(Region p, String path) {
        if(path == null) {
            p.setBackground(null);
        }
        else {
            Image img = new Image(path);
            BackgroundImage bImg = new BackgroundImage(img,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundRepeat.NO_REPEAT,
                    BackgroundPosition.DEFAULT,
                    BackgroundSize.DEFAULT);
            Background bg = new Background(bImg);
            p.setBackground(bg);
        }
    }

    public void goToPage(AnchorPane p,String path) throws IOException {
        Stage nowStage = (Stage) p.getScene().getWindow();
        nowStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,720);
        nowStage.setScene(scene);
        nowStage.show();
    }

    public void goToPage(Stage nowStage,String path) throws IOException {
        nowStage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,720);
        nowStage.setScene(scene);
        nowStage.show();
    }

    public void setSkillTest(Label x,int times) {
        x.setText(String.valueOf(times));
        if(times >= 10)
            x.setLayoutX(Config.layoutXDoubleNum);
        else
            x.setLayoutX(Config.layoutXSingleNum);
    }

    public void changebgMillis(Region p, String newPath,String oldPath,int millis) {
        changebg(p,newPath);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run(){
                changebg(p,oldPath);
            }
        };
        timer.schedule(task, millis);
    }

    public Stage playVideo(AnchorPane Pane,String path) {
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        Group root = new Group();
        root.getChildren().add(mediaView);

        Scene scene = new Scene(root,1000,720);
        Stage primaryStage = (Stage) Pane.getScene().getWindow();
        primaryStage.close();
        primaryStage.setScene(scene);
        primaryStage.show();
        return primaryStage;
    }

    public void videoToNext(AnchorPane Pane,String videoPath,String pagePath,int millis) {
        Stage nowStage = playVideo(Pane,videoPath);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run(){
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            goToPage(nowStage,pagePath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }
        };
        timer.schedule(task, millis);
    }
}
