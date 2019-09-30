package javaTest.MyTest;
//注意：是java.util.Date;
//而非 java.sql.Date，此类是给数据库访问的时候使用的
import java.util.Date;

public class _4DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
    }
}
