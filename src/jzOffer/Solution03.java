package jzOffer;

public class Solution03 {
    public static void main(String[] args) {
        int[] test = {0,3,1,1};
        System.out.println(findLeast(test));
    }
    public static int findLeast(int[] nums){
        for(int i = 0; i < nums.length; i++){
            while (nums[i] != i){
                if (nums[i] == nums[nums[i]])
                    return nums[i];
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
