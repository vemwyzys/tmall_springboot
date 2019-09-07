package javaTest.pojo;

public class HeroAboutGC {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
