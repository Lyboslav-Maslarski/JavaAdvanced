package WorkshopCustomDataStructures;

import java.util.function.Consumer;

public class MyStack<E> {
    private static class Node<T> {
        private final T element;
        private final Node<T> prev;

        public Node(T element, Node<T> prev) {
            this.element = element;
            this.prev = prev;
        }
    }

    private Node<E> top;
    private int size;

    public MyStack() {
    }

    public void push(E element) {
        this.top = new Node<>(element, this.top);
        this.size++;
    }

    public E pop() {
        ensureNotEmpty();
        E element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    public E peek() {
        ensureNotEmpty();
        return this.top.element;
    }

    public void forEach(Consumer<E> consumer) {
        Node<E> node = this.top;
        while (node != null) {
            consumer.accept(node.element);
            node = node.prev;
        }
    }

    public int getSize() {
        return size;
    }

    private void ensureNotEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
