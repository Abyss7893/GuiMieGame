package com.UI;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.dataBase;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class loadingController extends changeBackground {

    @FXML
    private AnchorPane Pane;
    @FXML
    private StackPane btn;

    @FXML
    void access(MouseEvent event) throws IOException {
        transform(dataBase.selectedState);
    }

    @FXML
    void initialize() throws IOException, InterruptedException {
        assert Pane != null : "fx:id=\"Pane\" was not injected: check your FXML file 'helloLoading.fxml'.";
        Random t = new Random();
        Timer timer = new Timer();
        myMedia bgm = myMedia.getInstance();
        bgm.stop();
        long times = 1000 + t.nextLong(1000);
        TimerTask task = new TimerTask() {
            public void run(){
                changebg(Pane,"background/Loaded.png");
                btn.setVisible(true);
            }
        };
        timer.schedule(task, times);
    }

    void transform(int state) throws IOException {
        if(state == 1)
            goToPage(Pane, Config.pageLEVEL1);
        else
            goToPage(Pane,Config.pageAttack);
    }
}
