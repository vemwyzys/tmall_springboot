package javaTest.pojo;

import javaTest.myInterface.AP;

public class APHero extends Hero implements AP {
    @Override
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }
}
