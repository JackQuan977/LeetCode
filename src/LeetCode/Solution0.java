package LeetCode;

public class Solution0 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = orderList(l1);

        while (l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }

    public static ListNode orderList(ListNode head){
        if (head == null){
            return null;
        }
        ListNode evenHead = evenOddList(head);
        ListNode newEvenOrder = reverse(evenHead);
        return mergeTwoLists(head, newEvenOrder);

    }


    public static ListNode evenOddList(ListNode head){
        if (head == null){
            return null;
        }

        ListNode odd = head, even = head.next;
        ListNode evenHead = head.next;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }
        return evenHead;
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
