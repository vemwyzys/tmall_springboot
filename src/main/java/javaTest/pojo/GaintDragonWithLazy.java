package javaTest.pojo;

/**
 * 懒汉式单例模式
 */
public class GaintDragonWithLazy {

    /**
     * 私有化构造器,使其不能通过new创建对象
     */
    private GaintDragonWithLazy() {
    }

    /**
     * 准备一个类属性,用于指向一个实例对象,但此时还没有创建
     */
    private static GaintDragonWithLazy instance;

    public static GaintDragonWithLazy getInstance() {

        //第一次访问的时候,发现instance没有指向任何一个对象,此时实例化一个对象出来
        if (null == instance) {
            instance = new GaintDragonWithLazy();
        }
        return instance;
    }

}
