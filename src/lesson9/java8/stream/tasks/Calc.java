package lesson9.java8.stream.tasks;

import java.util.List;

public interface Calc {
    int sum(int a, int b);

    int max(List<Integer> list);

    Double average(List<Integer> list);

    int factorial(int a);
}
