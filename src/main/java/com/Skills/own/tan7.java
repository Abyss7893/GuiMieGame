package com.Skills.own;

import com.Skills.basicSkill;

public class tan7 extends basicSkill {

    public tan7(){
        Img = "skills/tan/t7_";
        animationEffects = "animEffects/tan7.gif";
        animationMillis = 450;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return (int)(ownAtk * 1.2);
    }

}
