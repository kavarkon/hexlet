package exercise;

import java.util.Arrays;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String symbols, String word) {
        String[] symbolsArray = symbols.split("(?<=.)");
        List<String> symbolsList = Arrays.asList(symbolsArray);

        String[] wordCharsArray = word.split("(?<=.)");

        for (String chars: wordCharsArray) {
            int placeInSymbols = symbolsList.indexOf(chars.toLowerCase());
            if (placeInSymbols == -1) {
                return false;
            } else {
                symbolsList.set(placeInSymbols, "");
            }
        }
        return true;
    }
}
//END
