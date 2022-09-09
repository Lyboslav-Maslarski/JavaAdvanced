package Generics.Exercise.Tuple;

public class Tuple<T, E, S> {
    private T first;
    private E second;
    private S third;

    public Tuple(T first, E second, S third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Tuple() {
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    public S getThird() {
        return third;
    }

    public void setThird(S third) {
        this.third = third;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        stringBuilder.append(" -> ");
        stringBuilder.append(second);
        stringBuilder.append(" -> ");
        stringBuilder.append(third);
        return stringBuilder.toString();
    }
}
