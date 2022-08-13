package com.UI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class NoRushing {

    @FXML
    private StackPane ReturnPre;

    @FXML
    void ReturnChapter(MouseEvent event) throws IOException {
        Stage nowStage = (Stage) ReturnPre.getScene().getWindow();
        nowStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/helloChapter.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,720);
        nowStage.setScene(scene);
        nowStage.show();
    }

}
