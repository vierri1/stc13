package lesson7.classloaders.homework.generateclass;

public class MyDynamicClass implements MyInterface {

    public void doWork() {
        int i = 0;
        for (i = 0; i < 10; i++) {
            System.out.println(i);
        }

    }
}