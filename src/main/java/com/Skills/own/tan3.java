package com.Skills.own;

import com.Skills.basicSkill;

public class tan3 extends basicSkill {

    public tan3(){
        Img = "skills/tan/t3_";
        animationEffects = "animEffects/tan3.gif";
        animationMillis = 500;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return -1;
    }

    @Override
    public int changeOwnAtk(int ownAtk){
        return ownAtk + 10;
    }
    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 50;
    }
}
