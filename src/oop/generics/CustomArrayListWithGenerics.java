package oop.generics;

import java.util.Arrays;
import java.util.Vector;

public class CustomArrayListWithGenerics<T> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayListWithGenerics(){
        //The line bellow gives a compile time error:
        // when the compiler tries to generate the byte code for T(Type parameters), he gets confused.
//        this.data = new T[DEFAULT_SIZE];

        this.data = new Object[DEFAULT_SIZE];
    }

    public void add(T t){
        if (isFull()){
            resize();
        }
        data[size++] = t;
    }

    private void resize() {
        Object[] temp = new Object[data.length*2];
        for(int i=0; i< data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public T remove(){
        return (T) data[--size];
    }

    public int size(){
        return size;
    }

    public T get(int index){
        return (T) data[index];
    }

    @Override
    public String toString() {
        return "CustomArrayListWithGenerics{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArrayListWithGenerics generics = new CustomArrayListWithGenerics();
        generics.add(56);
        generics.add("ahmedou");
        System.out.println(generics);
        generics.remove();
        System.out.println(generics);
        generics.add("yahya");
        System.out.println(generics);
        System.out.println(generics.size());
        System.out.println(generics.get(0));

    }
}
