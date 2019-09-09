package javaTest.MyTest;

/**
 * 字符串即字符的组合，在Java中，字符串是一个类，所以我们见到的字符串都是对象
 * 常见创建字符串手段：
 * 1. 每当有一个字面值出现的时候，虚拟机就会创建一个字符串
 * 2. 调用String的构造方法创建一个字符串对象
 * 3. 通过+加号进行字符串拼接也会创建新的字符串对象
 * <p>
 * String 被修饰为final,所以是不能被继承的
 */

/**
 * String 被修饰为final,所以是不能被继承的
 */

/**
 * immutable 是指不可改变的
 比如创建了一个字符串对象
 String garen ="盖伦";
 不可改变的具体含义是指：
 不能增加长度
 不能减少长度
 不能插入字符
 不能删除字符
 不能修改字符
 一旦创建好这个字符串，里面的内容 永远 不能改变

 String 的表现就像是一个常量
 */
public class StringTest {

    public static void main(String[] args) {
        /**
         * 字符串格式化
         */
        String name = "盖伦";
        int kill = 10;
        String title = "超神";
        String sentence = name + "在进行了" + kill + "击杀后,获得了" + title + "的称号";
        System.out.println(sentence);

        String sentenceFormat = "%s在进行了%d击杀后,获得了%s的称号%n";
        String s = String.format(sentenceFormat, name, kill, title);
        System.out.println(s);

        System.out.println(name.length());

        /**
         * StringBuffer   append  delete insert reverse
         */
        String menghan = "menghan";
        StringBuffer m = new StringBuffer(menghan);
        m.append("123");
        m.delete(7,10);
        System.out.println(m);
        m.insert(6,"123");
        m.reverse();
        System.out.println(m);

        System.out.println(m.capacity());



    }

}
