package com.Skills.own;

import com.Skills.basicSkill;

public class tan8 extends basicSkill {

    public tan8(){
        Img = "skills/tan/t8_";
        animationEffects = "animEffects/tan8.gif";
        animationMillis = 550;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return (int)(ownAtk * 1.15);
    }

    @Override
    public int changeOwnAtk(int ownAtk){
        return ownAtk + 20;
    }
}
