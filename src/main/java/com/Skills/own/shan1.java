package com.Skills.own;

import com.Skills.basicSkill;

public class shan1 extends basicSkill {

    public shan1(){
        Img = "skills/shan/s1_";
        animationEffects = "animEffects/shan1.gif";
        animationMillis = 600;
        useTimes = 10;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(isMiss(ownAtk) && round >= 7) {  //ownAtk is ownAgility
            animationEffects = "animEffects/shanB.gif";
            animationMillis = 1600;
            return nowHostileLife;
        }
        return (int)(ownAtk * 0.2);
    }

    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 40;
    }
}
