package javaTest.MyTest;

import javaTest.pojo.EnemyHeroIsDeadException;
import javaTest.pojo.Hero;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class _6ExceptionTest {
    public static void main(String[] args) {

        //method1();
        method2();

    }

    //使用自定义异常
    private static void method2() {
        Hero garen = new Hero("盖伦", 1000);
        Hero temoo = new Hero("盖伦", 0);
        try {
            garen.attack(temoo,100);
        } catch (EnemyHeroIsDeadException e) {
            e.printStackTrace();
        }
    }

    private static void method1() {
        File file = new File("d:/LOL.exe");
        try {
            System.out.println("尝试打开d:/LOL.exe");
            new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("d:/LOL.exe不存在");
            e.printStackTrace();
        }finally {
            System.out.println("最后会执行的东西");
        }
    }
}
