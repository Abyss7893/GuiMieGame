package com.Skills.own;
import com.Skills.basicSkill;

public class tan1 extends basicSkill {
    public tan1() {
        Img = "skills/tan/t1_";
        animationEffects = "animEffects/tan1.gif";
        animationMillis = 500;
        useTimes = 99;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(hostileAgility))
            return 0;
        return 80;
    }

}
