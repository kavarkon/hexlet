package hexlet.code.utils;

public class Utils {
    public static int randNum() {
        final int maxRandNumber = 100;
        return maxRandNumber - ((int) (Math.random() * maxRandNumber));
    }
    public static int randNum(int min, int max) {
        return (int) (Math.random() * (max - min - 1)) + min;
    }


}
