package com.abyss;

public interface Config {

    //basic attack attribute
    int basicTanLife = 500;
    int basicTanAtk = 85;
    int basicTanAgility = 300;
    int stateGainLife = 25;
    int stateGainAtk = 8;
    int stateGainAgility = 15;

    //data for components changing
    double pointLeftBorder = 350;
    double pointRightBorder = 651;
    int layoutXDoubleNum = 26;
    int layoutXSingleNum = 31;
    double bloodInitWidth = 196;
    double bloodRightBorder = 836;

    //path
    String skillOnShowPath = "skills/onShow/";
    String skillLockedPath = "skills/locked/";
    String tanSkillPath = "skills/tan/t";
    String attackBG = "background/attackScene/Scene";

    String mediaCh1 = "audio/Ch1.mp3";
    String mediaCh2 = "audio/Ch2.mp3";
    String mediaCh3 = "audio/Ch3.mp3";

    String musicSuccess = "audio/success.mp3";
    String musicDefeat = "audio/defeat.mp3";
    String mediaStartGame = "audio/startGameBgm.mp3";
    String mediaSuccess = "audio/success.mp3";
    String mediaSection = "audio/SectionAudio.mp3";


    String pageChapter = "/Fxml/helloChapter.fxml";
    String pageSection = "/Fxml/helloSection.fxml";
    String pageLoading = "/Fxml/helloLoading.fxml";
    String pageLEVEL1 = "/Fxml/helloStone.fxml";
    String pageAttack = "/Fxml/helloAtkScene.fxml";

    //videoPath
    String videoPrimary = "src/main/resources/videos/startCh1.mp4";
    String videoZhuShi = "src/main/resources/videos/zhuShi.mp4";
    String videoEnd = "src/main/resources/videos/end.mp4";
}
