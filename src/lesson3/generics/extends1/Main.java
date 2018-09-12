package lesson3.generics.extends1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MyStore<Long, Animal> animalStore = new MyStore<>();
        Map<Long, Cat> catMap = new HashMap<>();
        catMap.put(1l, new Cat("Barsik"));
        catMap.put(1l, new Cat("Pushok"));
        catMap.put(1l, new Cat("Tisha"));
        animalStore.putAll(catMap);
    }


}
