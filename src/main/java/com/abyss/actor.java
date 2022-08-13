package com.abyss;

import com.Factory.abstractFactory;
import com.Factory.factoryProducer;
import com.Skills.basicSkill;

import java.lang.reflect.InvocationTargetException;

public class actor {
    //basic attack dada
    public int maxLife;
    public int life;
    public int atk;
    public int agility;
    public basicSkill []skill = new basicSkill[4];
    public abstractFactory factory;
    public int isWeak,isDebar;

    //basic UI data
    public String actorSilentPath,actorAttackPath;
    public String actorIcon;

    public actor(String category) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        isWeak = isDebar = 0;

        //get all skills
        factory = factoryProducer.getFactory(category);
        for(int i = 0; i <= 3; i++) {
            assert factory != null;
            if(dataBase.selectedState == 7)
                skill[i] = factory.getSkill(7*10 + dataBase.skillsChoosing[i],i);
            else if(dataBase.selectedState == 8)
                skill[i] = factory.getSkill(8*10 + dataBase.skillsChoosing[i],i);
            else
                skill[i] = factory.getSkill(dataBase.skillsChoosing[i],i);
        }

        //get all basic attributes
        life = factory.setBasicLife(dataBase.selectedState);
        maxLife = factory.setMaxLife(dataBase.selectedState);
        atk = factory.setBasicAtk(dataBase.selectedState);
        agility = factory.setBasicAgility(dataBase.selectedState);

        actorSilentPath = factory.setSilentPath(dataBase.selectedState);
        actorAttackPath = factory.setAttackPath(dataBase.selectedState);
        actorIcon = factory.setIcon(dataBase.selectedState);

    }

    public void functionPre(int pos,actor enemy) {
        skill[pos].useTimes -= 1;
        atk = skill[pos].changeOwnAtk(atk);
        agility = skill[pos].changeOwnAgility(agility);

        int temp = isWeak;
        isWeak = isWeak + skill[pos].weakSelfRound();
        isDebar = isDebar + skill[pos].debarSelfRound();
        if(temp == 0 && isWeak > 0)
            atk /= 2;

        temp = enemy.isWeak;
        enemy.isWeak = enemy.isWeak + skill[pos].weakEnemyRound();
        enemy.isDebar = enemy.isDebar + skill[pos].debarEnemyRound();
        if(temp == 0 && enemy.isWeak > 0)
            enemy.atk /= 2;
    }

}
