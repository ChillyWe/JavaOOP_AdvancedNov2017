package generics.Problem02;

/**
 * Created by Chilly on 17.11.2017 г..
 */
public class Box<T> {
    private T data;

    public Box(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.data.getClass().getName() + ": " + String.valueOf(this.data);
    }
}