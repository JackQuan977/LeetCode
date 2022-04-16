package LeetCode;

public class Solution53 {
    public static void main(String[] args) {
        int[] arrs = {1,2,-1,34,54,0};
        int res = maxSub(arrs);
        System.out.println(res);
    }

    public static int maxSub(int[] nums){
        int max = nums[0];
        int cur = nums[0];
        int pre = 0;
        for(int num : nums){
            cur = num;
            cur = Math.max(cur, pre + cur);
            max = Math.max(max, cur);
            pre = cur;
        }
        return max;
    }
}
