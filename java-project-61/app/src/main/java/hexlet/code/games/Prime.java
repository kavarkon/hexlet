package hexlet.code.games;
import hexlet.code.utils.Utils;
import hexlet.code.Engine;
public class Prime {
    public static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i += 1) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    static String[] questionAndAnswer() {
        int number = Utils.randNum();
        String question = Integer.toString(number);
        String correctAnswer = isPrime(number) ? "yes" : "no";
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
