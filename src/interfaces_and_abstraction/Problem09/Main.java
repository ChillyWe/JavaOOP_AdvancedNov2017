package interfaces_and_abstraction.Problem09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chilly on 19.11.2017 г..
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection list = new AddCollectionImpl();
        AddRemoveCollection list2 = new AddRemoveCollectionImpl<>();
        MyList list3 = new MyListImpl();

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();

        String[] line = reader.readLine().split("\\s+");
        for (String element : line) {
            sb.append(list.add(element)).append(" ");
            sb2.append(list2.add(element)). append(" ");
            sb3.append(list3.add(element)). append(" ");
        }
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb4.append(list2.remove()).append(" ");
            sb5.append(list3.remove()).append(" ");
        }
        System.out.printf("%s\n%s\n%s\n%s\n%s\n", sb, sb2, sb3, sb4, sb5);
    }
}