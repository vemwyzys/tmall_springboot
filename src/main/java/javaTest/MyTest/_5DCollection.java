package javaTest.MyTest;

import javaTest.pojo.ADHero;
import javaTest.pojo.Hero;
import org.aspectj.weaver.Checker;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class _5DCollection {

    public static void main(String[] args) {

        ArrayListMethod(false);

        //首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从hero 0 hero 1 hero 2 hero 99 通过遍历的手段，删除掉名字编号是8的倍数的对象
        delete(false);

        LinkedListMethod(false);


        setMethod(false);

        //性能比较
        //ArrayList查找的迭代查找很慢,  foreach更快,  hashmap超快
        ArrayListVSHashMap(false);


        //map的entrySet()得到set       这个set是map中键值对的对应关系
        HashMapMethod(false);


        //Collections工具类
        CollectionsMethod(false);


        //HashSet  LinkedHashSet  TreeSet
        ThreeSetMethod(false);


        //利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
        LinkedHashSetMethod(false);


        //比较器      或者在Hero内部提供compareTo方法!
        ComparatorMethod(false);

        //泛型
        ArrayListMethod2(true);

        //找出符合条件的元素的三种方法
        ArrayListMethod3(true);
    }

    private static void ArrayListMethod3(boolean b) {
        //建立容器
        List<Hero> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(new Hero("" + i, 100 * i, 33 * i, 77 * i));
        }
        //方法一
        System.out.println("普通遍历");
        for (Hero h :
                list) {
            if (h.getHp() > 500 && h.getMoveSpeed() > 200) {
                System.out.println(h+"\n");
            }
        }
        //匿名类
        HeroChecker checker = new HeroChecker(){
            @Override
            public boolean test(Hero h) {
                return h.getHp() > 500 && h.getMoveSpeed() > 200;
            }
        };
        System.out.println("匿名类遍历");
        for (Hero h :
                list) {
            if (checker.test(h)){
                System.out.println(h+"\n");
            }
        }
        //Lambda方式
        list= list.stream().filter(h -> h.getHp() > 500 && h.getMoveSpeed() > 200).collect(Collectors.toList());
        System.out.println("lambda");
        list.stream().forEach(h -> System.out.println(h));
    }

    private static void ArrayListMethod2(boolean b) {
        ArrayList<? super Hero> list = new ArrayList<>();
        list.add(new ADHero());

        ArrayList<? extends ADHero> list2 = new ArrayList<>();
    }

    private static void setMethod(boolean b) {
        if (!b) {
            return;
        }
        HashSet<Object> set = new HashSet<>();
        new LinkedHashSet<>();
    }

    private static void ComparatorMethod(boolean b) {
        if (!b) {
            return;
        }
        ArrayList<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroes.add(new Hero("" + i));
        }
        Collections.shuffle(heroes);
        Comparator<Hero> c = new Comparator<Hero>() {
            @Override
            public int compare(Hero h1, Hero h2) {
                int num = h2.getName().compareTo(h1.getName());
                if (num >= 0) {
                    return 1;
                } else return -1;
            }
        };
        Collections.sort(heroes, c);
        System.out.println(heroes);
    }

    private static void LinkedHashSetMethod(boolean b) {
        if (!b) {
            return;
        }
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        double pi = Math.PI;
        String str = String.valueOf(pi);
        str = str.replace(".", "");//去除点
        char[] chars = str.toCharArray();
        for (char c :
                chars) {
            int num = Integer.parseInt(String.valueOf(c));
            result.add(num);
        }
        System.out.println(result);
    }

    private static void ThreeSetMethod(boolean b) {
        if (!b) {
            return;
        }
        HashSet<Integer> hashSet = new HashSet<>();//HashSet顺序不一定是插入顺序
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(48);
        hashSet.add(52);
        hashSet.add(96);
        hashSet.add(85);
        System.out.println(hashSet);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();//LinkedHashSet是按照插入顺序
        linkedHashSet.add(1);
        linkedHashSet.add(2);
        linkedHashSet.add(3);
        System.out.println(linkedHashSet);

        TreeSet<Object> treeSet = new TreeSet<>();  //TreeSet会排序
        treeSet.add(3);
        treeSet.add(2);
        treeSet.add(1);
        System.out.println(treeSet);
    }

    private static void CollectionsMethod(boolean b) {
        if (!b) {
            return;
        }
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        Collections.reverse(list1);//反转
        Collections.shuffle(list1);//洗牌
        Collections.swap(list1, 0, 8);//交换
        Collections.rotate(list1, 2);//向右滚动单位长度
        Collections.synchronizedList(list1);//转换成线程安全的list

        System.out.println("hahh");
    }

    private static void HashMapMethod(boolean b) {
        if (!b) {
            return;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            hashMap.put("" + i, new Random().nextInt(39));
        }
        Set<Map.Entry<String, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<String, Integer> me :
                entries) {
            System.out.println(me.getKey());
            System.out.println(me.getValue());
            System.out.println(me);
        }
    }

    private static void LinkedListMethod(boolean b) {
        if (!b) {
            return;
        }
        LinkedList<Hero> heroes = new LinkedList<>();

        //作为list
        heroes.add(new Hero());
        heroes.remove(new Hero());
        heroes.contains(new Hero());

        //作为Deque双向链表
        heroes.addLast(new Hero());//链表加在最后
        heroes.addFirst(new Hero());//链表加在最前

        heroes.getFirst();//查看最前面
        heroes.getLast();//查看最后面

        heroes.removeFirst();//取出最前面
        heroes.removeLast();//取出最后面

        //作为Queue接口(队列) FIFO
        heroes.offer(new Hero());//在最后添加元素
        heroes.poll();//取出第一个元素
        heroes.peek();//查看第一个元素

    }

    private static void ArrayListMethod(boolean b) {
        /**
         * 为了解决数组的局限性(数组长度固定,多了少了都不合适)，引入容器类的概念。 最常见的容器类就是
         * ArrayList
         * 容器的容量"capacity"会随着对象的增加，自动增长
         * 只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
         */
        if (!b) {
            return;
        }
        List heros = new ArrayList(10);
        for (int i = 0; i < 10; i++) {
            heros.add(new Hero("a" + i, i * 100));
        }
        System.out.println(heros.size());

        //常用方法
        heros.add(1);
        heros.get(0);
        heros.remove(0);
        heros.contains(1);
        heros.indexOf(1);
        heros.set(0, 1);
        heros.size();

        Hero[] array = (Hero[]) heros.toArray(new Hero[]{});//转换成数组 如果要转换为一个Hero数组，那么需要传递一个Hero数组类型的对象给toArray()，这样toArray方法才知道，你希望转换为哪种类型的数组，否则只能转换为Object数组

        heros.addAll(heros);
        heros.clear();


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
    }

    private static void ArrayListVSHashMap(boolean b) {
        if (!b) {
            return;
        }
        int capacity = 200000;
        List<Hero> list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add(new Hero("" + new Random().nextInt(capacity / 2)));
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
        for (Hero h :
                heroes) {
            System.out.println(h);
        }
        long end = System.currentTimeMillis();
        System.out.println("循环查找名称为'8'的Hero,用时:" + (end - start) + "毫秒");
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
        long end = System.currentTimeMillis();
        System.out.println("迭代查找名称为'8'的Hero,用时:" + (end - start) + "毫秒");
    }

    private static void findByMap(HashMap<String, List<Hero>> map) {
        long start = System.currentTimeMillis();
        ArrayList<Hero> list = new ArrayList<>();
        List<Hero> heroes = map.get("8");
        for (Hero h :
                heroes) {
            System.out.println(h);
        }
        long end = System.currentTimeMillis();
        System.out.println("hashmap的get查找名称为'8'的Hero,用时:" + (end - start) + "毫秒");
    }

    private static void delete(boolean b) {
        if (b) {
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
    }
}
