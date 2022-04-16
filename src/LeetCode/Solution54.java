package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    public static void main(String[] args) {
        int[][] arrs = {{1,2,4},{3,4,4},{3,3,3}};
        List<Integer> res = spiralOrder(arrs);
        System.out.println(res);
    }

    public static List<Integer> spiralOrder(int[][] nums){
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0) return res;

        int left = 0, right = nums[0].length - 1;
        int top = 0, bottom = nums.length - 1;

        while (true){
            for(int i = left; i <= right; i++) res.add(nums[top][i]);
            if(++top > bottom) break;

            for (int i = top; i <= bottom; i++) res.add(nums[i][right]);
            if(--right < left) break;

            for(int i = right; i >= left; i--) res.add(nums[bottom][i]);
            if(--bottom < top) break;

            for (int i = bottom; i >= top; i--) res.add(nums[left][i]);
            if(++left > right) break;
        }
        return res;
    }
}
