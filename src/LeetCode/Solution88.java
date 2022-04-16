package LeetCode;

public class Solution88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {3,4,6};
        merge(nums1,3,nums2,3);
        for(int i : nums1){
            System.out.println(i);
        }
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p--] = nums1[p1--];
            }else{
                nums1[p--] = nums2[p2--];
            }
        }
        System.arraycopy(nums2,0,nums1,0,p2 + 1);
    }
}
