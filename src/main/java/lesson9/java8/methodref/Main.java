package lesson9.java8.methodref;


public class Main {
    public static void main(String[] args) {
        Greeter sayHi = GreeterImp::sayHi;
        sayHi.sayHi("Hello");

    }
}
