package com.Skills.enemy.ghost6;

import com.Skills.basicSkill;

public class skill0 extends basicSkill {

    public skill0() {
        animationEffects = "animEffects/enemy/roar.gif";
        animationMillis = 600;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 75 + (int)(ownAtk * 0.25);
    }
}
