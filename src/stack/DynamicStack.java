package stack;

public class DynamicStack {

    protected int[] data;
    private static final int DEFAULT_SIZE=10;
    private int top=-1;

    public DynamicStack(){
        data = new int[DEFAULT_SIZE];
    }

    public boolean push(int val){
        if (isFull()){
            int[] newData = new int[2* data.length];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
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
