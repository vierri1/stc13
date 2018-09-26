package lesson9.java8.stream.tasks;

import java.util.List;

public class CalcImpl implements Calc {
    @Override
    public int sum(int a, int b) {
        Summator sum = (k, n) -> k + n;
        return sum.calcSum(a, b);
    }

    @Override
    public int max(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElse(0);
    }

    @Override
    public Double average(List<Integer> list) {
        return list.stream().mapToDouble(Double::valueOf).average().orElse(0);
    }

    @Override
    public int factorial(int a) {
        return 0;
    }
}
