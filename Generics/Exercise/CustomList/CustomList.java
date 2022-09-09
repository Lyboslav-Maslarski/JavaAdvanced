package Generics.Exercise.CustomList;

import java.util.*;
import java.util.function.Consumer;

public class CustomList<T extends Comparable<T>> implements Iterable<T>{
    private final List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
//        T element1 = this.list.get(index1);
//        this.list.set(index1, this.list.get(index2));
//        this.list.set(index2, element1);
        Collections.swap(this.list, index1, index2);
    }

    public long countGreaterThan(T element) {
        return this.list.stream().filter(t -> t.compareTo(element) > 0).count();
//        int counter = 0;
//        for (T t : this.list) {
//            if (t.compareTo(element) > 0) {
//                counter++;
//            }
//        }
//        return counter;
    }

    public T getMax() {
        return this.list.stream().max(Comparable::compareTo).orElseThrow();
    }

    public T getMin() {
        return this.list.stream().min(Comparable::compareTo).orElseThrow();
    }

    public int size() {
        return this.list.size();
    }

    public T get(int index) {
        return this.list.get(index);
    }

    public void print() {
        this.list.forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
