package javaTest.MyTest;

import java.io.*;

public class IOTest {
    public static void main(String[] args) {

        //绝对路径
        File f = new File("d:/wow");
        System.out.println("f的绝对路径是:" + f.getAbsolutePath());

        //相对路径,相对于工作目录,web工程中就是项目目录
        File f2 = new File("wow");
        System.out.println("f2的绝对路径是:" + f2.getAbsolutePath());

        //把f作为父目录创建文件对象
        File f3 = new File(f, "wow");
        System.out.println("f3的绝对路径是:" + f3.getAbsolutePath());

        File file = new File("1.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("当前文件是:" + file);
        System.out.println(f.exists());
        System.out.println(f.isDirectory());

        try {
            new PrintWriter(new FileWriter(f));
            new PrintWriter(new FileOutputStream(f));

            new PrintWriter(new FileOutputStream(f));
            new DataOutputStream(new FileOutputStream(f));
            new ObjectOutputStream(new FileOutputStream(f));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //字节流练习
        byteStream();

        //字符流练习
        fr();

        //缓存流
        br();



    }

    private static void br() {
        //创建文件
        File f = new File("/MyTest/IO/1.txt");//这里会创建到项目所在目录的根目录
        File parentFile = f.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();//mkdir()创建父目录,mkdirs()创建所有父目录
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileWriter fw = new FileWriter(f);
             //缓存流必须建立在一个存在的流的基础上
             PrintWriter pw = new PrintWriter(fw)) {

            pw.println("abc");
            pw.flush();//强制把缓存写入硬盘,无论缓存是否已经满了
            pw.println("adc");
            pw.println("bbnnnnnnn");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader(f);BufferedReader br = new BufferedReader(fr)) {
            do {
                String str = br.readLine();
                if (null==str){
                    break;
                }
                System.out.println(str);
            } while (true);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fr() {
        //创建文件
        File f = new File("/MyTest/IO/1.txt");//这里会创建到项目所在目录的根目录
        File parentFile = f.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();//mkdir()创建父目录,mkdirs()创建所有父目录
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(f); FileReader fileReader = new FileReader(f)) {
            String data = "what's up?";
            char[] chars = data.toCharArray();
            fileWriter.write(chars);

        } catch (IOException e0) {
            e0.printStackTrace();
        }

        //读写不能放在一起,字节流应该在关闭后才会真正写入文件,在没有close之前,文件长度为0.  但字节流可以
        try (FileReader fileReader = new FileReader(f)) {
            System.out.println(f.length());
            char[] chars1 = new char[(int) f.length()];
            fileReader.read(chars1);
            for (char c :
                    chars1) {
                System.out.println(c);
            }
        } catch (IOException e0) {
            e0.printStackTrace();
        }

    }

    private static void byteStream() {

        //创建文件
        File f = new File("/MyTest/IO/1.txt");//这里会创建到项目所在目录的根目录
        File parentFile = f.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();//mkdir()创建父目录,mkdirs()创建所有父目录
        }
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 创建基于文件的输入流,输出流
        // 通过这个输入流，就可以把数据从硬盘，读取到Java的虚拟机中来，也就是读取到内存中
        /**
         * try-with-resources结构
         * 当try语句块运行结束时，FileInputStream 会被自动关闭。
         * 这是因为FileInputStream 实现了java中的java.lang.AutoCloseable接口。所有实现了这个接口的类都可以在try-with-resources结构中使用。
         * 当try-with-resources结构中抛出一个异常，
         * 同时FileInputStreami被关闭时（调用了其close方法）也抛出一个异常，
         * try-with-resources结构中抛出的异常会向外传播，而FileInputStreami被关闭时抛出的异常被抑制了。
         * 可以自定义
         */
        try (FileOutputStream fos = new FileOutputStream(f); FileInputStream fis = new FileInputStream(f)) {
            //写
            //创建长度为2的字节数组,用两个数字初始化
            //把数据写入到输出流
            byte[] data = {78, 56};
            fos.write(data);

            //读
            //创建字节数组,长度为文件的长度
            byte[] all = new byte[(int) f.length()];
            fis.read(all);
            for (byte b :
                    all) {
                System.out.println(b);
            }

        } catch (IOException e0) {
            e0.printStackTrace();
        }
    }
}
