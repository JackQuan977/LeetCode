package jzOffer;

public class Solution53 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,2,555,888};
        System.out.println(search(nums,2));
    }
    public static int search(int[] nums, int target){
        return find(nums,target) - find(nums,target -  1);
    }

    public static  int find(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid =  left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
        }
        return right;
    }
}
