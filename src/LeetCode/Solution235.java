package LeetCode;

public class Solution235 {
    public static class TreeNode{
        int val;
        TreeNode left, right;
        public TreeNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(8);
        root.left = p;
        root.right = q;
        TreeNode ancestor = getAncestor(root,p,q);
        System.out.println(ancestor.val);
    }

    public static TreeNode getAncestor(TreeNode root, TreeNode p, TreeNode q){
        while (root != null){
            if (root.val > p.val && root.val > q.val){
                root = root.left;
            }else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else {
                break;
            }
        }
        return root;
    }
}
