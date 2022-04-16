package jzOffer;

public class Solution36 {


    public static class Node{
        int val;
        Node left, right;

        public Node(){}
        public Node(int x){
            val = x;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        Node node2 = new Node(1);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        treeToList(node1);
        for(int i = 0; i < 3; i++){
            System.out.println(head.val);
            head = head.right;
        }

    }
    private static Node pre,head;
    public static Node treeToList(Node root){
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public static void dfs(Node cur){
        if(cur == null) return;
        dfs(cur.left);
        if(pre == null) head = cur;
        else pre.right = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
