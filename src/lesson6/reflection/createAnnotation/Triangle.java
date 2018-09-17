package lesson6.reflection.createAnnotation;


public class Triangle implements Figure {
    @Override
    @Logged
    public void draw() {
        System.out.println("draw triangle");
    }
}
