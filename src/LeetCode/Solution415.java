package LeetCode;

public class Solution415 {
    public static void main(String[] args) {
        String s1 = "2838";
        String s2 = "2";
        System.out.println(addStrings(s1,s2));
    }
    public static String addStrings(String num1, String num2){
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;

        while (i >= 0 || j >= 0 || add == 1){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num1.charAt(j) - '0' : 0;
            int temp = x + y + add;
            add = temp / 10;
            res.append(temp % 10);
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
