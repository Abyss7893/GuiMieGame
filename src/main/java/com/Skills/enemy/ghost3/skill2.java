package com.Skills.enemy.ghost3;

import com.Skills.basicSkill;

public class skill2 extends basicSkill {

    public skill2() {
        animationEffects = "animEffects/enemy/upSpeed.gif";
        animationMillis = 450;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return -1;
    }

    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 80;
    }

    @Override
    public int addOwnLife(int ownTotalLife,int ownLife){
        if(ownTotalLife - ownLife < 25)
            return ownTotalLife - ownLife;
        return 25;
    }
}
