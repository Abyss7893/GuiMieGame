package com.Skills.own;

import com.Skills.basicSkill;

public class tan2 extends basicSkill {

    public tan2(){
        Img = "skills/tan/t2_";
        animationEffects = "animEffects/tan2.gif";
        animationMillis = 800;
        useTimes = 10;
    }

    @Override

    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 75;
    }

    @Override
    public int changeOwnAtk(int ownAtk){
        return ownAtk + 20;
    }
}
