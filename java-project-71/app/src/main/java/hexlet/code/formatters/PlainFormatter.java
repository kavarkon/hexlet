package hexlet.code.formatters;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PlainFormatter {
    static String valueToString(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
    static String addedToString(String key, Object value) {
        String valueStr = valueToString(value);
        return String.format("Property '%s' was added with value: %s", key, valueStr);
    }
    static String removedToString(String key) {
        return String.format("Property '%s' was removed", key);
    }
    static String updatedToString(String key, Object value1, Object value2) {
        String value1Str = valueToString(value1);
        String value2Str = valueToString(value2);
        return String.format("Property '%s' was updated. From %s to %s", key, value1Str, value2Str);
    }
    public static String plain(TreeMap<String, Map<String, List<Object>>> tree) {
        var result = new StringBuilder();

        for (Map.Entry<String, Map<String, List<Object>>> entry: tree.entrySet()) {
            String key = entry.getKey();

            Map<String, List<Object>> map = entry.getValue();
            for (Map.Entry<String, List<Object>> statusAndValues: map.entrySet()) {
                switch (statusAndValues.getKey()) {
                    case "added" -> result.append(addedToString(key, statusAndValues.getValue().get(1)));
                    case "removed" -> result.append(removedToString(key));
                    case "updated" -> result.append(updatedToString(
                            key, statusAndValues.getValue().get(0), statusAndValues.getValue().get(1)));
                    case "unchanged" -> { }
                    default -> throw new UncheckedIOException("Found in the PlainFormatter unprocessed key status"
                            + statusAndValues.getKey(),
                            new IOException());
                }
                if ((!key.equals(tree.lastKey()) && !statusAndValues.getKey().equals("unchanged"))) {
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
}
