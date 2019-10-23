package javaTest.MyTest;

import javaTest.pojo.Apple;
import javaTest.pojo.Banana;
import javaTest.pojo.Fruit;

/**
 * 简单工厂模式:专门创建一个类来负责创建其他类
 * 这些个其他类,往往有同一个父类
 */
public class _11EasyFactory {
    public static void main(String[] args) {

        //用到了多态
        Fruit f1 = new Apple();
        Fruit f2 = new Banana();
        f1.eat();
        f2.eat();

        //简单工厂模式
        Apple apple = _11EasyFactory.getApple();
        Banana banana = _11EasyFactory.getBanana();

        //Fruit apple1 = _11EasyFactory.getFruit("Apple");
    }

    public static Apple getApple(){
        return new Apple();
    }

    public static Banana getBanana(){
        return new Banana();
    }

//    public static Fruit getFruit(String type){
//        if("Apple".equalsIgnoreCase(type)){
//            return Apple.class.newInstance();
//        }else ("Banana".equalsIgnoreCase(type)){
//            return Banana.class.newInstance();
//        }
//        System.out.printf("没有响应的对象\n");
//        return null;
//    }
}
