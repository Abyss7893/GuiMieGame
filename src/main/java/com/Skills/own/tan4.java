package com.Skills.own;

import com.Skills.basicSkill;

public class tan4 extends basicSkill {

    public tan4(){
        Img = "skills/tan/t4_";
        animationEffects = "animEffects/tan4.gif";
        animationMillis = 450;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return (int)(ownAtk * 0.8);
    }

    @Override
    public int addOwnLife(int ownTotalLife,int ownLife){
        if(ownTotalLife == ownLife)
            return 0;
        int minus = ownTotalLife - ownLife;
        return (int)(minus * 0.15);
    }
}
