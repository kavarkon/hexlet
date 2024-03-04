package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;
    public static void createGame(String description, String[][] questionsAndAnswers) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String userName = scanner.next();
        System.out.println("Hello, " + userName + "!");
        System.out.println(description);
        for (var item: questionsAndAnswers) {
            System.out.println("Question: " + item[0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(item[1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer
                        + "' is wrong answer ;(. Correct answer was '" + item[1] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                scanner.close();
                return;
            }
        }
        System.out.println("Congratulations, " + userName + "!");
        scanner.close();
    }
}
