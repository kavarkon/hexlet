package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        map.entrySet().stream()
                .forEach(entry -> {
                    storage.unset(entry.getKey());
                    storage.set(entry.getValue(), entry.getKey());
                });
    }
}
// END
