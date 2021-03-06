package javaTest.pojo;

import java.io.Serializable;

public class Hero implements Serializable, Comparable {

    public String name;

    protected float hp;

    float armor;

    int moveSpeed;

    int damage;
    /**
     * 类属性，静态属性
     */
    public static String copyright = "版权由Riot Games公司所有";

    //实例化一个对象的时候，一定会使用其构造方法
    //没有返回类型
    //如果没有，则默认提供一个
    public Hero() {
        System.out.println("实例化一个对象的时候，必然调用构造方法");
    }

    public Hero(String name) {
        this.name = name;
    }

    //构造方法的重载
    public Hero(String name, float hp) {
        this.name = name;
        this.hp = hp;
        System.out.println("实例化一个对象的时候，必然调用构造方法");
    }

    //构造方法的重载(使用了上面的构造方法
    public Hero(String name, float hp, float armor, int moveSpeed) {
        this(name, hp);
        this.armor = armor;
        this.moveSpeed = moveSpeed;
    }

    public Hero(String name, float hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public int getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(int moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    //打印内存中的虚拟地址
    public void showAddressInMemory() {
        System.out.println("打印this看到的虚拟地址：" + this);
    }

    public void attack(Hero hero, int damage) throws EnemyHeroIsDeadException {
        if (hero.hp == 0) {
            throw new EnemyHeroIsDeadException(hero.name + "已经死了,不能再进行攻击了");
        }
        hero.setHp(hero.getHp() - damage);
        System.out.println(this.name + "攻击了" + hero.getName() + "使后者掉了" + damage + "点血" + ",现在" + hero.getName() + "还有" + hero.getHp() + "多少点血");
    }

    public static void battleWin() {
        System.out.println("hero比赛赢了");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("触发垃圾回收");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", armor=" + armor +
                ", moveSpeed=" + moveSpeed +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Hero h = (Hero) o;
        if (hp > h.hp)
            return 1;
        else return -1;
    }

    private boolean isDead() {
        return this.hp <= 0 ? true : false;
    }

    public void attackHero(Hero h) throws EnemyHeroIsDeadException{
        h.hp -= damage;
        System.out.printf("%s在攻击%s,%s的血变成了%.0f %n", name, h.name, h.name, h.hp);
        if (h.isDead()) {
            throw new EnemyHeroIsDeadException(h.name + "已经死了,不能再进行攻击了");
        }
    }

    public void recover(){
        hp++;
    }

    public void hurt(){
        synchronized (this){
            hp--;
        }
    }
}
