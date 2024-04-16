package se.telenor.taf.trace;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TraceUtil {

    public static Map<String, Object> buildTree(Class c) {
        Map<String, Object> tree = new HashMap<>();
        getBusinesNodes(c.getDeclaredFields()).forEach(f -> {
            tree.put(f.getType().getName(), buildTree(f.getType()));
        });
        return tree;
    }

    private static List<Field> getBusinesNodes(Field[] fields) {
        return Arrays.stream(fields).filter(
                        f -> Arrays.stream(f.getType().getAnnotations()).anyMatch(
                                a -> a.annotationType().equals(BusinessNode.class)))
                .collect(Collectors.toList());
    }
}
