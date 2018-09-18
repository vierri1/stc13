package lesson7.classloaders.magic;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        ClassLoader parentClassLoader = Magic.class.getClassLoader();
        Class magicClass = parentClassLoader.loadClass("lesson7.classloaders.magic.Magic");
        Magic magic = (Magic) magicClass.newInstance();
        magic.cast();

        KindMagicClassLoader kindMagicClassLoader = new KindMagicClassLoader(parentClassLoader);
        Class kindMagicClass = kindMagicClassLoader.loadClass("lesson7.classloaders.magic.Magic");
        kindMagicClass.getMethod("cast").invoke(kindMagicClass.newInstance(), null);
    }
}