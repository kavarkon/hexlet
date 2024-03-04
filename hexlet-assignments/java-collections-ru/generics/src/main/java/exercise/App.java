package exercise;

import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    static boolean containValuesInBook(Map<String, String> book, Map<String, String> where) {
        return book.containsValue(where.get("author")) && book.containsValue(where.get("year"));
    }
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        for (Map<String, String> book: books) {
            if (where.containsKey("title")) {
                if (book.containsValue(where.get("title")) && containValuesInBook(book, where)) {
                    result.add(book);
                }
            } else if (containValuesInBook(book, where)) { result.add(book); }
        }
        return result;
    }
}
//END
