package lesson7.classloaders.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        Human human = new EuropeanHuman();
//        human.eat("Chicken", 3);
//        human.sleep(9);
//        System.out.println(human.talk());
//
//        ClassLoader classLoader = EuropeanHuman.class.getClassLoader();
//        HumanLoader humanLoader = new HumanLoader(classLoader);
//        Class humanClass = humanLoader.loadClass("lesson7.classloaders.proxy.EuropeanHuman");
//        humanClass.getMethod("sleep", int.class).invoke(humanClass.newInstance(), 6);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            Human humanProxy = (Human) Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[]{Human.class}, new HumanInvocation());
            humanProxy.sleep(9);
            humanProxy.eat("Banana", 12);
            scanner.nextLine();
        }


    }
}
