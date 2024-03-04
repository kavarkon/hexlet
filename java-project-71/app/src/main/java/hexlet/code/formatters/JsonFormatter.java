package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class JsonFormatter {
    public static String json(TreeMap<String, Map<String, List<Object>>> tree) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(tree);
    }
}
