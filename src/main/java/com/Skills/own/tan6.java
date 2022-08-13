package com.Skills.own;

import com.Skills.basicSkill;

public class tan6 extends basicSkill {

    public tan6(){
        Img = "skills/tan/t6_";
        animationEffects = "animEffects/tan6.gif";
        animationMillis = 450;
        useTimes = 10;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return (int)(ownAtk * 0.6);
    }

    @Override
    public int weakEnemyRound(){
        if(isMiss(3025))   // 50%
            return 2 + 1;
        return 0;
    }
}
