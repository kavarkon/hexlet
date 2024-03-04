package hexlet.code.games;
import hexlet.code.utils.Utils;
import hexlet.code.Engine;
public class Even {
    public static final String DESCRIPTION = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    static String[] questionAndAnswer() {
        int number = Utils.randNum();
        String question = Integer.toString(number);
        String correctAnswer = (number % 2 == 0) ? "yes" : "no";
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
