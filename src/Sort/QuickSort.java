package Sort;

public class QuickSort {
    public static void main(String[] args){
        int[] arrs = {5,53,53,34,234,45,5345,234,234};
        quickSort(arrs, 0, 8);
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }

    public static void quickSort(int[] arrs, int L, int R){
        int i = L;
        int j = R;
        int pivot = arrs[(L + R) / 2];

        while (i <= j){
            while (arrs[i] < pivot){
                i++;
            }

            while (arrs[j] > pivot){
                j--;
            }

            if(i <= j){
                int temp = arrs[i];
                arrs[i] = arrs[j];
                arrs[j] = temp;
                i++;
                j--;
            }
        }

        if(L <= j)
            quickSort(arrs, L, j);
        if(i <= R)
            quickSort(arrs, i, R);
    }
}
