package javaTest.MyTest;

import javaTest.pojo.EnemyHeroIsDeadException;
import javaTest.pojo.Hero;
import javaTest.pojo.MyThread;

public class _10Thread {
    public static void main(String[] args) {
        myThread();
        //sleepTest();
        //joinTest();
        synchronizedTest();
        new StringBuffer();//所有方法全部同步
        new StringBuilder();//没有同步
    }

    private static void myThread() {
        MyThread myThread = new MyThread();
        for (int i = 0; i < 30; i++) {
            Thread thread = new Thread(myThread);
            thread.run();
        }
    }

    private static void synchronizedTest() {

        Thread MainThread = Thread.currentThread();
        MainThread.setPriority(Thread.MIN_PRIORITY);

        final Hero gareen = new Hero("盖伦", 1000, 50);

        int num = 10;
        Thread[] recoverThreads = new Thread[num];
        Thread[] hurtThreads = new Thread[num];

        for (int i = 0; i < num; i++) {
            Thread t = new Thread() {
                public void run() {
                    synchronized (gareen) {
                        gareen.recover();
                        System.out.println("恢复!  " + gareen.getHp());
                    }
                }
            };
            recoverThreads[i] = t;
            t.start();
        }
        for (int i = 0; i < num; i++) {
            Thread t = new Thread() {
                public void run() {
                    gareen.hurt();
                    System.out.println("自伤!  " + gareen.getHp());

                }
            };
            hurtThreads[i] = t;
            t.start();
        }
        Thread.yield();
//        while (true){
//            System.out.println("主线程仍在运行");
//        }
    }

    private static void joinTest() {
        final Hero gareen = new Hero("盖伦", 1000, 50);
        final Hero teemo = new Hero("提莫", 100000000, 50);
        final Hero leesin = new Hero("盲僧", 1000, 50);

        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        gareen.attackHero(teemo);
                    } catch (EnemyHeroIsDeadException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                while (true) {
                    try {
                        leesin.attackHero(teemo);
                    } catch (EnemyHeroIsDeadException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        };
        t1.start();
        t2.start();
        System.out.println("现在是主线程");
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("t1被中断了");
        }
        System.out.println("现在是主线程");
    }

    private static void sleepTest() {
        Thread thread = new Thread() {
            public void run() {
                int seconds = 0;
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //return;
                    }
                    System.out.printf("已经玩了LOL %d 秒%n", seconds++);
                }
            }
        };
        thread.start();
    }
}
