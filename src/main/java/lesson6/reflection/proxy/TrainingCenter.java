package lesson6.reflection.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TrainingCenter implements InvocationHandler {
    public Trainer trainer;

    public TrainingCenter(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I take your money");
        System.out.println("I give money to trainer");
        System.out.println("Let's go work! We are team");
        if (method.getName().equals("talk")) {
            System.out.println("who's late");
        }
        return method.invoke(trainer, args);
    }
}
