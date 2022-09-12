package IteratorsAndComparators.Exercise.LinkedListTraversal;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedListTraversal<T> implements Iterable<T> {
    private final ArrayDeque<T> deque;

    public LinkedListTraversal() {
        this.deque = new ArrayDeque<>();
    }

    public void add(T element) {
        deque.offer(element);
    }

    public boolean remove(T element) {
        if (deque.contains(element)) {
            deque.remove(element);
            return true;
        }
        return false;
    }

    public int getSize() {
        return this.deque.size();
    }

    @Override
    public Iterator<T> iterator() {
        return deque.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
