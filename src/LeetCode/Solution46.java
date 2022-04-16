package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    private static List<List<Integer>> res;
    private static LinkedList<Integer> track;
    public static List<List<Integer>> permute(int[] nums){
        res = new LinkedList<>();
        track = new LinkedList<>();
        backtrack(nums);
        return res;

    }

    public static void backtrack(int[] nums){
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,4,5};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }
}
