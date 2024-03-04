package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {
    String body;
    List<Tag> children;

    public PairedTag(
            String name,
            Map<String, String> attributes,
            String body, List<Tag> children
    ) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        var result = new StringBuilder();
        result.append(super.toString());
        result.append(body);
        children.stream()
                .forEach(child -> result.append(child.toString()));
        result.append("</" + getName() + ">");
        return result.toString();
    }
}
// END
