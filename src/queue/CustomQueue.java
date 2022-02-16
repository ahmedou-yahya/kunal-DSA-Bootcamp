package queue;

public class CustomQueue {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    private int end = -1;
    public CustomQueue(){
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size){
        data = new int[size];
    }

    public boolean insert(int val){
        if (isFull()){
            System.out.println("The queue is full");
            return false;
        }
        data[end++] = val;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new QueueException("Queue is empty");
        }
        int removed = data[0];

        for (int i = 1; i <= end; i++) {
            data[i-1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty())
            throw new QueueException("Queue is empty!!!");

        return data[0];
    }

    private boolean isFull() {
        return end==data.length-1;
    }

    private boolean isEmpty(){
        return end==-1;
    }
}
