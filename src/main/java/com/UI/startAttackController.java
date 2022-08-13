package com.UI;

import com.Threads.actorAnimEffectShow;
import com.Threads.bloodMove;
import com.abyss.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.application.Platform;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class startAttackController extends changeBackground {
    private int round = 0,hurt,cure;
    private boolean isAttacks = true,sjsbaaaaa = false;
    private final Region[] button = new Region[4];
    private final Label[] lab = new Label[4];
    private actor ownActor,enemyActor;
    private int delay;
    private myMedia bgm;
    @FXML
    private Region ownWeakness,ownDebarment,enemyWeakness,enemyDebarment;
    @FXML
    private Label agiNum,atkNum,enemyShow,ownShow,sjsb,sjnb,sjsbsb;
    @FXML
    private AnchorPane bg,animEffectPane;
    @FXML
    private Region ownBlood,enemyBlood;
    @FXML
    private AnchorPane own,enemy;
    @FXML
    private Label ownLife,enemyLife;
    @FXML
    private AnchorPane ownIcon,enemyIcon;
    @FXML
    private Label lab1,lab2,lab3,lab4;
    @FXML
    private Region btn1,btn2,btn3,btn4;

    @FXML
    void returnSection(MouseEvent event) throws IOException {
        bgm.stop();
        goToPage(bg, Config.pageSection);
    }

    @FXML
    void restartAtk(MouseEvent event) throws IOException {
        goToPage(bg,Config.pageLoading);
    }

    @FXML
    void btnEntered(MouseEvent event) {
        if(!isAttacks)
            return;
        for(int i = 0; i < 4; i++)
            if (event.getSource().equals(button[i])) {
                if(dataBase.skillsChoosing[i] == -1)
                    return;
                if(ownActor.skill[i].useTimes == 0)
                    return;
                else
                    changebg(button[i],ownActor.skill[i].Img + "1.png");
                break;
            }
    }

    @FXML
    void btnExited(MouseEvent event) {
        for(int i = 0; i < 4; i++)
            if (event.getSource().equals(button[i])) {
                if(dataBase.skillsChoosing[i] == -1)
                    return;
                changebg(button[i],ownActor.skill[i].Img + "0.png");
                changebg(own,ownActor.actorSilentPath);
                break;
            }
    }

    @FXML
    void btnPressed(MouseEvent event) throws IOException {
        //judge which skills user uses and if it will react
        int pos = 0;
        if(!isAttacks)  return;
        for(int i = 0; i < 4; i++)
            if (event.getSource().equals(button[i])) {
                if(dataBase.skillsChoosing[i] == -1 || ownActor.skill[i].useTimes <= 0)
                    return;
                else
                    pos = i;
                break;
            }


        changebg(own,ownActor.actorAttackPath);
        changebg(button[pos], ownActor.skill[pos].Img + "2.png");
        attackAction(ownActor,enemyActor,pos,true);
        updateBlood(ownActor.skill[pos].animationMillis);

        isAttacks = false;
        delay = ownActor.skill[pos].animationMillis + 1100;
        Timer timer = new Timer();
        timer.schedule(new TimerTask(){
            public void run(){
                if(enemyActor.life == 0) {
                    dataBase.whoWin = 1;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                transfer();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    timer.cancel();
                }

                enemyAttack();

                if(ownActor.life == 0) {
                    dataBase.whoWin = -1;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                transfer();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                    timer.cancel();
                }

                if(ownActor.isDebar == 0) {
                    isAttacks = true;
                    updateShowExceptLife();
                    timer.cancel();
                }

            }
        }, delay,delay + 600);//schedule{TimerTask()方法调用，延时执行时间，循环执行时间间隔}

    }


    @FXML
    void initialize() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        button[0] = btn1; button[1] = btn2; button[2] = btn3; button[3] = btn4;
        lab[0] = lab1; lab[1] = lab2; lab[2] = lab3; lab[3] = lab4;

        changebg(bg,Config.attackBG + dataBase.selectedState + ".png");

        ownActor = new actor("OWN");
        enemyActor = new actor("ENEMY");

        //set basic UI components
        changebg(ownIcon, ownActor.actorIcon);
        changebg(enemyIcon, enemyActor.actorIcon);
        changebg(own,ownActor.actorSilentPath);
        changebg(enemy, enemyActor.actorSilentPath);
        atkNum.setText(String.valueOf(ownActor.atk));
        agiNum.setText(String.valueOf(ownActor.agility));
        ownLife.setText(String.valueOf(ownActor.life));
        enemyLife.setText(String.valueOf(enemyActor.life));

        String music = "audio/attackScene" + (int)(dataBase.selectedState / 6) + ".mp3";
        bgm = myMedia.getInstance();
        bgm.playLoop(music);

        //set skill icons
        for(int i = 0; i < 4; i++) {
            if(dataBase.skillsChoosing[i] == -1) {
                lab[i].setVisible(false);
                changebg(button[i],null);
                continue;
            }
            setSkillTest(lab[i],ownActor.skill[i].useTimes);
            changebg(button[i], ownActor.skill[i].Img + "0.png");
        }
        changebg(button[0], ownActor.skill[0].Img + "0.png");

        updateState(ownActor,enemyActor);
    }

    public void updateState(actor own,actor enemy) {
        ownWeakness.setVisible(own.isWeak != 0);
        ownDebarment.setVisible(own.isDebar != 0);
        enemyWeakness.setVisible(enemy.isWeak != 0);
        enemyDebarment.setVisible(enemy.isDebar != 0);
    }

    public void updateShowExceptLife(int pos,boolean isOwn) {
        atkNum.setText(String.valueOf(ownActor.atk));
        agiNum.setText(String.valueOf(ownActor.agility));
        if(isOwn) {
            lab[pos].setText(String.valueOf(ownActor.skill[pos].useTimes));
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    if (ownActor.skill[pos].useTimes <= 10)
                        lab[pos].setLayoutX(Config.layoutXSingleNum);
                }
            });
        }
        updateState(ownActor,enemyActor);
    }

    public void updateShowExceptLife() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                atkNum.setText(String.valueOf(ownActor.atk));
                agiNum.setText(String.valueOf(ownActor.agility));
                updateState(ownActor,enemyActor);
            }
        });
    }

    public void updateOnesCondition(actor p) {
        int temp = p.isWeak;
        p.isWeak = Math.max(p.isWeak - 1, 0);
        p.isDebar = Math.max(p.isDebar - 1, 0);
        if(temp > 0 && p.isWeak == 0)
            p.atk *= 2;
    }

    public void enemyAttack(){
        Random p = new Random();
        int Num = p.nextInt(enemyBasicData.basicSkillNum[dataBase.selectedState]);
        Timer timer = new Timer();
        updateOnesCondition(enemyActor);
        if(enemyActor.life == 0) {
            return;
        }
        if(enemyActor.isDebar > 0) {
            isAttacks = true;
            updateOnesCondition(ownActor);
            updateShowExceptLife();
            return;
        }
        changebgMillis(enemy, enemyActor.actorAttackPath, enemyActor.actorSilentPath, 600);
        attackAction(enemyActor, ownActor, Num,false);
        updateBlood(enemyActor.skill[Num].animationMillis);
        updateOnesCondition(ownActor);
        updateShowExceptLife();
    }

    public void attackAction(actor attack,actor defense,int skillNum,boolean isOwn) {
        Label attackOne = enemyShow,defeatOne = ownShow;
        if(isOwn) {
            attackOne = ownShow;
            defeatOne = enemyShow;
        }
        int temp = attack.atk;
        if(dataBase.selectedState == 8 && skillNum == 0)
            temp = attack.agility;
        hurt = attack.skill[skillNum].attackEnemy(
                temp,
                defense.maxLife,
                defense.life,
                defense.agility,
                round++);
        cure = attack.skill[skillNum].addOwnLife(attack.maxLife,attack.life);
        attack.functionPre(skillNum,defense);
        actorAnimEffectShow anim = new actorAnimEffectShow(animEffectPane,
                attack.skill[skillNum].animationEffects,
                attack.skill[skillNum].animationMillis);
        anim.run();
        defense.life = Math.max(defense.life - Math.max(hurt,0),0);
        attack.life = Math.min(attack.life + cure,attack.maxLife);
        if(hurt >= 0)
            showDamageNumerical(defeatOne,hurt * (-1),attack.skill[skillNum].animationMillis);
        if(cure > 0)
            showDamageNumerical(attackOne,cure,attack.skill[skillNum].animationMillis);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                updateShowExceptLife(skillNum,isOwn);
            }
        });

    }

    public void updateBlood(int millis) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run(){
                        Thread bloodChange = new Thread(new bloodMove(ownBlood, ownActor.life,
                                enemyBlood, enemyActor.life));
                        bloodChange.start();
            }
        };
        timer.schedule(task, millis);
    }

    public void transfer() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/helloSuccess.fxml"));
        Parent root = fxmlLoader.load();
        SubScene subscene = new SubScene(root,1000,720);
        bg.getChildren().addAll(subscene);
    }

    public void showDamageNumerical(Label p,int num,int millis) {
        String damageNumerical;

        if(num < 0) {
            p.setTextFill(Color.RED);
            if(num * -1 == (int)(ownActor.atk * 1.2)) {
                damageNumerical = String.valueOf(-(int)(ownActor.atk * 0.15) );
                sjsbaaaaa = true;
            }
            else
                damageNumerical = String.valueOf(num);
        }
        else if(num == 0) {
            p.setTextFill(Color.WHITE);
            damageNumerical = "Miss";
        }
        else {
            p.setTextFill(Color.GREEN);
            damageNumerical = "+" + num;
        }
        Timer timers = new Timer();
        TimerTask tasked = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        enemyLife.setText(String.valueOf(enemyActor.life));
                        ownLife.setText(String.valueOf(ownActor.life));
                        if(sjsbaaaaa) {
                            String s2 = String.valueOf(-(int)(ownActor.atk * 0.25));
                            String s3 = String.valueOf(-(int)(ownActor.atk * 0.35));
                            String s4 = String.valueOf(-(int)(ownActor.atk * 0.45));
                            sjsb.setText(s2);
                            sjnb.setText(s3);
                            sjsbsb.setText(s4);
                            sjsb.setVisible(true);
                            sjsbsb.setVisible(true);
                            sjnb.setVisible(true);
                        }
                        p.setText(damageNumerical);
                        p.setVisible(true);
                        Timer timer = new Timer();
                        TimerTask task = new TimerTask() {
                            public void run(){
                                sjsb.setVisible(false);
                                sjsbsb.setVisible(false);
                                sjnb.setVisible(false);
                                p.setVisible(false);
                                sjsbaaaaa = false;
                            }
                        };
                        timer.schedule(task, 600);
                    }
                });
            }
        };timers.schedule(tasked,millis);
    }
}


