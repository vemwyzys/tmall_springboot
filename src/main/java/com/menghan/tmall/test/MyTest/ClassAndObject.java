package com.menghan.tmall.test.MyTest;

import com.menghan.tmall.test.pojo.Armor;
import com.menghan.tmall.test.pojo.Hero;
import com.menghan.tmall.test.pojo.SupportHero;

public class ClassAndObject {
    public static void main(String[] args) {
        Hero hero1 = new Hero();

        Hero hero3;

        hero3 = hero1;

        System.out.println(hero1 instanceof Hero);

        //==是判断是否为同一对象（同一个内存空间）
        System.out.println(hero1 == hero3);

        //equals来自超类，默认和“==”等价， 不过String类、Date类、File类都对equals进行了重写
        System.out.println(hero1.equals(hero3));


        Armor cloth = new Armor();
        cloth.setName("布甲");
        cloth.setAc(200);
        cloth.setPrice(300);
        System.out.println(cloth);


        Hero garen = new Hero();
        garen.setName("garen");
        SupportHero milkMother = new SupportHero();
        milkMother.heal();
        milkMother.heal(garen);
        milkMother.heal(garen,100);

        garen.showAddressInMemory();

        Hero teemo = new Hero("提莫", 1000, 500, 350);
        Hero prince = new Hero("皇子", 2000, 800, 300);
        teemo.attack(prince,100);

    }
}
