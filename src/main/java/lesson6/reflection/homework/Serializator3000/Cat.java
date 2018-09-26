package lesson6.reflection.homework.Serializator3000;

import java.util.Objects;

public class Cat {
    private String name;
    private int age;
    private String color;
    private short legsCount;
    private boolean isSleep;
    private double length;

    public Cat() {
    }

    public Cat(String name, int age, String color, short legsCount, boolean isSleep, double length) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.legsCount = legsCount;
        this.isSleep = isSleep;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                legsCount == cat.legsCount &&
                isSleep == cat.isSleep &&
                Double.compare(cat.length, length) == 0 &&
                Objects.equals(name, cat.name) &&
                Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, color, legsCount, isSleep, length);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", legsCount=" + legsCount +
                ", isSleep=" + isSleep +
                ", length=" + length +
                '}';
    }
}
