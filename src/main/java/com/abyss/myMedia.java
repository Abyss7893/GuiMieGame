package com.abyss;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

public class myMedia {
    private volatile static  myMedia MYMEDIA;
    private MediaPlayer BGM;
    private String  PATH;

    private myMedia(){}

    public static myMedia getInstance() {
        if(MYMEDIA == null) {
            synchronized (myMedia.class) {
                if(MYMEDIA == null)
                    MYMEDIA = new myMedia();
            }
        }
        return MYMEDIA;
    }

    public void play(String s) {
        if(PATH == null || !PATH.equals(s)) {
            PATH = s;
            URL url = getClass().getClassLoader().getResource(PATH);
            assert url != null:"url is NUllPointerException";
            BGM = new MediaPlayer(new Media(url.toString()));
            BGM.setVolume(0.5);
            BGM.setAutoPlay(true);
        }
        if(BGM.isAutoPlay() && PATH.equals(s))
            return;
    }

    public void playLoop(String s){
        if(PATH != null && PATH.equals(s) && BGM.isAutoPlay()){
            BGM.setCycleCount(20);
            return;
        }
        PATH = s;
        URL url = getClass().getClassLoader().getResource(PATH);
        assert url != null:"url is NUllPointerException";
        BGM = new MediaPlayer(new Media(url.toString()));
        BGM.setCycleCount(20);
        BGM.setVolume(0.5);
        BGM.setAutoPlay(true);
    }

    public void stop(){
        if(BGM == null)
            return;
        PATH = null;
        BGM.dispose();
    }

    public void prepare(String s) {
        stop();
        PATH = s;
    }

    public void play() {
        if(PATH == null)
            return;
        URL url = getClass().getClassLoader().getResource(PATH);
        assert url != null:"url is NUllPointerException";
        BGM = new MediaPlayer(new Media(url.toString()));
        BGM.setAutoPlay(true);
    }

    public boolean isPlay(String s) {
        if(PATH == null)
            return false;
        return PATH.equals(s);
    }

}
