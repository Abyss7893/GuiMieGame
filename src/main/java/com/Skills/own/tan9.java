package com.Skills.own;

import com.Skills.basicSkill;

public class tan9 extends basicSkill {

    public tan9(){
        Img = "skills/tan/t9_";
        animationEffects = "animEffects/tan9.gif";
        animationMillis = 450;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return -1;
    }

    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 105;
    }
}
