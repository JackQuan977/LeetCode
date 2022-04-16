package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int x){
        val = x;
    }
}

public class Solution111 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        System.out.println(minDepth(node1));

    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left == null && temp.right == null) return res;
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
            res++;
        }
        return res;
    }
}
