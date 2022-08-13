package com.Threads;

import com.abyss.Config;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class pointerMove implements Runnable{
    private final AnchorPane pointer;
    private final AnchorPane block;
    private double posX,leftBorder,length,val;
    private boolean pointAttachRight = false;
    private  boolean blockAttachRight = false;

    private Random Rmaker;

    public pointerMove(AnchorPane p,AnchorPane b) {
        block = b;
        pointer = p;
        posX = pointer.getLayoutX();
        leftBorder = block.getLayoutX();
        length = block.getPrefWidth();
        Rmaker = new Random();
        val = Rmaker.nextDouble(5) + 3;
    }

    @Override
    public synchronized void run() {
        while(true) {
            if(!pointAttachRight){
                posX += 10;
                pointer.setLayoutX(posX);
                if(posX + 18 >= Config.pointRightBorder)
                    pointAttachRight = true;

            }
            else {
                posX -= 10;
                pointer.setLayoutX(posX);
                if(posX + 18 <= Config.pointLeftBorder)
                    pointAttachRight = false;
            }

            if(!blockAttachRight) {
                leftBorder += val;
                block.setLayoutX(leftBorder);
                if(leftBorder + length >= Config.pointRightBorder){
                    if(length >= 20) {
                        length -= 4;
                        block.setPrefWidth(length);
                    }
                    blockAttachRight = true;
                    val = Rmaker.nextDouble(5) + 3;
                }
            }
            else {
                leftBorder -= val;
                block.setLayoutX(leftBorder);
                if(leftBorder <= Config.pointLeftBorder + 2) {
                    if(length >= 20) {
                        length -= 4;
                        block.setPrefWidth(length);
                    }
                    blockAttachRight = false;
                    val = Rmaker.nextDouble(5) + 3;
                }
            }
            try {
                block.setPrefWidth(length);
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
