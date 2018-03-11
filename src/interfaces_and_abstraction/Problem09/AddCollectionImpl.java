package interfaces_and_abstraction.Problem09;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class AddCollectionImpl<T> implements AddCollection<T> {
    private List<T> elements;

    public AddCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(T element) {
        this.elements.add(element);
        return this.elements.size() - 1;
    }
}