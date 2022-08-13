package com.Threads;

import com.abyss.Config;
import com.abyss.dataBase;
import com.abyss.enemyBasicData;
import javafx.application.Platform;
import javafx.scene.layout.Region;

public class bloodMove implements Runnable{
    private volatile Region ownBlood,enemyBlood;
    private double enemyNowLayerX,enemyLength,ownLength;
    private final double enemyNowLife,enemyTargetLife,enemyMaxLife;
    private final double ownNowLife,ownTargetLife,ownMaxLife;


    public bloodMove(Region own,double ownLife,Region enemy,double enemyLife) {
        ownBlood = own;
        enemyBlood = enemy;

        enemyNowLayerX = enemyBlood.getLayoutX();
        enemyLength = enemy.getWidth();
        ownLength = ownBlood.getWidth();

        enemyMaxLife = enemyBasicData.basicLife[dataBase.selectedState];
        enemyTargetLife = enemyLife;
        enemyNowLife = enemyMaxLife * enemyLength / Config.bloodInitWidth;

        ownMaxLife = dataBase.maxOwnLife;
        ownTargetLife = ownLife;
        ownNowLife = ownMaxLife * ownLength / Config.bloodInitWidth;
    }

    @Override
    public  synchronized void run() {
        double enemySlice = (enemyNowLife - enemyTargetLife) * Config.bloodInitWidth / (double)(enemyMaxLife * 20);
        double ownSlice = (ownNowLife - ownTargetLife) * Config.bloodInitWidth / (double)(ownMaxLife * 20);

        for(int i = 0; i < 20; i++) {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    enemyNowLayerX = enemyNowLayerX + enemySlice;
                    enemyLength = Config.bloodRightBorder - enemyNowLayerX;

                    ownLength = ownLength - ownSlice;
                    ownBlood.setPrefWidth(ownLength);
                    enemyBlood.setLayoutX(enemyNowLayerX);
                    enemyBlood.setPrefWidth(enemyLength);
                }
            });
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
