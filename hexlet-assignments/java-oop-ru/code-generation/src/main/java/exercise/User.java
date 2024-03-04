package exercise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

// BEGIN
@AllArgsConstructor
@Getter
@Builder
@Value
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
