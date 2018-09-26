package lesson7.classloaders.homework.generateclass;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassInvocation implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        GenerateClass generateClass = new GenerateClass();
        String pathToFile = "/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson7/classloaders/homework/generateclass/MyDynamicClass.java";
        generateClass.generate(pathToFile);
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        compiler.run(null, null, null, pathToFile);
        MyClassLoader classLoader = new MyClassLoader(proxy.getClass().getClassLoader(), "lesson7.classloaders.homework.generateclass.MyDynamicClass",
                "/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson7/classloaders/homework/generateclass/MyDynamicClass.class");
        try {
            Class myClass = classLoader.loadClass("lesson7.classloaders.homework.generateclass.MyDynamicClass");
            Method myMeth = myClass.getMethod(method.getName(), method.getParameterTypes());
            return myMeth.invoke(myClass.newInstance(), args);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
