package LeetCode;

public class Solution25 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode res = reverseKth(node1,2);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }

    public static ListNode reverseKth(ListNode head, int k){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;

        while(end.next != null){
            for(int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null) break;
            ListNode next = end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

