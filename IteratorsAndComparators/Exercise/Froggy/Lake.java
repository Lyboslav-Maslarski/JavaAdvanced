package IteratorsAndComparators.Exercise.Froggy;

import java.util.Iterator;

public class Lake<T> implements Iterable<T> {
    private final T[] elements;

    public Lake(T[] elements) {
        this.elements = elements;
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<T> {
        private int index = 0;
        private int loopCount = 0;

        @Override
        public boolean hasNext() {
            if (index>=elements.length&&loopCount==0){
                loopCount++;
                index=1;
            }
            return index < elements.length;
        }

        @Override
        public T next() {
            T element = elements[index];
            index += 2;
            return element;
        }
    }
}
