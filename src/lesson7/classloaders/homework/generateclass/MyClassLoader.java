package lesson7.classloaders.homework.generateclass;

import java.io.*;

public class MyClassLoader extends ClassLoader {
    private String className;
    private String path;

    public MyClassLoader(ClassLoader parent, String className, String path) {
        super(parent);
        this.className = className;
        this.path = path;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        byte[] classData = null;
        if (name.equals(className)) {
            try (InputStream inputStream = new BufferedInputStream(new FileInputStream(path));
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int data;
                while ((data = inputStream.read()) != -1) {
                    outputStream.write(data);
                }
                classData = outputStream.toByteArray();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defineClass(name, classData, 0, classData.length);
        }
        return super.loadClass(name);
    }
}
