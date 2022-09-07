package WorkshopCustomDataStructures;

import java.util.function.Consumer;

public class MyLinkedList {
    private static class Node {
        private final int element;
        private Node prev;
        private Node next;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node node = new Node(element);
        if (!isEmpty()) {
            node.next = head;
            head.prev = node;
        } else {
            this.tail = node;
        }
        this.head = node;
        this.size++;
    }

    public void addLast(int element) {
        if (isEmpty()) {
            addFirst(element);
            return;
        }
        Node newNode = new Node(element);
        this.tail.next = newNode;
        newNode.prev = tail;
        this.tail = newNode;
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);
        if (index == this.size - 1) {
            return this.tail.element;
        }
        Node node;
        if (index <= size / 2) {
            node = this.head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node.element;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from empty list.");
        }
        int element = this.head.element;
        this.head = this.head.next;
        this.size--;
        if (this.size == 0) {
            head = null;
            tail = null;
        } else {
            head.prev = null;
        }
        return element;
    }

    public int removeLast() {
        if (this.size == 0 || this.size == 1) {
            removeFirst();
        }
        int element = tail.element;
        tail = tail.prev;
        tail.next = null;
        this.size--;
        return element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node node = this.head;
        while (node.next != null) {
            consumer.accept(node.element);
            node = node.next;
        }

    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        int counter = 0;
        Node node = this.head;
        while (node.next != null) {
            arr[counter] = node.element;
            counter++;
            node = node.next;
        }
        return arr;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("No such index in the LinkedList" + index);
        }
    }
}
