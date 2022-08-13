package com.Factory;

public class factoryProducer {
    public static abstractFactory getFactory(String s) {
        if(s.equals( "OWN"))
            return new ownFactory();
        else if(s.equals("ENEMY"))
            return new enemyFactory();
        return null;
    }
}
