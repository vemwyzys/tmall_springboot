package javaTest.pojo;

/**
 * 继承抽象类之后，这些子类就必须提供不一样的抽象方法实现。
 */
public class APHeroFromHeroAbstract extends HeroAbstract {
    @Override
    public void whisper() {
        System.out.println("APHeroFromHeroAbstract haha");
    }
}
