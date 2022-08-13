package com.UI;

import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class rightSubSectionController extends changeBackground {
    @FXML
    private StackPane atkButton;
    @FXML
    private AnchorPane rightSub;
    @FXML
    private StackPane exitButton;

    @FXML
    void processAttack(MouseEvent event) throws IOException {
        if(dataBase.selectedState > dataBase.maxState)
            return;
        if(dataBase.selectedState == 1) {
            goToPage(rightSub, Config.pageLoading);
        }
        else if(dataBase.selectedState == 7 || dataBase.selectedState == 8)
            goToPage(rightSub,"/Fxml/helloSpecialBook.fxml");
        else
            goToPage(rightSub,"/Fxml/helloSkillBook.fxml");
    }

    @FXML
    void entered(MouseEvent event) {
        if(dataBase.selectedState <= dataBase.maxState)
            changebg(atkButton,"icon/section/attackBegin2.png");
    }

    @FXML
    void exited(MouseEvent event) {
        if(dataBase.selectedState <= dataBase.maxState)
            changebg(atkButton,"icon/section/attackBegin1.png");
    }

    @FXML
    void onShowSection(MouseEvent event) throws IOException {
        goToPage(rightSub, Config.pageSection);
    }

    @FXML
    void initialize() {
        if(dataBase.selectedState > dataBase.maxState)
            changebg(atkButton, "icon/section/lockedBegin.png");
        else
            changebg(atkButton, "icon/section/attackBegin1.png");
        String path = "background/subSection/" + dataBase.selectedState + ".png";
        changebg(rightSub,path);
    }

}
