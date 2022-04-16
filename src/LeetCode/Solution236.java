package LeetCode;

public class Solution236 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(4);

        node1.left = node2;
        node1.right = node3;

        TreeNode ancestor = getAncestor(node1, node2, node3);
        System.out.println(ancestor.val);
    }


    public static TreeNode getAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)  return null;
        if(root == p || root == q) return root;

        TreeNode left = getAncestor(root.left, p, q);
        TreeNode right = getAncestor(root.right,p , q);

        if(left == null) return right;
        if (right == null) return left;

        return root;
    }
}
