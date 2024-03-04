package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
class App {
    public  static String getForwardedVariables(String str) {
        String[] strArray = str.split("\n");
        List<String> strings = new ArrayList<>(Arrays.asList(strArray));
        return strings.stream()
                .filter(string -> string.startsWith("environment="))
                .map(string -> string.replaceAll("environment=", ""))
                .map(string -> string.replaceAll("\"", ""))
                .map(string -> string.split(","))
                .flatMap(Stream::of)
                .filter(string -> string.startsWith("X_FORWARDED_"))
                .map(string -> string.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
