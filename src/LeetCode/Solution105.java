package LeetCode;

import java.util.HashMap;

public class Solution105 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){};
        public TreeNode(int x){
            val = x;
        }
        public TreeNode(int x, TreeNode left, TreeNode right){
            val = x;
            this.left = left;
            this.right = right;
        }
    }

    private static HashMap<Integer,Integer> map;
    public static TreeNode buildTree(int[] preorder, int[] inorder){
        map = new HashMap<>();
        int n = preorder.length;
        for(int i = 0; i < n; i++){
            map.put(inorder[i],i);
        }

        return myBuildTree(preorder,inorder,0,n - 1, 0, n - 1);
    }

    public static TreeNode myBuildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right){
        if(pre_left > pre_right) return null;
        int pre_root = pre_left;
        int in_root = map.get(preorder[pre_root]);

        TreeNode root = new TreeNode(preorder[pre_root]);
        int size = in_root - in_left;

        root.left = myBuildTree(preorder,inorder,pre_left + 1,pre_left + size, in_left, in_root - 1 );
        root.right= myBuildTree(preorder,inorder,pre_left + size + 1,pre_right,in_root + 1, in_right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,2,1};
        int[] inorder = {2,3,1};
        TreeNode res = buildTree(preorder,inorder);
        System.out.println(res.val);
    }
}
