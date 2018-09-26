package lesson7.classloaders.homework.generateclass;


import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyInterface myClass = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, new MyClassInvocation());
        Scanner scanner = new Scanner(System.in);
        int command;
        while (true) {
            System.out.println("1 - Ввести метод\n0 - Выход");
            command = scanner.nextInt();
            if (command == 1) {
                myClass.doWork();
            } else if (command == 0) {
                System.out.println("Exit");
                break;
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
}
