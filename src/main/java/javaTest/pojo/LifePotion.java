package javaTest.pojo;

public class LifePotion extends Item {
    @Override
    public void buy() {
        super.buy();
    }

    @Override
    public void effect() {
        System.out.println("喝了血药,恢复了血量");
    }
}
