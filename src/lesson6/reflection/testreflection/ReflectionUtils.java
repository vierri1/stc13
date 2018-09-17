package lesson6.reflection.testreflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static void printClass(Class clazz) {
        System.out.println("FIELDS:");
        printFields(clazz);
        System.out.println("DECLARED FIELDS");
        printDeclaredFields(clazz);
        System.out.println("METHODS");
        printMethods(clazz);
    }

    private static void printMethods(Class clazz) {
        methodIterator(clazz.getMethods());
    }

    private static void printFields(Class clazz) {
        fieldIterator(clazz.getFields());
    }

    private static void printDeclaredFields(Class clazz) {
        fieldIterator(clazz.getDeclaredFields());
    }

    private static void methodIterator(Method[] methods) {
        for (Method method : methods) {
            System.out.println("Method name: " + method);
            System.out.println("Return type: " + method.getReturnType().getName());
            System.out.println("Parameters: ");
            for (Class parameterClass : method.getParameterTypes()) {
                System.out.print(parameterClass.getName() + ", ");
            }
            System.out.println();
        }
    }

    private static void fieldIterator(Field[] declaredFields) {
        for (Field field : declaredFields) {
            System.out.print("name = " + field.getName());
            System.out.print(", type = " + field.getType());
            System.out.println(", modifier = " + field.getModifiers());
        }
    }


}
