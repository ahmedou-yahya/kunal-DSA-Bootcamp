package oop;

public class SingletonClass {

    private SingletonClass(){

    }
    private static SingletonClass instance;

    public static SingletonClass getInstance() {
        if(instance==null){
            return new SingletonClass();
        }

        return instance;
    }
}
