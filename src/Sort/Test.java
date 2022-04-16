package Sort;

import java.math.BigDecimal;
import java.util.*;


class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(2);
        head.next = head2;
        head2.next = head3;
        ListNode res = sortList(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        if(head == null) return null;
        return mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode mid = middleNode(head);
        ListNode l1 = mergeSort(mid.next);
        mid.next = null;
        ListNode l2 = mergeSort(head);
        return mergeTwoLists(l1,l2);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }else{
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}