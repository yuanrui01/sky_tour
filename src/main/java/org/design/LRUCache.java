package org.design;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 */
public class LRUCache {

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }

    private Node dummy = new Node(0,0);
    private int capacity;
    private Map<Integer, Node> k2n = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }
        node = new Node(key, value);
        k2n.put(key, node);
        pushFront(node);
        if (k2n.size() > capacity) {
            Node tail = dummy.prev;
            k2n.remove(tail.key);
            remove(tail);
        }
    }

    private Node getNode(int key) {
        if (!k2n.containsKey(key)) {
            return null;
        }
        Node node = k2n.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x) {
        x.prev = dummy;
        x.next = dummy.next;
        x.next.prev = x;
        dummy.next = x;
    }
}
