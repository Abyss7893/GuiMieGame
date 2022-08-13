package com.Skills.enemy.ghost4;

import com.Skills.basicSkill;

public class skill0 extends basicSkill {

    public skill0() {
        animationEffects = "animEffects/enemy/arrow1.gif";
        animationMillis = 450;
    }
    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return ownAtk;
    }

    @Override
    public int debarEnemyRound(){
        if(isMiss(400))   //20%
            return 1 + 1;
        return 0;
    }
}
