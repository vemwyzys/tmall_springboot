package javaTest.pojo;

//支援英雄
public class SupportHero extends Hero {
    public void heal() {
        System.out.println("对自己进行了治疗");
    }

    public void heal(Hero hero) {
        System.out.println("给英雄" + hero.getName() + "加血");
    }

    public void heal(Hero hero, int hp) {
        System.out.println("给英雄" + hero.getName() + "加了" + hp + "血");
    }

}
