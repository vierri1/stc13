package lesson6.reflection.createAnnotation;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Figure realFigure = new Triangle();
        Figure figure = (Figure) Proxy.newProxyInstance(ProxyFigure.class.getClassLoader(), new Class[]{Figure.class}, new ProxyFigure(new Triangle()));
        figure.draw();
        System.out.println("Real figure: ");
        realFigure.draw();
        System.out.println("Proxy figure: ");
        figure.draw();

    }
}
