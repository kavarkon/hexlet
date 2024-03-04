package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartments, long n) {
        List<String> result = new ArrayList<>();
        apartments.stream()
                .sorted(Home::compareTo)
                .limit(n)
                .forEach(apart -> result.add(apart.toString()));
        return result;
    }
}
// END
