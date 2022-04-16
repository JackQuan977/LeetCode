package LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution295 {
    Queue<Integer> A;
    Queue<Integer> B;

    public Solution295(){
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x,y) -> (y - x));
    }

    public void addNum(int num){
        if(A.size() == B.size()){
            B.offer(num);
            A.offer((B.poll()));
        }else {
            A.offer(num);
            B.offer(A.poll());
        }
    }

    public double getMedium(){
        return A.size() != B.size() ? A.peek() : (A.peek() + B.peek()) / 2.0;
    }
}
