package LeetCode;

public class Solution142 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static ListNode getCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        ListNode res = getCycle(node1);
        System.out.println(res.val);
    }
}
