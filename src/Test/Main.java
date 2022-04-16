package Test;

import java.util.*;
class stackQueue{
    public Deque<Integer> stack_in;
    public Deque<Integer> stack_out;

    public stackQueue(){
        stack_in = new LinkedList<>();
        stack_out = new LinkedList<>();
    }
    public void add(int val){
        stack_in.push(val);
    }

    public void poll(){
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }
        stack_out.pop();
    }

    public int peek(){
        if (stack_out.isEmpty()) {
            while (!stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }
        return stack_out.peek();
    }
}

public class Main{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入数字：");
        int option = input.nextInt();//read numerical value from input;
        System.out.println(option);
        System.out.println("请输入字符串1：");
        String string1 = input.nextLine();//read 1st string (this is skipped)
        System.out.println("请输入字符串2：");
        System.out.println(string1);
        String string2 = input.nextLine();//read 2nd string (this appears right after reading numerical value)
        System.out.println(string2);
    }
}