package com.Skills.enemy.ghost3;

import com.Skills.basicSkill;

public class skill0 extends basicSkill {

    public skill0() {
        animationEffects = "animEffects/enemy/enemyAttack.gif";
        animationMillis = 450;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return ownAtk;
    }
}
