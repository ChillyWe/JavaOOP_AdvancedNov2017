package generics.Problem08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chilly on 17.11.2017 г..
 */
public class CustomList<T extends Comparable> {
    private List<T> customList;

    public CustomList() {
        this.customList = new ArrayList<>();
    }

    public List<T> getCustomList() {
        return Collections.unmodifiableList(this.customList);
    }

    public T getElement(int index) {
        return this.customList.get(index);
    }

    public void add(T element) {
        this.customList.add(element);
    }

	public T remove(int index) {
        return this.customList.remove(index);
    }

	public boolean contains(T element) {
        return this.customList.contains(element);
    }

    public void swap(int index, int index1) {
        T temp = customList.get(index);
        customList.set(index, customList.get(index1));
        customList.set(index1, temp);
    }

	public int countGreaterThan(T element) {
        int count = 0;
        if (customList.size() == 0) throw new IllegalArgumentException();
        for (T object : customList) {
            if (element.compareTo(object) < 0) {
                count++;
            }
        }
        return count;
    }

	public T getMax() {
        if (customList.size() == 0) {
            throw new IllegalArgumentException();
        }
        T max = customList.get(0);
        for (int i = 1; i < customList.size(); i++) {
            if (max.compareTo(customList.get(i)) < 0) {
                max = customList.get(i);
            }
        }
        return max;
    }

	public T getMin() {
        if (customList.size() == 0) {
            throw new IllegalArgumentException();
        }
        T min = customList.get(0);
        for (int i = 1; i < customList.size(); i++) {
            if (min.compareTo(customList.get(i)) > 0) {
                min = customList.get(i);
            }
        }
        return min;
    }
}