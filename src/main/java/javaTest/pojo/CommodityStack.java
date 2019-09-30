package javaTest.pojo;

import java.util.LinkedList;

public class CommodityStack<T> {

    LinkedList<T> values = new LinkedList<T>();

    public synchronized void push(T t){
        while (values.size()>=200){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        values.addLast(t);
    }

    public synchronized void pull(T t){
        while (values.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        values.removeLast();
    }
}
