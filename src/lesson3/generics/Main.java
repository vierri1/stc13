package lesson3.generics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        arrayList.add(12);
        System.out.println(arrayList.get(1));

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Mark");
        hashMap.put(2, "Jane");
        hashMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
