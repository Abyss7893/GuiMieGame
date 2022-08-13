package com.Skills.own;

import com.Skills.basicSkill;

public class shan2 extends basicSkill {

    public shan2(){
        Img = "skills/shan/s2_";
        animationEffects = null;
        animationMillis = 0;
        useTimes = 20;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        return -1;
    }

    @Override
    public int changeOwnAgility(int ownAgility){
        return ownAgility + 150;
    }
}
