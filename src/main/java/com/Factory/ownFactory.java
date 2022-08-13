package com.Factory;

import com.Skills.basicSkill;
import com.Skills.own.*;
import com.abyss.Config;
import com.abyss.dataBase;

public class ownFactory extends abstractFactory{

    @Override
    public basicSkill getSkill(int pos,int useless) {
        return switch (pos) {
            case 1 -> new tan1();
            case 2 -> new tan2();
            case 3 -> new tan3();
            case 4 -> new tan4();
            case 5 -> new tan5();
            case 6 -> new tan6();
            case 7 -> new tan7();
            case 8 -> new tan8();
            case 9 -> new tan9();
            case 10 -> new tan10();
            case 71 -> new zhu1();
            case 72 -> new zhu2();
            case 81 -> new shan1();
            case 82 -> new shan2();
            default -> null;
        };
    }

    @Override
    public int setBasicLife(int state) {
        if(state == 7)
            dataBase.maxOwnLife = 700;
        else if(state == 8)
            dataBase.maxOwnLife = 450;
        else
            dataBase.maxOwnLife = Config.basicTanLife + dataBase.maxState * Config.stateGainLife;
        return dataBase.maxOwnLife;
    }

    @Override
    public int setBasicAtk(int state) {
        if(state == 7)
            dataBase.maxOwnAtk = 120;
        else if(state == 8)
            dataBase.maxOwnAtk = 0;
        else
            dataBase.maxOwnAtk = Config.basicTanAtk + dataBase.maxState * Config.stateGainAtk;
        return dataBase.maxOwnAtk;
    }

    @Override
    public int setBasicAgility(int state) {
        if(state == 7)
            dataBase.maxOwnAgility = 320;
        else if(state == 8)
            dataBase.maxOwnAgility = 550;
        else
            dataBase.maxOwnAgility = Config.basicTanAgility + dataBase.maxState * Config.stateGainAgility;
        return dataBase.maxOwnAgility;
    }

    @Override
    public String setSilentPath(int state) {
        String target;
        if(state == 7)
            target = "role/own/zhu1.gif";
        else if(state == 8)
            target = "role/own/shan1.gif";
        else
            target = "role/own/tan1.gif";
        return target;
    }

    @Override
    public String setAttackPath(int state) {
        String target;
        if(state == 7)
            target = "role/own/zhu2.png";
        else if(state == 8)
            target = "role/own/shan2.png";
        else
            target = "role/own/tan2.png";
        return target;
    }

    @Override
    public String setIcon(int state) {
        if(state == 7)
            return "role/own/zhuIcon.png";
        if(state == 8)
            return "role/own/shanIcon.png";
        return "role/own/tanIcon.png";
    }

    @Override
    public int setMaxLife(int state) {
        return dataBase.maxOwnLife;
    }
}
