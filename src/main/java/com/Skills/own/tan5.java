package com.Skills.own;

import com.Skills.basicSkill;

public class tan5 extends basicSkill {

    public tan5(){
        Img = "skills/tan/t5_";
        animationEffects = "animEffects/tan5.gif";
        animationMillis = 450;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        int minus = hostileTotalLife - nowHostileLife;
        return (int)(minus * 0.22);
    }

    @Override
    public int debarSelfRound(){
        return 1 + 1;
    }
}
