package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private List<Predicate<Object>> predicates = new ArrayList<>();

    protected final void addPredicate(Predicate<Object> predicate) {
        predicates.add(predicate);
    }

    public final boolean isValid(Object object) {
        return predicates.stream().allMatch(predicate -> predicate.test(object));
    }
}
