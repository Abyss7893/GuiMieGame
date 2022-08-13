package com.UI;

import com.abyss.Config;
import com.abyss.dataBase;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class successStoneController {

    private myMedia bgm;
    @FXML
    private AnchorPane Pane;
    @FXML
    void retunSection(MouseEvent event) throws IOException {
        Stage nowStage = (Stage) Pane.getScene().getWindow();
        nowStage.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/helloSection.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,1000,720);
        nowStage.setScene(scene);
        nowStage.show();
    }

    @FXML
    void initialize() {
        bgm = myMedia.getInstance();
        dataBase.maxState = Math.max(2,dataBase.maxState);
        bgm.play(Config.mediaSuccess);
    }
}
