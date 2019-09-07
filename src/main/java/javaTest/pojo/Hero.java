package javaTest.pojo;

public class Hero {

    public String name;

    protected float hp;

    float armor;

    int moveSpeed;
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

    public void attack(Hero hero, int damage) {
        hero.setHp(hero.getHp() - damage);
        System.out.println(this.name + "攻击了" + hero.getName() + "使后者掉了" + damage + "点血" + ",现在" + hero.getName() + "还有" + hero.getHp() + "多少点血");
    }

    public static void battleWin(){
        System.out.println("hero比赛赢了");
    }
}
