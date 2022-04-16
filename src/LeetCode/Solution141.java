package LeetCode;

public class Solution141 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (true){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) break;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node2;

        System.out.println(hasCycle(node1));
    }
}
