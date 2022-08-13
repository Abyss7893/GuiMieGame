package com.Skills.own;

import com.Skills.basicSkill;

public class zhu2 extends basicSkill {

    public zhu2(){
        Img = "skills/zhu/z2_";
        animationEffects = "animEffects/zhu2.gif";
        animationMillis = 450;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return (int)(ownAtk * 0.7);
    }

    @Override
    public int addOwnLife(int ownTotalLife,int ownLife){
        return 60;
    }
}

