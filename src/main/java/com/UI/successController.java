package com.UI;

import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.ObjectInputFilter;

public class successController extends changeBackground {

    @FXML
    private AnchorPane bg;
    private myMedia bgm;

    @FXML
    void returnSection(MouseEvent event) throws IOException {
        if(dataBase.isZhuShi && dataBase.selectedState == 3 &&dataBase.whoWin == 1) {
            dataBase.isZhuShi = false;
            bgm.stop();
            videoToNext(bg,Config.videoZhuShi,Config.pageSection,55000);
        }
        else if(dataBase.isEnding && dataBase.selectedState == 9 && dataBase.whoWin == 1) {
            dataBase.isEnding = false;
            bgm.stop();
            videoToNext(bg,Config.videoEnd,Config.pageSection,190000);
        }
        else
            goToPage(bg, Config.pageSection);
    }

    @FXML
    void initialize() {
        bgm = myMedia.getInstance();
        if(dataBase.whoWin == 1) {
            changebg(bg,"background/successMi.gif");
            bgm.stop();
            bgm.play(Config.musicSuccess);
            if(dataBase.selectedState == dataBase.maxState)
                dataBase.getNewSkill();
            dataBase.maxState = Math.min(9,dataBase.maxState + 1);
        }
        else {
            changebg(bg,"background/defeatShan.gif");
            bgm.stop();
            bgm.play(Config.musicDefeat);
        }

    }

}
