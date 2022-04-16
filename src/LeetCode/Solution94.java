package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        List<Integer> res = inOrder(node1);
        for(int i : res){
            System.out.println(i);
        }


    }
    public static List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();

        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
