package com.UI;

import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class specialBookController extends changeBackground {
    @FXML
    private AnchorPane skill1;

    @FXML
    private AnchorPane skill2;

    @FXML
    private StackPane backBtn;

    @FXML
    private StackPane atkBtn;

    @FXML
    void processAtk(MouseEvent event) throws IOException {
        dataBase.getSkillsChoosing(1);
        dataBase.getSkillsChoosing(2);
        goToPage(skill1,Config.pageLoading);
    }

    @FXML
    void returnSection(MouseEvent event) throws IOException {
        goToPage(skill1,Config.pageSection);
    }

    @FXML
    void initialize() {
        String name = null;
        if(dataBase.selectedState == 7)
            name = "zhu";
        else if(dataBase.selectedState == 8)
            name = "shan";
        changebg(skill1, Config.skillOnShowPath + name + "1.png");
        changebg(skill2,Config.skillOnShowPath + name + "2.png");
    }
}
