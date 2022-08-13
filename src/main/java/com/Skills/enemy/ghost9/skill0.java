package com.Skills.enemy.ghost9;

import com.Skills.basicSkill;

public class skill0 extends basicSkill {
    public skill0() {
        animationEffects = "animEffects/enemy/boss1.gif";
        animationMillis = 400;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 150;
    }
}
