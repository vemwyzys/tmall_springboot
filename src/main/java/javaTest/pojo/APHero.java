package javaTest.pojo;

import javaTest.myInterface.AP;

public class APHero extends Hero implements AP {
    @Override
    public void magicAttack() {
        System.out.println("进行了魔法攻击");
    }

    //构造函数不继承，派生类会自动调用基类构造函数。

    public APHero() {
        super();
    }

    public APHero(String name, float hp) {
        super(name, hp);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if (!(obj instanceof APHero)){
            return false;
        }
        /*if (this.name == ((APHero) obj).getName()){
            return true;
        }else {
            return false;
        }*/
        //上面的注释,等于下面这行
        return this.name.equals(((APHero) obj).getName());
    }
}
