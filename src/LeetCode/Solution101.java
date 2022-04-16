package LeetCode;

public class Solution101 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        System.out.println(isSymmetric(node1));

    }

    public static boolean isSymmetric(TreeNode root){
            return check(root,root);
    }

    public static boolean check(TreeNode node1, TreeNode node2){
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null || node1.val != node2.val) return false;

        return check(node1.left,node2.right) && check(node1.right,node2.left);
    }
}
