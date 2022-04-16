package LeetCode;

import DataStructure.TreeNode;

import java.util.*;

public class Solution144 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        List<Integer> res = preOrder(node1);
        Iterator iterator = res.iterator();
        while (iterator.hasNext()){
            int i = (int)iterator.next();
            System.out.println(i);
        }
    }
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(res == null) return res;
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null || !stack.isEmpty()){
            while (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
