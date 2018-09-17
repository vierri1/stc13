package lesson6.reflection.homework.Serializator3000;


public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("Leo", 4, "tricolor", (short) 4, true, 0.47);
        Serializator serializator = new Serializator();
        serializator.serialize(cat, "/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson6/reflection/homework/Serializator3000/cats.xml");
        System.out.println("Before serialization\n" + cat);
        Cat newCat = (Cat) serializator.deserialize("/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson6/reflection/homework/Serializator3000/cats.xml");
        System.out.println("After serialization\n" + cat);
        System.out.println(newCat);
        System.out.println("is equals: " + cat.equals(newCat));
    }
}
