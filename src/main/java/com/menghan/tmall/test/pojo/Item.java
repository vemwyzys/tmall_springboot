package com.menghan.tmall.test.pojo;

public class Item {
    String name;
    int price;

    public void buy(){
        System.out.println("买了这个东西");
    }

    public void effect(){
        System.out.println("物品产生影响");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
