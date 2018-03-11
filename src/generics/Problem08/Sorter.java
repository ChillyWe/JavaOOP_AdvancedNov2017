package generics.Problem08;

/**
 * Created by Chilly on 22.11.2017 г..
 */
public class Sorter {
    public static <T extends Comparable> void sort(CustomList<T> list) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < list.getCustomList().size(); i++) {
                if (list.getElement(i - 1).compareTo(list.getElement(i)) > 0) {
                    list.swap((i - 1), i);
                    swapped = true;
                }
            }
        }
    }
}