package interfaces_and_abstraction.Problem04;

/**
 * Created by Chilly on 18.11.2017 г..
 */
public class Smartphone implements Callable, Browsable {

    Smartphone() {}

    @Override
    public String call(String number) {
        if (number.matches("[0-9]*")) {
            return "Calling... " + number;
        } else {
            return "Invalid number!";
        }
    }

    @Override
    public String browse(String url) {
        if (url.matches("[^0-9]*")) {
            return "Browsing: " + url + "!";
        } else {
            return "Invalid URL!";
        }
    }
}