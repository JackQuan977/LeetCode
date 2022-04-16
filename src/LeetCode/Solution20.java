package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution20 {
    public static void main(String[] args) {
        System.out.println(isValid("((())"));
    }
    public static boolean isValid(String s){
        if(s.length() == 0) return true;
        Deque<Character> stack = new LinkedList<>();
        for(char c : s.toCharArray()){
            if(c == '{'){
                stack.push('}');
            }else if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c != stack.pop() && stack.isEmpty()){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
