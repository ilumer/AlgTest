package leetcode.medium;

import java.util.*;

public class LeetCode146 {

    class LRUCache3 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache3(int capacity) {
            // 默认是插入的方式来实现的顺序的
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }


    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));    // 返回 4

    }

    public static class LRUCache {

        class Node {
            private Node pre;
            private Node next;
            private int value;

            private int key;

        }

        private Map<Integer, Node> map;

        private Node head;

        private Node tail;

        private int capacity;

        private int size = 0;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
            this.capacity = capacity;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            } else {
                // 移动到头节点
                moveToHead(node);
                return node.value;
            }
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                // 这里不是一个新的节点
                removeOldNode(node);
            } else {
                node = new Node();
                node.value = value;
                node.key = key;
                size++;
            }
            map.put(key, node);
            // 添加新的节点并且移动到头节点
            addNodeToHead(node);
            if (size > capacity) {
                size--;
                map.remove(tail.pre.key);
                removeOldNode(tail.pre);
            }
        }

        private void  moveToHead(Node node){
            removeOldNode(node);
            addNodeToHead(node);
        }


        /**
         * head.next -> node.next -> x
         * x.pre->node.pre->head
         * 减少一个节点 node
         * head.next -> x
         * x.pre-> head
         * @param node
         */
        private void removeOldNode(Node node) {
            Node pre = node.pre;
            Node next = node.next;
            pre.next = next;
            next.pre = pre;
        }

        /**
         * head.next -> x
         * x.pre-> head
         * 新加一个节点 node
         * head.next -> node.next -> x
         * x.pre->node.pre->head
         * @param node
         */
        public void addNodeToHead(Node node) {
            node.next = head.next;
            head.next.pre=node;
            head.next = node;
            node.pre = head;
        }
    }
}
