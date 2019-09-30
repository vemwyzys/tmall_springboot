package javaTest.pojo;

import java.util.LinkedList;

public class HeroStack {
    LinkedList<Hero> heroes = new LinkedList<>();
    public void push(Hero h){
        heroes.push(h);
    }
    public void pull(Hero h){
        heroes.poll();
    }

}
