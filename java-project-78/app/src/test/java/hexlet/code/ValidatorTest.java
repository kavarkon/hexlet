package hexlet.code;

import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidatorTest {
    @Test
    public void testStringSchema() {
        String str = "what does the fox say";
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(str)).isTrue();
        assertThat(schema.isValid("hexlet")).isTrue();

        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(5)).isFalse();
        assertThat(schema.isValid("")).isFalse();

        schema.minLength(2);
        assertThat(schema.isValid("w")).isFalse();
        assertThat(schema.isValid("wh")).isTrue();

        assertThat(schema.contains("wh").isValid(str)).isTrue();
        schema.contains("whatthe");
        assertThat(schema.isValid(str)).isFalse();
    }

    @Test
    public void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.positive().isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(10)).isTrue();

        assertThat(schema.isValid(-10)).isFalse();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("5")).isFalse();
        assertThat(schema.isValid(0)).isFalse();

        schema.range(5, 10);
        assertThat(schema.isValid(4)).isFalse();
        assertThat(schema.isValid(11)).isFalse();
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(10)).isTrue();
    }

    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(new HashMap<>())).isTrue();
        assertThat(schema.isValid(null)).isFalse();
        Map<Object, Object> data = new HashMap<>();
        data.put("key1", 1);
        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);
        assertThat(schema.isValid(data)).isFalse();
        data.put("key2", 5);
        assertThat(schema.isValid(data)).isTrue();
    }

    @Test
    public void testShapeMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse();
    }
}
