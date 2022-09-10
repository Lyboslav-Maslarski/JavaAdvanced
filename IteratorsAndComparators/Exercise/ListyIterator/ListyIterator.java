package IteratorsAndComparators.Exercise.ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {
    private static int index;
    private List<String> elements;


    public ListyIterator(String... elements) {
        setElements(elements);
    }


    public final void setElements(String... elements) {
        if (elements.length == 0) {
            this.elements = new ArrayList<>();
        } else {
            this.elements = Arrays.asList(elements);
        }

    }

    public boolean move() {
        if (index + 1 < elements.size()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index + 1 < elements.size();
    }

    public void print() {
        if (elements.isEmpty()) {
            throw new IllegalStateException();
        }
        System.out.println(elements.get(index));
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            private int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < elements.size();
            }

            @Override
            public String next() {
                return elements.get(counter++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        for (String t : elements) {
            action.accept(t);
        }
    }

    public void printAll() {
        System.out.println(String.join(" ", elements));
    }
}
