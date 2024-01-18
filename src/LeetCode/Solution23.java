package LeetCode;

import DataStructure.ListNode;

public class Solution23 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node3.next = node4;
        ListNode[] lists = {node1,node3};
        ListNode res = mergeK(lists);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode mergeK(ListNode[] lists){
        if(lists.length == 0 || lists == null) return null;
        return merge(lists,0,lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid + 1,right);
        return mergeTwoLists(l1,l2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(l1 != null && l2 != null){
            if(l1.val  < l2.val){
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

}

