package com.menghan.tmall.test.pojo;

import com.menghan.tmall.test.myInterface.AD;
import com.menghan.tmall.test.myInterface.AP;

public class APADHero extends Hero implements AP, AD {

    @Override
    public void physicAttack() {
        System.out.println("进行了物理攻击");
    }

    @Override
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }
}
