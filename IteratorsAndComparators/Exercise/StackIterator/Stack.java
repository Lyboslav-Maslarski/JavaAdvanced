package IteratorsAndComparators.Exercise.StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {
    private final ArrayDeque<T> arrayDeque;


    public Stack() {
        this.arrayDeque=new ArrayDeque<>();
    }

    public void push(T t) {
        this.arrayDeque.push(t);
    }

    public T pop() {
        if (arrayDeque.isEmpty()) {
            System.out.println("No elements");
            return null;
        }
        return this.arrayDeque.pop();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int counter = arrayDeque.size()-1;

            @Override
            public boolean hasNext() {
                return counter >= 0;
            }

            @Override
            public T next() {
                T element = arrayDeque.pop();
                counter--;
                arrayDeque.offer(element);
                return element;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
