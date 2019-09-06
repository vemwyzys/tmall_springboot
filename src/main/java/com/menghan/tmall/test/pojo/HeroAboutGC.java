package com.menghan.tmall.test.pojo;

public class HeroAboutGC {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
