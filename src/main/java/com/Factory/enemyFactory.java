package com.Factory;

import com.Skills.basicSkill;
import com.abyss.dataBase;
import com.abyss.enemyBasicData;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class enemyFactory extends abstractFactory{
    @Override
    public basicSkill getSkill(int useless,int pos)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {

        if(pos >= enemyBasicData.basicSkillNum[dataBase.selectedState])
            return null;
        String s = "com.Skills.enemy.ghost" + dataBase.selectedState + ".skill" + pos;
        Class<?> clazz = Class.forName(s);
        Constructor<?> constructor = clazz.getConstructor();
        return (basicSkill) constructor.newInstance();
    }


    @Override
    public int setBasicLife(int state) {
        return enemyBasicData.basicLife[state];
    }

    @Override
    public int setBasicAtk(int state) {
        return enemyBasicData.basicAtk[state];
    }

    @Override
    public int setBasicAgility(int state) {
        return enemyBasicData.basicAgility[state];
    }

    @Override
    public String setSilentPath(int state) {
        return enemyBasicData.silentPath + state + ".gif";
    }

    @Override
    public String setAttackPath(int state) {
        return enemyBasicData.attackPath + state + ".png";
    }

    @Override
    public String setIcon(int state) {
        return enemyBasicData.iconPath + state + ".png";
    }

    @Override
    public int setMaxLife(int state) {
        return enemyBasicData.basicLife[state];
    }

}
