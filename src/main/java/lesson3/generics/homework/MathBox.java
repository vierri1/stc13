package lesson3.generics.homework;

import lesson2.exeptions.MyArithmeticException;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class MathBox<T extends Number> extends ObjectBox {

    public MathBox(T[] mas) {
        super(new TreeSet<>());
        for (int i = 0; i < mas.length; i++) {
            collection.add(mas[i]);
        }
    }

    public double summator() {
        //TODO Узнать почему не работает такая конструкция
//      return treeSet.stream()
//                .mapToDouble(Number::doubleValue)
//               .sum();

        return collection.stream()
                .map(a -> ((Number) a).doubleValue())
                .reduce((a, b) -> a + b)
                .orElse(0d);
    }

    public Set<Double> splitter(double del) throws MathBoxException {
        if (del == 0) {
            throw new MathBoxException("Divide by zero!");
        }
        return collection.stream()
                .map(a -> ((Number) a).doubleValue() / del)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean addElement(Object o) {
        if (!(o instanceof Number)) {
            throw new MyArithmeticException("Wrong type!");
        } else {
            return super.addElement(o);
        }
    }
}
