package com.Skills.enemy.ghost9;

import com.Skills.basicSkill;

public class skill1 extends basicSkill {

    public skill1() {
        animationEffects = "animEffects/enemy/boss2.gif";
        animationMillis = 500;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 100 + (int)(ownAtk * 0.2);
    }

    @Override
    public int debarEnemyRound(){
        if(isMiss(900))  //30%
            return 1 + 1;
        return 0;
    }
}
