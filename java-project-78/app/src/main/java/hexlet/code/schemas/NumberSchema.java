package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addPredicate(value -> value instanceof Integer);
        return this;
    }

    public NumberSchema positive() {
        addPredicate(value -> value == null || value instanceof Integer && (Integer) value > 0);
        return this;
    }

    public NumberSchema range(int min, int max) {
        addPredicate(value -> (Integer) value >= min && (Integer) value <= max);
        return this;
    }
}
