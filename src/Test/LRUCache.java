package Test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DListNode{
        int key;
        int value;
        DListNode pre;
        DListNode next;
        public DListNode(){}
        public DListNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DListNode> map = new HashMap<>();
    private DListNode head;
    private DListNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        head = new DListNode();
        tail = new DListNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        DListNode node = map.get(key);
        if (node == null){
            return -1;
        }
        moveToFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        DListNode node = map.get(key);
        if (node == null){
            DListNode newNode = new DListNode(key, value);
            map.put(key, newNode);
            addFirst(newNode);
            size++;
            if (size > capacity){
                DListNode tail = removeTail();
                map.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToFirst(node);
        }
    }

    // 将一个节点添加到第一个,可用于添加一个新节点到第一个，也可用于更改一个节点后将其删除再添加到第一个
    private void addFirst(DListNode node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    // 删除一个节点，可以用于淘汰最后一个节点或者更改一个节点后将其删除再加到第一个
    private void removeNode(DListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    // 将一个已经存在的节点移动到第一个
    private void moveToFirst(DListNode node){
        removeNode(node);
        addFirst(node);
    }

    // 淘汰尾部节点，因为还要依此删除hash表中节点，所以要有一个返回值
    private DListNode removeTail(){
        DListNode res = tail.pre;
        removeNode(res);
        return res;
    }
}
