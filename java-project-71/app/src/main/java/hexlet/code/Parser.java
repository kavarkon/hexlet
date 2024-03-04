package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class Parser {
    static Map<String, Object> parseJson(String content) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }
    static Map<String, Object> parseYaml(String content) throws IOException {
        ObjectMapper mapper = new YAMLMapper();
        return mapper.readValue(content, Map.class);
    }
    public static Map<String, Object> parse(String content, String formatFile) throws Exception {
        Map<String, Object> data;
        switch (formatFile) {
            case "json" -> {
                data = parseJson(content);
            }
            case "yml", "yaml" -> {
                data = parseYaml(content);
            }
            default -> throw new Exception(String.format("unknown file format: %s", formatFile));
        }
        return data;
    }
}
