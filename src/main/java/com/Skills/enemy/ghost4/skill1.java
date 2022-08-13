package com.Skills.enemy.ghost4;

import com.Skills.basicSkill;

public class skill1 extends basicSkill {

    public skill1() {
        animationEffects = "animEffects/enemy/arrow2.gif";
        animationMillis = 600;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 90;
    }

    @Override
    public int weakEnemyRound(){
        if(isMiss(400))   //20%
            return 2 + 1;
        return 0;
    }
}
