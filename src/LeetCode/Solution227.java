package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution227 {
    public static void main(String[] args) {
        System.out.println(calculate("2 + 3 * 4"));
    }

    public static int calculate(String s){
        Deque<Integer> stack = new LinkedList<>();
        int n = s.length();
        char preSign = '+';
        int num = 0;

        for (int i = 0; i < n; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
