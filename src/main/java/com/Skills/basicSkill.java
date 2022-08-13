package com.Skills;

import java.util.Random;

public abstract class basicSkill {
    public String Img;
    public String animationEffects;
    public int animationMillis;
    public int useTimes;

    //The damage number is related to five factors:
    //own attack power,total enemy life,enemy current life,the enemy agility，Round number
    public abstract int attackEnemy(int ownAtk, int hostileTotalLife, int nowHostileLife, int hostileAgility, int round);

    //buff to self
    public int changeOwnAtk(int ownAtk){
        return ownAtk;
    }
    public int changeOwnAgility(int ownAgility){
        return ownAgility;
    }
    public int addOwnLife(int ownTotalLife,int ownLife){
        return 0;
    }

    //debuff to self
    public int debarSelfRound(){
        return 0;
    }
    public int weakSelfRound(){
        return 0;
    }

    //debuff to enemy
    public int debarEnemyRound(){
        return 0;
    }
    public int weakEnemyRound(){
        return 0;
    }

    protected boolean isMiss(int enemyAgility){
        Random makeRandomNum = new Random();
        double rate = Math.sqrt((double)enemyAgility);
        double res = makeRandomNum.nextDouble(100);
        return rate > res;
    }

}
