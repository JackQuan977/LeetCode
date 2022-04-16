package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution155 {
    public static void main(String[] args) {
        MinStack test = new MinStack();
        test.push(3);
        test.push(-1);
        test.push(10);
        test.push(0);
        System.out.println(test.getMin());
    }
}

class MinStack{
    private Deque<Integer> stack;
    private Deque<Integer> min_stack;
    public MinStack(){
        stack = new LinkedList<>();
        min_stack = new LinkedList<>();
    }

    public void push(int val){
        stack.push(val);
        if(min_stack.isEmpty() || val <= min_stack.peek())
            min_stack.push(val);
    }

    public void pop(){
        if(stack.pop().equals(min_stack.peek()))
            min_stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min_stack.peek();
    }
}