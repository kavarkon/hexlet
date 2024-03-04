package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(List.of(1, 2, 3, 4));
        List<Integer> result1 = new ArrayList<>(List.of(1, 2));
        List<Integer> actual1 = App.take(numbers1, 2);
        assertThat(actual1).isEqualTo(result1);

        List<Integer> numbers2 = new ArrayList<>(List.of(7, 3, 10));
        List<Integer> result2 = new ArrayList<>(List.of(7, 3, 10));
        List<Integer> actual2 = App.take(numbers2, 8);
        assertThat(actual2).isEqualTo(result2);

        List<Integer> numbers3 = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> result3 = new ArrayList<>(List.of());
        List<Integer> actual3 = App.take(numbers3, 0);
        assertThat(actual3).isEqualTo(result3);

        List<Integer> numbers4 = new ArrayList<>(List.of());
        List<Integer> result4 = new ArrayList<>(List.of());
        List<Integer> actual4 = App.take(numbers4, 4);
        assertThat(actual4).isEqualTo(result4);

        List<Integer> numbers5 = new ArrayList<>(List.of(4, 3, 2, 1));
        List<Integer> result5 = new ArrayList<>(List.of(4));
        List<Integer> actual5 = App.take(numbers5, 1);
        assertThat(actual5).isEqualTo(result5);
        // END
    }
}
