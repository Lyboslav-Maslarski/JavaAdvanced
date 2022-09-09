package WorkshopCustomDataStructures;

import java.util.Iterator;

public class MyStack<E> implements Iterable<E> {


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

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node<E> current = top;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                current = current.prev;
                return element;
            }
        };
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

    public int getSize() {
        return size;
    }

    private void ensureNotEmpty() {
        if (this.top == null) {
            throw new IllegalStateException("Cannot execute on empty stack.");
        }
    }
}
