package generics.Problem06;

/**
 * Created by Chilly on 17.11.2017 г..
 */
public class Box<T extends Comparable<T>> implements Comparable<Box<T>> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + String.valueOf(this.data);
    }

    @Override
    public int compareTo(Box<T> other) {
        return this.data.compareTo(other.data);
    }
}