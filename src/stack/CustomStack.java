package stack;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    private int top=-1;

    public CustomStack(){
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size){
        data = new int[size];
    }

    public boolean push(int val){
        if (isFull()){
            System.out.println("Stack is full");
            return false;
        }
        top++;
        data[top] = val;
        return true;
    }

    public int pop() throws StackException{
        if (isEmpty())
            throw new StackException("Can not pop from empty stack");

        return data[top--];
    }

    public int peek() throws StackException{
        if (isEmpty())
            throw new  StackException("Can not pop from empty stack");

        return data[top];
    }

    private boolean isFull() {
        return top==data.length-1;
    }

    private boolean isEmpty(){
        return top==-1;
    }


}
