package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    public StringSchema required() {
        addPredicate(value -> value instanceof String && !((String) value).isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        addPredicate(value -> ((String) value).length() >= length);
        return this;
    }

    public StringSchema contains(String str) {
        addPredicate(value -> ((String) value).contains(str));
        return this;
    }
}
