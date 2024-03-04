package exercise;

import java.util.*;

// BEGIN
class App {
    static String compareMaps(String key, Map<String, Object> dict1, Map<String,Object> dict2) {
        if (dict1.containsKey(key) && dict2.containsKey(key) && dict1.get(key).equals(dict2.get(key))) {
            return "unchanged";
        } else if (dict1.containsKey(key) && dict2.containsKey(key) && !dict1.get(key).equals(dict2.get(key))) {
            return "changed";
        } else if (dict1.containsKey(key) && !dict2.containsKey(key)) {
            return "deleted";
        } else if (!dict1.containsKey(key) && dict2.containsKey(key)) {
            return "added";
        }
        return "oops";
    }

    public static LinkedHashMap<String, String> genDiff(Map<String, Object> dictionary1, Map<String, Object> dictionary2) {
        Set<String> keys = new TreeSet<>(Comparator.naturalOrder());
        keys.addAll(dictionary1.keySet());
        keys.addAll(dictionary2.keySet());
        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        for (String key: keys) {
            result.put(key, compareMaps(key,dictionary1, dictionary2));
        }
        return result;
    }
}
//END
