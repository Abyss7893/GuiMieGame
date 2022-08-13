package com.Skills.enemy.ghost9;

import com.Skills.basicSkill;

public class skill3 extends basicSkill {
    public skill3() {
        animationEffects = "animEffects/enemy/upSpeed.gif";
        animationMillis = 450;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return -1;
    }

    @Override
    public int changeOwnAtk(int ownAtk){
        return ownAtk + 15;
    }

    @Override
    public int addOwnLife(int ownTotalLife,int ownLife){
        return Math.min(ownTotalLife - ownLife, 50);
    }
}
