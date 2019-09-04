package com.menghan.tmall.test.pojo;

/**
 * 饿汉式单例模式
 */
public class GaintDragonWithHungry {

    /**
     * 私有化构造方法，使其不能用new进行实例化
     */
    private GaintDragonWithHungry() {
    }

    /**
     * 准备一个类属性,指向实例化一个对象.    因为是类属性,所以只有一个.(静态类属性,加载进内存,也就仅此一个)
     * (当一个属性被static修饰的时候，就叫做类属性，又叫做静态属性
     * 当一个属性被声明成类属性，那么所有的对象，都共享一个值)
     */
    private static GaintDragonWithHungry instance =  new GaintDragonWithHungry();

    /**
     * public static方法,给调用者返回实例化的方法产生的对象
     */
    public  static GaintDragonWithHungry getInstance(){
        return instance;
    }
}
