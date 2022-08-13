package com.Threads;

import com.abyss.changeBackground;
import javafx.scene.layout.*;

import java.util.Timer;
import java.util.TimerTask;

public class actorAnimEffectShow extends changeBackground implements Runnable{
    private final AnchorPane scene;
    private final String NEW;
    private final long times;

    public actorAnimEffectShow(AnchorPane s, String NEW , long milliTimes) {
        scene = s;
        this.NEW = NEW;
        this.times = milliTimes;
    }

    @Override
    public void run() {
        if(NEW == null)
            return;
        changebg(scene,NEW);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run(){
                changebg(scene,null);
            }
        };
        timer.schedule(task, times);
    }
}
