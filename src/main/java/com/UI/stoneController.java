package com.UI;

import com.Threads.pointerMove;
import com.abyss.Config;
import com.abyss.changeBackground;
import com.abyss.myMedia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import java.io.IOException;
import java.net.URL;

public class stoneController extends changeBackground {
    private myMedia bgm;
    private URL url;
    @FXML
    private AnchorPane own;
    @FXML
    private AnchorPane block;
    @FXML
    private AnchorPane Pane;
    @FXML
    private AnchorPane movePointer;

    private  int nowStoneCondition;

    private String PATH = "icon/stone/stone";
    @FXML
    private AnchorPane stoneImg;

    private  Thread pointerController;


    @FXML
    void initialize() throws InterruptedException {
        assert movePointer != null : "fx:id=\"movePointer\" was not injected: check your FXML file 'helloStone.fxml'.";
        nowStoneCondition = 1;
        bgm = myMedia.getInstance();
        bgm.prepare("audio/stoneCrack.mp3");
        pointerController = new Thread(new pointerMove(movePointer,block));
        pointerController.start();
    }

    @FXML
    void attackStone(MouseEvent event) throws InterruptedException, IOException {
        double pointX = movePointer.getLayoutX() + 18;
        double minX = block.getLayoutX();
        double len = block.getPrefWidth();
        if(minX <= pointX && minX + len >= pointX) {
            nowStoneCondition += 1;
            bgm.play();
            if(nowStoneCondition % 2 == 1)
                return;
            String newPath = PATH + String.valueOf(nowStoneCondition) + ".png".toString();
            changebg(stoneImg, newPath);

            if(nowStoneCondition >= 8){
                Thread.sleep(400);
                stopThread();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/helloSuccessStone.fxml"));
                Parent root = fxmlLoader.load();
                SubScene subscene = new SubScene(root,1000,720);
                Pane.getChildren().addAll(subscene);
            }
        }

    }

    @FXML
    void showActorAtk(MouseEvent event) {
        /*Thread p = new Thread(new componentMove(own,"role/own/tan2.png","role/own/tan1.gif",1000));
        p.start();*/
        changebg(own,"role/own/tan2.png");
    }

    @FXML
    void showActorSilent(MouseEvent event) {
        changebg(own,"role/own/tan1.gif");
    }

    @FXML
    void backToSection(MouseEvent event) throws IOException {
        stopThread();
        goToPage(block, Config.pageSection);
    }

    void stopThread() {
        pointerController.interrupt();
    }

}
