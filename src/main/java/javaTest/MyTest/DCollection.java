package javaTest.MyTest;

import javaTest.pojo.Hero;

import java.util.*;

public class DCollection {

    public static void main(String[] args) {

        List heros = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("a" + i, i * 100));
        }
        System.out.println(heros.size());

        //为了不使编译器出现警告，需要前后都使用泛型
        //后面的泛型可以用<>来代替
        List<Hero> list = new ArrayList<>();

        for (int i = 0; i < heros.size(); i++) {
            System.out.println(heros.get(i));

        }

        Iterator<Hero> it = heros.iterator();
        while (it.hasNext()) {
            Hero h = it.next();
            System.out.println(h);
        }
        for (Iterator<Hero> iterator = heros.iterator(); iterator.hasNext(); ) {
            Hero next = iterator.next();
            System.out.println(next);
        }

        for (Hero h :
                list) {
            System.out.println(h);
        }

        /**
         * 首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
         * hero 0
         * hero 1
         * hero 2
         * ...
         * hero 99.
         *
         * 通过遍历的手段，删除掉名字编号是8的倍数的对象
         */
        //delete();

        //性能比较
        ArrayListVSHashMap();

        HashMap<String, Hero> hashMap = new HashMap<>(120);
        for (int i = 0; i < 120; i++) {
            hashMap.put("" + i, new Hero("" + new Random().nextInt(100)));
        }
        System.out.println(hashMap.get("10"));
    }

    private static void ArrayListVSHashMap() {
        System.out.println(new Random().nextInt(10000));
        int capacity = 3000000;
        List<Hero> list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add(new Hero("" + new Random().nextInt(10000)));
        }
        HashMap<String, List<Hero>> map = new HashMap<>();

        //名字作为key
        //名字相同的hero，放在一个List中，作为value
        for (Hero h :
                list) {
            List<Hero> heroes = map.get(h.name);
            if (heroes == null) {
                heroes = new ArrayList<>();
                map.put(h.name, heroes);
            }
            heroes.add(h);
        }
        System.out.println("开始查找");
        findByForeach(list);
        findByIteration(list);
        findByMap(map);
        System.out.println("查找结束");

    }

    private static void findByForeach(List<Hero> list) {
        long start = System.currentTimeMillis();
        ArrayList<Hero> heroes = new ArrayList<>();
        for (Hero h :
                list) {
            if (h.getName().equals("8")) {
                heroes.add(h);
            }
        }
    }

    private static void findByIteration(List heros) {
        long start = System.currentTimeMillis();
        ArrayList<Hero> list = new ArrayList<>();
        for (Iterator<Hero> iterator = heros.iterator(); iterator.hasNext(); ) {
            Hero hero = iterator.next();
            if ("8".equals(hero.getName())) {
                list.add(hero);
            }
        }
        for (Hero h :
                list) {
            System.out.println(h);
        }
    }

    private static void findByMap(HashMap<String, List<Hero>> map) {

    }

    private static void delete() {
        List<Hero> list = new ArrayList<>(100);
        int num = 100;
        for (int i = 0; i < num; i++) {
            list.add(new Hero("hero" + i, 100));
        }
        for (Hero h :
                list) {
            System.out.println(h.getName());
        }
        List<Hero> deleteList = new ArrayList<>(10);
        for (Hero h :
                list) {
            int id = Integer.parseInt(h.getName().substring(3));
            if (0 == id % 8) {
                deleteList.add(h);
            }
        }
        for (Hero h :
                deleteList) {
            list.remove(h);
        }
        for (Hero h :
                list) {
            System.out.println(h.getName());
        }
    }
    //list查找的低效率

}
