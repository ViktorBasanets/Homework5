public class LRUCache {

    private Node first;
    private Node last;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        Node node = new Node();
        first = node;
        last = node;
        first.isFirst = true;
        last.isLast = true;
    }

    public int get(int key) {
        Node result = searchKey(key);
        return result.key == key ? result.value : -1;
    }

    public void put(int key, int value) {
        Node node = searchKey(key);

        if (node.prev == null && node.next == null) {
            if (size == capacity) {
                this.popLast();
            }
            node.key = key;
            node.value = value;
            this.putFirst(node);
            return;
        }

        node.value = value;

        if (node.isFirst) {
            return;
        }

        if (node.isLast) {
            node.next.prev = null;
            node.isLast = false;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.next = first;
        node.prev = null;
        node.isFirst = true;
        first.prev = node;
        first.isFirst = false;
        first = node;
    }

    private void putFirst(Node node) {
        node.next = first;

        if (first.isLast) {
            node.isLast = true;
        }

        node.isFirst = true;
        first.prev = node;
        first.isFirst = false;
        first = node;
        size++;
    }

    private int popLast() {
        last = last.prev;
        last.isLast = true;
        last.next = null;
        size--;
        return last.value;
    }

    private Node searchKey(int key) {

        if (size == 0) {
            return new Node();
        }

        Node node = first;

        while (!node.isLast) {
            node = node.next;
            if (node.key == key) {
                break;
            }
        }

        return node.isLast && node.key != key ? new Node() : node;
    }

    private class Node {

        private int value;
        private Node prev;
        private Node next;
        private int key;
        private boolean isFirst;
        private boolean isLast;

        private Node() {
            this.key = -1;
        }

        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}