package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public static class TreeeNode{
        int val;
        TreeeNode left,right;
        public TreeeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        TreeeNode node1 = new TreeeNode(1);
        TreeeNode node2 = new TreeeNode(2);
        TreeeNode node3 = new TreeeNode(3);
        node1.left = node2;
        node1.right = node3;
        List<List<Integer>> res = levelOrder(node1);
        System.out.println(res);

    }

    public static List<List<Integer>> levelOrder(TreeeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
