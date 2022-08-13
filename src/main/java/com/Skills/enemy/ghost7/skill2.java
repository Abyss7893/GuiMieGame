package com.Skills.enemy.ghost7;

import com.Skills.basicSkill;

public class skill2 extends basicSkill {

    public skill2() {
        animationEffects = "animEffects/enemy/loopUse.gif";
        animationMillis = 630;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 70;
    }

    @Override
    public int weakEnemyRound(){
        if(isMiss(1089))
            return 1 + 1;
        return 0;
    }
}
