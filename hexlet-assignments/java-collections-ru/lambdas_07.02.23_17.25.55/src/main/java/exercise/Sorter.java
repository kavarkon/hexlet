package exercise;

import java.time.Period;
import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

import static java.util.Collections.reverseOrder;

// BEGIN
class Sorter {

    static Integer ageCount(Map<String, String> user) {
        LocalDate today = LocalDate.now();
        String[] paramsArray = user.get("birthday").split("-");
        LocalDate birthday = LocalDate.of(Integer.parseInt(paramsArray[0]),
                Integer.parseInt(paramsArray[1]), Integer.parseInt(paramsArray[2]));
        Period age = Period.between(birthday, today);
        return age.getYears() + age.getMonths();
    }
    static String getUserName(Map<String, String> user) {
        return user.get("name");
    }
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                //.map(user -> user.replace("birthday", ageCount(user.get("birthday"))))
                .sorted(reverseOrder(Comparator.comparing(Sorter::ageCount)))
                .map(Sorter::getUserName)
                .collect(Collectors.toList());
    }
}
// END
