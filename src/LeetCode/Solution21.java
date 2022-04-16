package LeetCode;


public class Solution21 {
    static class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int x){
            val = x;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node3.next = node4;
        ListNode res = mergeTwoList(node1,node3);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null  && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
