package oop.shallowVSdeepcoying;

public class Human implements Cloneable{

    int age;
    String name;

    public Human(int age, String name){
        this.age = age;
        this.name = name;
    }

    // This is shallow copying:
    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
