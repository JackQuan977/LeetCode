package LeetCode;

public class Solution92 {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int x){
            val = x;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right){
        if(head == null || left == right) return head;
        ListNode pre = null;
        ListNode cur = head;

        while (left - 1 > 0){
            pre = cur;
            cur = cur.next;
            left--;
            right--;
        }

        ListNode con = pre;
        ListNode tail = cur;

        while (right > 0){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            right--;
        }

        if(con != null){
            con.next = pre;
        }else{
            head = pre;
        }

        tail.next = cur;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        ListNode head = reverseBetween(node1,1,2);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
    }
}
