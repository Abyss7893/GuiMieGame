package com.Skills.own;

import com.Skills.basicSkill;
import com.abyss.dataBase;

public class tan10 extends basicSkill {

    public tan10(){
        Img = "skills/tan/t10_";
        animationEffects = "animEffects/tan10.gif";
        animationMillis = 1200;
        useTimes = 5;
    }

    @Override
    public int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round) {
        if(useTimes == 1 && dataBase.selectedState == 9) {
            animationEffects = "animEffects/fireGod.gif";
            animationMillis = 1900;
            return nowHostileLife;
        }
        if(useTimes == 2 && dataBase.selectedState == 9) {
            Img = "skills/tan/fireGod_";
        }
        if(isMiss(hostileAgility))
            return 0;
        int roundAtk = round * 15;
        return (int)(ownAtk * 0.5 + roundAtk);
    }
}
