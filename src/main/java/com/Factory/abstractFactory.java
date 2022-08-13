package com.Factory;

import com.Skills.basicSkill;

import java.lang.reflect.InvocationTargetException;

public abstract class abstractFactory {
    public abstract basicSkill getSkill(int pos1,int pos2)
            throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException;

    public abstract int setBasicLife(int state);
    public abstract int setBasicAtk(int state);
    public abstract int setBasicAgility(int state);
    public abstract String setSilentPath(int state);
    public abstract String setAttackPath(int state);
    public abstract String setIcon(int state);
    public abstract int setMaxLife(int state);
}
