package javaTest.pojo;

public class HeroAboutStatic {

    String name = setName("属性声明");



    public HeroAboutStatic() {
        this.name = setName("构造方法");
    }

    {
        name = setName("非静态初始化块");
        System.out.println("    非静态初始化块主要用于对象的初始化操作，在每次创建对象时都要调用一次");
    }

    static {
        System.out.println("静态初始化块，只调用一次，在类被加载进内存中调用");
    }

    private static String setName(String name) {
        System.out.println("初始化："+name);
        return name;
    }
}
