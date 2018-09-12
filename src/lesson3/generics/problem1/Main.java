package lesson3.generics.problem1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> l = new ArrayList<>();
        l.add(12);
        l.add(14);
        dump(l);

        List<Integer> l2 = new ArrayList<>();
        l2.add(141);
        l2.add(21);
        dump(l2);
    }

    static void dump(List<? extends Object> c) {
        for (Iterator<?> i = c.iterator(); i.hasNext(); ) {
            Object o = i.next();
            System.out.println(o);
        }
    }

}
