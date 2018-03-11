package iterators_and_comparators.Problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chilly on 21.11.2017 г..
 */
public class ListyIterator<String> implements Iterable<String> {
    private List<String> myList;
    private Iterator currIterator;

    public ListyIterator(String... elements) {
        this.setMyList(elements);
        this.currIterator = new ListIterator();
    }

    private void setMyList(String... elements) {
        if (elements.length == 0) {
            this.myList = new ArrayList<>();
        } else {
            this.myList = Arrays.asList(elements);
        }
    }

    public void Print() {
        if (iterator().hasNext()) {
            System.out.println(iterator().next());
        } else {
            throw new UnsupportedOperationException("Invalid Operation!");
        }
    }

    public boolean move() {
        if (this.currIterator.hasNext()) {
            this.currIterator.next();
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<String> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return this.counter < myList.size();
        }

        @Override
        public String next() {
            this.counter++;
            return myList.get(this.counter - 1);
        }
    }
}