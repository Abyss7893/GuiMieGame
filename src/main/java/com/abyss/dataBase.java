package com.abyss;

import java.util.*;

public class dataBase {

    public static boolean isProcessFirst = true;
    public static boolean isZhuShi = true;

    public static boolean isEnding = true;

    public static int whoWin;
    public static int maxOwnLife;

    public static  int maxOwnAtk;

    public static  int maxOwnAgility;
    public static int maxState = 1;
    public static int selectedState = -1;
    private static final List<Integer>  skillsLocked = new LinkedList<Integer>();

    public static final int[] skillsChoosing = new int[4];

    private static final boolean []skillsGet = {false,
                                        true,true,true,true,true,
                                        false,false,false,false,false};
    public static void init() {
        for(int i = 10;i >= 6;i--)
            skillsLocked.add(i);
        whoWin = 0;
        Collections.shuffle(skillsLocked);
        initSkillsChoosing();
    }

    public static void initSkillsChoosing(){
        for(int i = 0; i <= 3; i++)
            skillsChoosing[i] = -1;
    }

    public static void getSkillsChoosing(int p) {

        for(int i = 0; i <= 3; i++)
            if(skillsChoosing[i] == -1) {
                skillsChoosing[i] = p;
                break;
            }
        /*
        if(skillsChoosing[3] != -1)
            for(int i = 0; i < 4; i++)
                System.out.print(skillsChoosing[i] + " ");
       */
        return;
    }

    public static void getNewSkill() {
        Iterator<Integer> iterator = skillsLocked.iterator();
        if(!skillsLocked.isEmpty()) {
            int newSkill = iterator.next();
            skillsGet[newSkill] = true;
            //System.out.println(newSkill);
            skillsLocked.remove(0);
        }
    }

    public static boolean isGet(int id){
        return skillsGet[id];
    }

}
