package LeetCode;

public class Solution69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(9));
    }
    public static int mySqrt(int x) {
        long left = 0;
        long right = x;

        while(left <= right){
            long mid = left + (right - left) / 2;
            if(mid * mid > x){
                right = mid - 1;
            }else if(mid * mid <= x){
                left = left + 1;
            }
        }
        return (int)right;
    }
}

