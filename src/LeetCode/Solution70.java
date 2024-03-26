package LeetCode;

public class Solution70 {
    public static void main(String[] args) {
        Solution70 solution70 = new Solution70();
        System.out.println(solution70.climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        // 使用数组
//        int[] dp = new int[n + 1];
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        return dp[n];
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int current = first + second;
            first = second;
            second = current;
        }
        return second;
    }
}
