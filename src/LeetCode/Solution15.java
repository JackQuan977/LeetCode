package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        int[] test = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(test));
    }
    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 3) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            while (left < right){
                if(nums[left] + nums[right] == target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(nums[left] + nums[right] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
