package Generics.Exercise.GenericSwapMethodInteger;

import java.util.List;

public class Box<T> {
    private final T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.getClass().getName() + ": " + element;
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        T element1 = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, element1);
    }
}
