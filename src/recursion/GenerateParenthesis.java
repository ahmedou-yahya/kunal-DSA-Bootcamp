package recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        System.out.println(list);
    }
    public static List<String> generateParenthesis(int n) {
        return generateParenthesis(2*n, "");
    }

    public static List<String> generateParenthesis(int n, String str) {

        if(n==0 && isValid(str)){
            List<String> list = new ArrayList<>();
            list.add(str);
            return list;
        }

        List<String> ans = new ArrayList<>();
        if (n==0)
            return ans;

        ans.addAll(generateParenthesis(n-1, str+"("));
        ans.addAll(generateParenthesis(n-1, str+")"));

        return ans;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');

            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }
}
