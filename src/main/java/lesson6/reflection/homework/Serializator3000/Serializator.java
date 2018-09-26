package lesson6.reflection.homework.Serializator3000;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class Serializator {

    public void serialize(Object o, String path) {
        Class clazz = o.getClass();

        Document doc = new Document();
        Element classNameNode = new Element(clazz.getName());
        doc.setRootElement(classNameNode);

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Element objectFieldNode = new Element(field.getName());
                objectFieldNode.setAttribute("type", field.getType().getName()).setAttribute("value", field.get(o).toString());
                classNameNode.addContent(objectFieldNode);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Format format = Format.getPrettyFormat();
        XMLOutputter outputter = new XMLOutputter(format);
        try {
            outputter.output(doc, new FileOutputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object deserialize(String path) {
        Object o = null;
        SAXBuilder parser = new SAXBuilder();
        try {
            Document doc = parser.build(new File(path));
            Element classNameNode = doc.getRootElement();
            Class clazz = Class.forName(classNameNode.getName());
            o = clazz.newInstance();
            List<Element> elements = classNameNode.getChildren();

            for (Element element : elements) {
                Field field = clazz.getDeclaredField(element.getName());
                String value = element.getAttributeValue("value");
                field.setAccessible(true);
                switch (element.getAttributeValue("type")) {
                    case "boolean": {
                        field.setBoolean(o, Boolean.valueOf(value));
                        break;
                    }
                    case "char": {
                        field.setChar(o, value.charAt(0));
                        break;
                    }
                    case "byte": {
                        field.setByte(o, Byte.valueOf(value));
                        break;
                    }
                    case "short": {
                        field.setShort(o, Short.valueOf(value));
                        break;
                    }
                    case "int": {
                        field.setInt(o, Integer.valueOf(value));
                        break;
                    }
                    case "long": {
                        field.setLong(o, Long.valueOf(value));
                        break;
                    }
                    case "float": {
                        field.setFloat(o, Float.valueOf(value));
                        break;
                    }
                    case "double": {
                        field.setDouble(o, Double.valueOf(value));
                        break;
                    }
                    case "java.lang.String": {
                        field.set(o, value);
                        break;
                    }
                }
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return o;
    }

}
