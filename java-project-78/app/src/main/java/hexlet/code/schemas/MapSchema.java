package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addPredicate(value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        addPredicate(value -> ((Map<?, ?>) value).size() == size);
        return this;
    }
    static boolean isValidObject(Map<?, ?> value, Map<?, BaseSchema> schemas) {
        for (Map.Entry<?, BaseSchema> schema: schemas.entrySet()) {
            Object key = schema.getKey();
            BaseSchema schemaValue = schema.getValue();

            if (!schemaValue.isValid(value.get(key))) {
                return false;
            }
        }
        return true;
    }
    public MapSchema shape(Map<?, BaseSchema> schemaMap) {
        addPredicate(value -> isValidObject((Map<?, ?>) value, schemaMap));
        return this;
    }
}
