package Generics.Exercise.GenericCountMethodStrings;

import java.util.List;

public class Box<E> {
    private final E element;

    public Box(E element) {
        this.element = element;
    }

    public static <E extends Comparable<E>> int greater(List<Box<E>> list, E elementToCompare) {
        int counter = 0;
        for (Box<E> s : list) {
            if (s.element.compareTo(elementToCompare) > 0) {
                counter++;
            }
        }
        return counter;
    }
}
