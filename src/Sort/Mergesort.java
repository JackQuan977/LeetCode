package Sort;

import java.util.Arrays;

public class Mergesort {
    public static void main(String[] args) {
        int[] arr = {1,232,12,54,0};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arrs, int left, int right, int[] temp) {
        if (left == right) {
            return;
        }
        int mid = (left +right) / 2;
        sort(arrs, left, mid, temp);
        sort(arrs, mid + 1, right, temp);
        merge(arrs, left, mid, right, temp);
    }

    private static void merge(int[] arrs, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arrs[i] <= arrs[j]) {
                temp[k++] = arrs[i++];
            } else {
                temp[k++] = arrs[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arrs[i++];
        }

        while (j <= right) {
            temp[k++] = arrs[j++];
        }

        k = 0;
        while (left <= right) {
            arrs[left++] = temp[k++];
        }
    }
}
