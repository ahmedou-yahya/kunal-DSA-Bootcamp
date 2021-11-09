package oop;

public class Main {

    public static void main(String[] args) {
        SingletonClass singletonClass = SingletonClass.getInstance();
        SingletonClass singletonClass1 = SingletonClass.getInstance();
        System.out.println(singletonClass);
        System.out.println(singletonClass1);
    }
}
