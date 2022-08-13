package com.Skills.enemy.ghost6;

import com.Skills.basicSkill;

public class skill2 extends basicSkill {

    public skill2() {
        animationEffects = "animEffects/enemy/drug.gif";
        animationMillis = 420;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return 95;
    }

    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 60;
    }
}
