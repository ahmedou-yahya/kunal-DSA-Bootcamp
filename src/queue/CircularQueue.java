package queue;

import java.util.PriorityQueue;

public class CircularQueue {

    private int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int front=0;
    private int end=0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }
    public CircularQueue(int size){
        data = new int[size];
    }

    public boolean insert(int val){
        if (isFull()){
            System.out.println("The queue is full");
            return false;
        }
        data[end] = val;
        end = (end+1)% data.length;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new QueueException("Queue is empty");
        }
        int removed = data[front];
        front = (front+1)% data.length;
        return data[front];
    }

    public int front() throws Exception{
        if (isEmpty())
            throw new QueueException("Queue is empty!!!");

        return data[front];
    }

    private boolean isFull() {
        return end==front;
    }

    private boolean isEmpty(){
        if(front-1==end || (front==0 && end== data.length-1))
            return true;

        return false;
    }
}
