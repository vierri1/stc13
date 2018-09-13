package lesson4.io.classwork.data;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Person tom = new Person("Tom", 35, 1.65, true);
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(new FileOutputStream("/Users/Andrey/Documents/Учеба/TempFiles/person.txt"))) {

            dataOutputStream.writeUTF(tom.getName());
            dataOutputStream.writeInt(tom.getAge());
            dataOutputStream.writeDouble(tom.getHeight());
            dataOutputStream.writeBoolean(tom.isMarried());
            System.out.println("Файл записан");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("/Users/Andrey/Documents/Учеба/TempFiles/person.txt"))) {
            Person newTom = new Person();
            newTom.setName(dataInputStream.readUTF());
            newTom.setAge(dataInputStream.readInt());
            newTom.setHeight(dataInputStream.readDouble());
            newTom.setMarried(dataInputStream.readBoolean());
            System.out.println(newTom);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
