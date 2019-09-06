package com.menghan.tmall.test.MyTest;

import com.menghan.tmall.test.myInterface.AD;
import com.menghan.tmall.test.pojo.*;

public class InheritAndInterface {
    public static void main(String[] args) {
        ADHero adHero = new ADHero();
        adHero.physicAttack();

        APHero apHero = new APHero();
        apHero.magicAttack();

        APADHero apadHero = new APADHero();
        apadHero.magicAttack();
        apadHero.physicAttack();
        apadHero.setHp(2000);

        Hero hero;

        /**
         * 这里,把子类对象赋值给父类对象,ok的
         * 苹果手机继承自手机,把苹果手机当做手机用,没有问题
         *
         */
        hero = apadHero;
        System.out.println(hero.getHp());
        //依然为2000点血

        /**
         * 把父类转成子类,一般来说都不行,除非这个父类本来就是子类转来的
         */
        Hero hero1 = new Hero();
        ADHero adHero1;
        //报错   adHero1= (ADHero) hero1;

        /**
         * 实现转接口 ok的,没问题
         */
        AD ad = apadHero;
        ad.physicAttack();
        ((APADHero) ad).magicAttack();

        /**
         * 重写
         */
        new LifePotion().effect();

        /**
         * 覆写
         */
        Hero.battleWin();
        ADHero.battleWin();

        int hashCode = new Object().hashCode();
        System.out.println(hashCode);

    }
}
