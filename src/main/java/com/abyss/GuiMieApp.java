package com.abyss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GuiMieApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/helloStart.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,720);
        dataBase.init();

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
