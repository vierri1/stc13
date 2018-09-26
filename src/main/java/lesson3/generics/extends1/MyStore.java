package lesson3.generics.extends1;

import java.util.HashMap;
import java.util.Map;

public class MyStore<K, V> {
    private Map<K, V> store = new HashMap<>();

    public void putAll(Map<K, ? extends V> entries) {
        store.putAll(entries);
    }

}
