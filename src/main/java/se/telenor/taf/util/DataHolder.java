package se.telenor.taf.util;

import org.apache.commons.collections4.keyvalue.MultiKey;
import org.apache.commons.collections4.map.MultiKeyMap;
import org.springframework.stereotype.Component;

@Component
public class DataHolder {

    private final static MultiKeyMap<MultiKey, Object> HOLDER = new MultiKeyMap<>();
    public void put(String alias, Object o) {
        HOLDER.put(new MultiKey(alias, o.getClass()), o);
    }

    public <T> T get(String alias, Class<T> type) {
        if (HOLDER.containsKey(alias, type)) {
            return (T) HOLDER.get(alias, type);
        } else {
            throw new RuntimeException("No such key " + alias + " of type " + type);
        }
    }

    public <T> T getOrDefault(String alias, Class<T> type, T defaultValue) {
        if (HOLDER.containsKey(alias, type)) {
            return (T) HOLDER.get(alias, type);
        } else {
            return defaultValue;
        }
    }

    public static void reset() {
        HOLDER.clear();
    }
}
