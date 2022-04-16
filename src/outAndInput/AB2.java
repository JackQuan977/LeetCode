package outAndInput;

import java.util.Arrays;
import java.util.Scanner;

public class AB2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = sc.next();
        }
        Arrays.sort(str);
        for(int i = 0; i < str.length - 1; i++){
            System.out.print(str[i] + " ");
        }
        System.out.print(str[str.length - 1]);
    }
}
