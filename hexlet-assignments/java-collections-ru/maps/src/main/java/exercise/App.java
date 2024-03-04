package exercise;

import java.util.*;

// BEGIN
class App {
    static Integer countThisWord(List<String> strList, String str) {
        int result = 0;
        for (String item: strList) {
            if (item.equals(str) && !item.equals("")) {
                result += 1;
                strList.set(strList.indexOf(item), "");
            }
        }
        return result;
    }
    public static Map getWordCount(String str) {
        String[] wordsArray = str.split(" ");
        List<String> wordsList = Arrays.asList(wordsArray);

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word: wordsList) {
            Integer count = countThisWord(wordsList, word);
            //wordsList.removeIf(word::equals);
            if (!word.equals("")) {
                wordsCount.put(word, count);
            }
        }
        return wordsCount;
    }
    public static String toString(Map dictionary) {
        if (dictionary.size() == 0) {
            return "{}";
        }
        var result = new StringBuilder();
        result.append("{");
        for (Object word: dictionary.keySet()) {
            result.append("\n  ");
            result.append(word);
            result.append(": ");
            result.append(dictionary.get(word));
        }
        result.append("\n}");
        return result.toString();
    }
}
//END
