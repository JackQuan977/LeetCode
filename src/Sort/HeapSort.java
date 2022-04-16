package Sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arrs = {1,342,42,534,5,453,11,2,2,3453,451,14};
        heapSort(arrs);
        System.out.println(Arrays.toString(arrs));
    }

    public static void heapSort(int[] arrs){
        int heapsize = arrs.length;
        buildMaxHeapify(arrs,heapsize);
        for(int i = arrs.length - 1; i >= 0; i--) {
            swap(arrs, 0, i);
            heapsize--;
            maxHeapify(arrs, 0, heapsize);
        }
    }

    public static void buildMaxHeapify(int[] arrs, int heapsize){
        for(int i = arrs.length / 2 - 1; i >= 0; i--){
            maxHeapify(arrs, i, heapsize);
        }
    }

    public static void maxHeapify(int[] arrs, int curRoot, int heapsize){
        int l = curRoot * 2 + 1, r = curRoot * 2 + 2;
        int max = curRoot;
        if(l < heapsize && arrs[l] > arrs[max])
            max = l;
        if(r < heapsize && arrs[r] > arrs[max])
            max = r;
        if (curRoot != max){
            swap(arrs, max, curRoot);
            maxHeapify(arrs, max, heapsize);
        }
    }

    public static void swap(int[] arrs, int i, int j){
        int temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }
}
