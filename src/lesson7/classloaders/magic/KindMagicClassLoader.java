package lesson7.classloaders.magic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class KindMagicClassLoader extends ClassLoader {

    public KindMagicClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("lesson7.classloaders.magic.Magic")) {
            String dest = "file:/Users/Andrey/Documents/Учеба/stc13/lessons/lesson7/Magic.class";
            byte[] classData = null;
            try (InputStream inputStream = (new URL(dest)).openConnection().getInputStream();
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                int data = inputStream.read();
                while (data != -1) {
                    outputStream.write(data);
                    data = inputStream.read();
                }
                inputStream.close();
                classData = outputStream.toByteArray();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return defineClass(name, classData, 0, classData.length);
        } else {
            return super.loadClass(name);
        }
    }
}
