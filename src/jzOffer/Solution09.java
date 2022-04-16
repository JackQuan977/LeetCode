package jzOffer;

import java.util.Stack;

public  class Solution09 {
    private  Stack<Integer> stack_in;
    private  Stack<Integer> stack_out;


    public Solution09(){
        stack_in = new Stack<>();
        stack_out = new Stack<>();
    }
    public  void appendTail(int value){
        stack_in.push(value);
    }

    public  int deleteHead(){
        if(stack_out.isEmpty()){
            while (!stack_in.isEmpty()){
                stack_out.push(stack_in.pop());
            }
        }

        if(stack_out.isEmpty()) return -1;
        else return stack_out.pop();
    }
}
 class Test{
     public static void main(String[] args) {
         Solution09 queue = new Solution09();
         queue.appendTail(1);
         queue.appendTail(2);
         queue.appendTail(3);

         for(int i = 0; i < 3; i++){
             System.out.println(queue.deleteHead());
         }
     }
}