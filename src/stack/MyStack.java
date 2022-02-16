package stack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    private int top;
    public MyStack() {

    }

    public void push(int x) {
        queue1.add(x);
        top = x;
    }

    public int pop() {
      while (queue1.size()>1){
          top = queue1.remove();
          queue2.add(top);
      }
      int res = queue1.remove();
      Queue<Integer> temp = queue1;
      queue1 = queue2;
      queue2 = temp;
      return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}

class Main{

    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(5);
        int param_2 = obj.pop();
        System.out.println(param_2);
        int param_3 = obj.top();
        System.out.println(param_3);
        boolean param_4 = obj.empty();
        System.out.println(param_4);
    }
}
