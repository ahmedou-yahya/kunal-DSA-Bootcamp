package oop.generics;

import java.util.Arrays;
import java.util.List;

public class WildCardExample<T extends Number> {

    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public WildCardExample(){
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

    public void getList(List<? extends Number> list){
        System.out.println(list);
    }

    @Override
    public String toString() {
        return "CustomArrayListWithGenerics{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        WildCardExample generics = new WildCardExample();
        generics.add(56);
        generics.add(45);
        System.out.println(generics);
        generics.remove();
        System.out.println(generics);
        generics.add(45.9);
        System.out.println(generics);
        System.out.println(generics.size());
        System.out.println(generics.get(0));

    }
}
