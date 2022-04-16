package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {1,123,43,36,442,12,5345,531,13,13,123,31,32};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void bubbleSort(int[] nums){

        //外层循环控制循环趟数
        for(int i = 0; i < nums.length - 1; i++){
            int isChange = 0;
            for (int j = 0; j < nums.length - i - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isChange = 1;
                }
            }
            if(isChange == 0) break;
        }
    }
}
