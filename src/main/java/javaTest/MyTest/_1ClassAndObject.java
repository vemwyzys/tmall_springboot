package javaTest.MyTest;


import javaTest.pojo.*;

public class _1ClassAndObject {
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
        milkMother.heal(garen, 100);

        garen.showAddressInMemory();

        Hero teemo = new Hero("提莫", 1000, 500, 350);
        Hero prince = new Hero("皇子", 2000, 800, 300);
        try {
            teemo.attack(prince, 100);
        } catch (EnemyHeroIsDeadException e) {
            e.printStackTrace();
        }


        //进行类的属性初始化练习
        new HeroAboutStatic();//顺序：属性声明，初始化块，构造方法
        new HeroAboutStatic();

        //饿汉式单例模式
        GaintDragonWithHungry nashi = GaintDragonWithHungry.getInstance();
        GaintDragonWithHungry nashi2 = GaintDragonWithHungry.getInstance();

        //类属性是静态的,加载至内存时就已经存在巨龙的一个对象(有且只有一个),所以这里的两个引用 引用的是同一个对象
        System.out.println(nashi == nashi2);

        //懒汉式单例模式
        GaintDragonWithLazy nashi3 = GaintDragonWithLazy.getInstance();
        GaintDragonWithLazy nashi4 = GaintDragonWithLazy.getInstance();
        System.out.println(nashi3 == nashi4);

        /**
         * 饿汉式是立即加载的方式，无论是否会用到这个对象，都会加载。
         * 如果在构造方法里写了性能消耗较大，占时较久的代码，比如建立与数据库的连接，那么就会在启动的时候感觉稍微有些卡顿。
         *
         * 懒汉式，是延迟加载的方式，只有使用的时候才会加载。 并且有线程安全的考量(鉴于同学们学习的进度，暂时不对线程的章节做展开)。
         * 使用懒汉式，在启动的时候，会感觉到比饿汉式略快，因为并没有做对象的实例化。 但是在第一次调用的时候，会进行实例化操作，感觉上就略慢。
         *
         * 看业务需求，如果业务上允许有比较充分的启动和初始化时间，就使用饿汉式，否则就使用懒汉式
         */

        /**
         * 单例模式三元素
         * 1.构造方法私有化
         * 2.静态属性指向实例
         * 3.public static 的 getInstance方法返回第二步的静态属性
         *
         */


        //反射
        String className = "javaTest.pojo.Hero";
        try {

            Class<?> c1 = Class.forName(className);

            Class<Hero> c2 = Hero.class;

            Class<? extends Hero> c3 = new Hero().getClass();

            System.out.println(c1==c2);
            System.out.println(c2==c3);
            System.out.println(c1==c3);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