/*
    ☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭
    伟大的无产阶级革命家毛泽东同志永垂不朽！ 马克思主义光辉保佑代码永无Bug！
                                         ____
                                __mmmm@@@@@@@@@@mmms__.
                         _____g@@@@@@@@@@@@@@@@@@@@@@@@@m_
                    gW@@@@@@@@@@@@@@@@@@AM@@@@@@@@@@@@@@@@Ws_
                 ,mW@@@@@@@@@@@A*~~`        ~~***@@@@@@@@@@@@@s.
                 @@@@@@@@@@@*~`                   V@@@@@@@@@@@@@Ws
               ,W@@@@@@@@@~                        8@@@@@@@@@@@@@@W
               ]@@@@@@@@A!                         8@@@@@@@@@@@@@@@|
                @@@@@@@@`                         ,@@@@@@@@@@@@@@@@@.
                4@@@@@A!                          !@@@@@@@@@@@@@@@@@W
               'M@@@@W.                           @@@@@@@@@@@@@@@@@f
                 !M@@@A****s.      imzmm==         'M@@@@@@@@@@@@@@A
                  '@@@               mY~            '@@@@@@@@@@@@@@`
                  i@Pd@@Wz-. @W     d@@@m_s.         !@@@@@@@@@@@@f
                  @P]@A*~ '~,WP     Y@WAf`Y*=        !@@@@@**M@@@`
                 ]@[ `     g@A       ~`              i@@@f . .V@f
                 ]@[      !@@!                      -W@@Lg     f
                 ]@b      ,@!                       m@@AVf
                  @W      dM.                      i4@@zs      [
                  YW.     !mX+-~V*+                ]@@Wm!=  . /
                  '@i      !!                      g@@@P    -~
                   Mb-   !b ,_                     M@@@b__g/
                   !@[    M@@@Wme=*mm==-           ,G@8@@@!
                    @W    ]@@z                     d@@@@@f
                    !@b    **f`                   !@fV@@As
                     V@W.                         W@fd@@['W
                      'M@@s.                    ,W@` V\A`i@b
                        'M@Ws                 _mWA`  ,f g@@@W.
                          8@@@ms.            ,Mf`      d@@@@@@m__
                        ,gPf@@@Ws.                  _mA5@*P@@@@@@@@ms_
                   ,_gm@@@b !@@@*`    `             -` -|gA4@~Z~5(*V~/Tms.
              ,_mm@@@@@@@@@s.'V+                       ,_A ~,/  `\\
        ,mmW@@@@@@@@@@@@@@@@W,                          *!,gf   -
      W@@@@@@YAK@@@@@@@@'@@MA@-    g                   ',gf`
      f@A@Z@WW[@@@@@@@@@[Y@   -    @.                 .z@!
        \A@@@@WP`dAffV@8@/\i      dPW               -!-'|
        '!@@@5!KiVi i'''V*.      ,~~8b           -
           ~8WW@[. i      8s    i! '~Vb       -
            -!V`- i!'    `/.Vc.-`     '`
                  '       !  g` \.     '
                             [
    伟大的无产阶级革命家毛泽东同志永垂不朽！ 马克思主义光辉保佑代码永无Bug！
    ☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭☭
 */