package LeetCode;

public class Solution98 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        System.out.println(isValid(node1));
    }

    static long pre = Long.MIN_VALUE;
    public static boolean isValid(TreeNode root){
        if (root == null) {
            return true;
        }

        if (!isValid(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValid(root.right);
    }
}
