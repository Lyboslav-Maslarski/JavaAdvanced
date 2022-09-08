package WorkshopCustomDataStructures;

import java.util.function.Consumer;

public class SmartArray<E> {
    private Object[] data;
    private int size;

    public SmartArray() {
        this.data = new Object[4];
        this.size = 0;
    }

    public void add(E element) {
        if (this.size == this.data.length) {
            this.data = grow();
        }
        this.data[size++] = element;
    }

    public void add(int index, E element) {
        validateIndex(index);
        E lastElement = get(this.size - 1);
        if (this.size - 1 - index >= 0) System.arraycopy(this.data, index, this.data, index + 1, this.size - 1 - index);
        this.data[index] = element;
        add(lastElement);
    }

    public E remove(int index) {
        validateIndex(index);
        this.size--;
        E element = get(index);
        if (this.size - index >= 0) System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
        this.data[this.size] = null;

        if (this.data.length / 4 >= this.size || this.data.length / 4 == 4) {
            this.data = shrink();
        }
        return element;
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        validateIndex(index);
        return (E) this.data[index];
    }

    public boolean contains(E element) {
        for (int i = 0; i < this.size; i++) {
            if (get(i).equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<E> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(get(i));
        }
    }

    public int size() {
        return this.size;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index" + index);
        }
    }

    private Object[] grow() {
        Object[] newData = new Object[data.length * 2];
        if (this.size >= 0) System.arraycopy(newData, 0, data, 0, this.size);
        return newData;
    }

    private Object[] shrink() {
        Object[] newData = new Object[data.length / 2];
        if (this.size >= 0) System.arraycopy(newData, 0, data, 0, this.size);
        return newData;
    }

}
