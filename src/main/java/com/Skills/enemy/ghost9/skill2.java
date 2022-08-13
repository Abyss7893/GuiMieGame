package com.Skills.enemy.ghost9;

import com.Skills.basicSkill;

public class skill2 extends basicSkill {
    public skill2() {
        animationEffects = "animEffects/enemy/boss3.gif";
        animationMillis = 3150;
    }
    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return 160;
    }
    @Override
    public int addOwnLife(int ownTotalLife,int ownLife){
        return Math.min(ownTotalLife - ownLife, 90);
    }
}
