package oop.generics.lambdafunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LambdaFunctions{

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <=10 ; i++) {
            list.add(i);
        }

        Consumer<Integer> fun = (item) -> System.out.println(item*2);
        list.forEach(fun);

        Operation sum = (a,b) -> a+b;
        Operation prod = (a,b) -> a*b;
        Operation sub = (a,b) -> a-b;

        LambdaFunctions myCalculator = new LambdaFunctions();
        System.out.println(myCalculator.operate(2,3,sum));
        System.out.println(myCalculator.operate(2,3,prod));
        System.out.println(myCalculator.operate(2,3,sub));
    }

    public int operate(int a, int b, Operation op){
        return op.operation(a, b);
    }
}

interface Operation {
    int operation(int a, int b);
}
