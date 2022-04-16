package LeetCode;

public class Solution876 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;


        System.out.println(middleNode(node1).val);
    }

    public static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

