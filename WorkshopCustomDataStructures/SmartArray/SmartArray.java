package WorkshopCustomDataStructures.SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    private Integer[] data;
    private int size;

    public SmartArray() {
        this.data = new Integer[4];
        this.size = 0;
    }

    public void add(int element) {
        if (this.size == this.data.length) {
            this.data = grow();
        }
        this.data[size++] = element;
    }

    public void add(int index, int element) {
        validateIndex(index);
        int lastElement = this.data[this.size - 1];
        if (this.size - 1 - index >= 0) System.arraycopy(this.data, index, this.data, index + 1, this.size - 1 - index);
        this.data[index] = element;
        add(lastElement);
    }

    public int remove(int index) {
        validateIndex(index);
        this.size--;
        int element = this.data[index];
        if (this.size - index >= 0) System.arraycopy(this.data, index + 1, this.data, index, this.size - index);
        this.data[this.size] = null;

        if (this.data.length / 4 >= this.size || this.data.length/4 == 4) {
            this.data = shrink();
        }
        return element;
    }

    public int get(int index) {
        validateIndex(index);
        return this.data[index];
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
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

    private Integer[] grow() {
        Integer[] newData = new Integer[data.length * 2];
        if (this.size >= 0) System.arraycopy(newData, 0, data, 0, this.size);
        return newData;
    }

    private Integer[] shrink() {
        Integer[] newData = new Integer[data.length / 2];
        if (this.size >= 0) System.arraycopy(newData, 0, data, 0, this.size);
        return newData;
    }

}
