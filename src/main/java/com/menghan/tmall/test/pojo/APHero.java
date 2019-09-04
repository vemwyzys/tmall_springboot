package com.menghan.tmall.test.pojo;

import com.menghan.tmall.test.myInterface.AP;

public class APHero extends Hero implements AP {
    @Override
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }
}
