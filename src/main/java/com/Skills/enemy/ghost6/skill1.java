package com.Skills.enemy.ghost6;

import com.Skills.basicSkill;

public class skill1 extends basicSkill {

    public skill1() {
        animationEffects = "animEffects/enemy/roar.gif";
        animationMillis = 600;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return -1;
    }

    @Override
    public int addOwnLife(int ownTotalLife,int ownLife){
        if(ownTotalLife - ownLife <= 80)
            return ownTotalLife - ownLife;
        return 80;
    }
}
