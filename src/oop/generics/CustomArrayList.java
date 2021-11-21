package oop.generics;

import java.util.ArrayList;

public class CustomArrayList {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArrayList(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull() {
        return size==data.length;
    }

    private void resize(){
        int[] temp = new int[data.length*2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    public void remove(int num){
        int[] temp = new int[data.length];
        int i=0, j=0;
        while (j< data.length){
            if (data[j]==num){
                j++;
                size--;
            }
            else {
                temp[i]=data[j];
                i++;
                j++;
            }
        }
        temp = data;
    }

}
