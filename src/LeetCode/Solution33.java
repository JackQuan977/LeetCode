package LeetCode;

public class Solution33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,0,1,2,3};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left);
            if (nums[mid] == target){
                return mid;
            }

            if (nums[mid] >= nums[left]){
                if (target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target < nums[right]){
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
