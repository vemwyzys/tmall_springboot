package javaTest.MyTest;

import javaTest.myInterface.AD;
import javaTest.pojo.*;

public class CInheritAndInterface {
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

        /**
         * 超类
         */

        /**
         * toString()
         */
        System.out.println("\n toString()");
        System.out.println(new Hero().toString());

        /**
         * finalize()
         */
        System.out.println("\n finalize");
        Hero h;
        //想要触发的话,请将循环改成十万
        for (int i = 0; i < 10; i++) {
            //不断生成新的对象
            //引用不断改变指向的对象
            //当垃圾堆积比较多的时候，就会触发垃圾回收
            //垃圾回收时候，finalize()方法就会被调用
            h = new Hero();
        }

        /**
         * equals()
         */
        Hero heroA = new Hero();
        Hero heroB = new Hero();
        System.out.println(heroA.equals(heroB));

        APHero apHero1 = new APHero("aaa", 100);
        APHero apHero2 = new APHero("aaa",100);
        System.out.println(apHero1.equals(apHero2));

        /**
         * 抽象类
         */
        new HeroAbstract(){
            public void whisper(){
                System.out.println("haha");
            }
        }.whisper();
        new APHeroFromHeroAbstract().whisper();

        /**
         * 区别1：
         子类只能继承一个抽象类，不能继承多个
         子类可以实现多个接口
         区别2：
         抽象类可以定义
         public,protected,package,private
         静态和非静态属性
         final和非final属性
         但是接口中声明的属性，只能是
         public
         静态
         final的
         即便没有显式的声明
         */

    }
}
