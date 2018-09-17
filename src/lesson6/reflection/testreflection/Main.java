package lesson6.reflection.testreflection;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Capucin mrJenkins = new Capucin(10, 100, 33);
//        Field filed = mrJenkins.getClass().getDeclaredField("footSize");
//        filed.setAccessible(true);
//        System.out.println(filed.get(mrJenkins));
//        filed.set(mrJenkins, 34);
//        System.out.println(filed.get(mrJenkins));
//
//
//        filed = Capucin.class.getDeclaredField("tailLength");
//        filed.setAccessible(true);
//        System.out.println(filed.get(mrJenkins));
//        filed.set(mrJenkins, 45);
//        System.out.println(filed.get(mrJenkins));

        Capucin abu = new Capucin(10, 100, 44);
        Class<Capucin> clazz = (Class<Capucin>) abu.getClass();
        ReflectionUtils.printClass(clazz);
    }
}
