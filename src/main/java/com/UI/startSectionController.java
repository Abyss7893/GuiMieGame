package com.UI;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class startSectionController extends changeBackground {

    private StackPane[] btn = new StackPane[11];
    @FXML
    private StackPane returnBtn;

    @FXML
    private AnchorPane Pane;

    @FXML
    private StackPane btn8;

    @FXML
    private StackPane btn9;

    @FXML
    private StackPane btn6;

    @FXML
    private StackPane btn7;

    @FXML
    private StackPane btn4;

    @FXML
    private StackPane btn5;

    @FXML
    private StackPane btn2;

    @FXML
    private StackPane btn3;

    @FXML
    private StackPane btn1;

    @FXML
    void onShowRightAnim(MouseEvent event) throws IOException {
        for(int i = 1; i <= 5;i++)
            if(event.getSource().equals(btn[i])) {
                dataBase.selectedState = i;
            }
        goToPage(Pane,"/Fxml/helloRightSubSection.fxml");
    }

    @FXML
    void onShowLeftAnim(MouseEvent event) throws IOException {
        for(int i = 6; i <= 9;i++)
            if(event.getSource().equals(btn[i])) {
                dataBase.selectedState = i;
            }
        goToPage(Pane,"/Fxml/helloLeftSubSection.fxml");
    }

    @FXML
    void returnChapter(MouseEvent event) throws IOException {
        goToPage(Pane,Config.pageChapter);
    }

    @FXML
    void initialize() {
        myMedia bgm = myMedia.getInstance();
        bgm.playLoop(Config.mediaSection);

        btn[1] = btn1; btn[2] = btn2; btn[3] = btn3; btn[4] = btn4; btn[5] = btn5;
        btn[6] = btn6; btn[7] = btn7; btn[8] = btn8; btn[9] = btn9;

        dataBase.initSkillsChoosing();
    }
}
