package com.Skills.own;

import com.Skills.basicSkill;

public class zhu1 extends basicSkill {

    public zhu1(){
        Img = "skills/zhu/z1_";
        animationEffects = "animEffects/zhu1.gif";
        animationMillis = 450;
        useTimes = 10;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 80 + (int)(ownAtk * 0.3);
    }

    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 50;
    }
}
