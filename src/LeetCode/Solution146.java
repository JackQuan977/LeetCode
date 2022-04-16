package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {
    class DListNode{
        int key;
        int value;
        DListNode pre;
        DListNode next;
        public DListNode() {};
        public DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DListNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DListNode head, tail;

    public Solution146(int capacity){
        this.size = 0;
        this.capacity = capacity;
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key){
        DListNode node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value){
        DListNode node = cache.get(key);
        if (node == null){
            DListNode newNode = new DListNode(key, value);
            cache.put(key, newNode);
            addFirst(newNode);
            size++;
            if (size > capacity){
                DListNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToFirst(node);
        }
    }

    private void addFirst(DListNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToFirst(DListNode node){
        removeNode(node);
        addFirst(node);
    }

    private DListNode removeTail(){
        DListNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
