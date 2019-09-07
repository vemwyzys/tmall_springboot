package javaTest.pojo;

import javaTest.myInterface.AD;

public class ADHero extends Hero implements AD {
    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    /**
     * 覆写     (重写类方法)
     */
    public static void battleWin(){
        System.out.println("ADHero比赛赢了");
    }
}
