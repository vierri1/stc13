package lesson6.reflection.createAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyFigure implements InvocationHandler {
    Figure figure;

    public ProxyFigure(Figure figure) {
        this.figure = figure;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Annotation annotation = figure.getClass().getMethod(method.getName()).getAnnotation(Logged.class);
        if (annotation != null) {
            long start = System.currentTimeMillis();
            System.out.println("Method " + method.getName() + " invoked");
            Object result = method.invoke(figure, args);
            System.out.println("Operation time: " + (System.currentTimeMillis() - start));
            return result;
        } else {
            return method.invoke(figure, args);
        }
    }
}
