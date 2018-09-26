package lesson3.generics.problem3;


import java.util.ArrayList;
import java.util.Collection;

public class Example {
    public static void main(String[] args) {
        addAll(new ArrayList<String>(), new ArrayList<String>());
        addAll(new ArrayList<Object>(), new ArrayList<Object>());
        addAll(new ArrayList<String>(), new ArrayList<Object>());
    }

    private static <M, N extends M> void addAll(Collection<N> c, Collection<M> c2) {
        for (M i : c) {
            c2.add(i);
        }
    }

}
