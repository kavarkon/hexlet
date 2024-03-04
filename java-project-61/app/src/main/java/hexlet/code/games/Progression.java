package hexlet.code.games;
import hexlet.code.utils.Utils;
import hexlet.code.Engine;
public class Progression {
    public static final String DESCRIPTION = "What number is missing in the progression?";
    static void fillArrayRandProgression(String[] array) {
        int firstNum = Utils.randNum();
        for (var i = 0; i < array.length; i += 1) {
            array[i] = Integer.toString(firstNum);
            firstNum += 1;
        }
    }
    static String arrayToString(String[] array) {
        var result = new StringBuilder();
        for (var i : array) {
            result.append(i);
            result.append(" ");
        }
        return result.toString();
    }
    static String[] questionAndAnswer() {
        final int minNumbersLength = 5;
        final int maxNumbersLength = 10;
        String[] numbers = new String[Utils.randNum(minNumbersLength, maxNumbersLength)];
        fillArrayRandProgression(numbers);

        int placeOfMissingNumber = Utils.randNum(0, numbers.length);
        String correctAnswer = numbers[placeOfMissingNumber];
        numbers[placeOfMissingNumber] = "..";

        String question = arrayToString(numbers);
        String[] array = {question, correctAnswer};
        return array;
    }
    public static void runGame() {
        int arraysCount = Engine.ROUNDS_COUNT;
        String[][] dataForGame = new String[arraysCount][2];
        for (var item: dataForGame) {
            String[] data = questionAndAnswer();
            item[0] = data[0];
            item[1] = data[1];
        }
        Engine.createGame(DESCRIPTION, dataForGame);
    }
}
