package Generics;

import java.util.ArrayDeque;

public class Jar<T> {
    private final ArrayDeque<T> arrayDeque;

    public Jar() {
        this.arrayDeque = new ArrayDeque<>();
    }

    public void add(T element) {
        arrayDeque.push(element);
    }

    public T remove() {
        return arrayDeque.pop();
    }
}
