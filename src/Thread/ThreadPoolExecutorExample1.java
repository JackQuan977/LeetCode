package Thread;

/**
 * @author: quanli
 * @description: TODO
 * @date: 2024/3/26 16:49
 * @version: 1.0
 */
public class ThreadPoolExecutorExample1 {
    public static void main(String[] args) {
        // 记录开始执行的时间
        long startTime = System.currentTimeMillis();

        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
                {26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35},
                {36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45},
                {46, 47, 48, 49, 50}
        };

        // 逐个数组求和
        int[] sums = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            int sum = 0;
            for (int num : arrays[i]) {
                sum += num;
            }
            sums[i] = sum;
            System.out.println("Sum of array " + (i + 1) + ": " + sum);
        }

        // 记录结束执行的时间
        long endTime = System.currentTimeMillis();

        // 计算执行总耗时
        long totalTime = endTime - startTime;
        System.out.println("Total execution time: " + totalTime + " milliseconds");
    }
}
