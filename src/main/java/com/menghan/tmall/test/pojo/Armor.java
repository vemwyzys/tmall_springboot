package com.menghan.tmall.test.pojo;

public class Armor extends Item{

    //护甲等级
    int ac;

    public int getAc() {
        return ac;
    }

    public void setAc(int ac) {
        this.ac = ac;
    }

    @Override
    public String toString() {
        return "Armor{" +
                "ac=" + ac +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
