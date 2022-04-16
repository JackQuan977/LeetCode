package LeetCode;

public class Solution160 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(7);
        ListNode c1 = new ListNode(100);
        ListNode c2 = new ListNode(78);
        a1.next = a2;
        a2.next = a3;
        a3.next = c1;
        c1.next = c2;
        b1.next = b2;
        b2.next = c1;

        ListNode temp = getNode(a1,b1);
        System.out.println("交界点是" + temp.val);

    }

    public static ListNode getNode(ListNode headA , ListNode headB){
        ListNode l1 = headA;
        ListNode l2 = headB;

        while (l1 != l2){
            l1 = l1 == null ? headB : l1.next;
            l2 = l2 == null ? headA : l2.next;
        }
        return l1;
    }

}
