package com.Skills.enemy.ghost8;

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
        return 90;
    }

    @Override
    public int debarEnemyRound(){
        if(isMiss(1089))
            return 1 + 1;
        return 0;
    }
}
