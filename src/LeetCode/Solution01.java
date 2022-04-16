package LeetCode;

import java.util.HashMap;

public class Solution01 {
    public static void main(String[] args) {
        int[] arrs ={0,2,3};
        int[] res = twosum(arrs,5);
        for(int i : res){
            System.out.println(i);
        }
    }
    public static int[] twosum(int[] nums, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
        }
        return new int[0];
    }
}
