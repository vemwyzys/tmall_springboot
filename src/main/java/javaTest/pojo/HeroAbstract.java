package javaTest.pojo;

/**
 * Hero类可以在不提供抽象方法的前提下，声明为抽象类
 *一旦一个类被声明为抽象类，就不能够被直接实例化
 */

public abstract class HeroAbstract {
    String name;
    int moveSpeed;
    float hp;
    float armor;

    public abstract void whisper();
}
