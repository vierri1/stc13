package lesson4.io.classwork.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        copyFile("/Users/Andrey/Documents/Учеба/TempFiles/temp.txt", "/Users/Andrey/Documents/Учеба/TempFiles/copy.txt");

    }

    public static void writeFile(String fileName, String content) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] buffer = content.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static char[] readFile(String fileName) {
        //"/Users/Andrey/Documents/Учеба/TempFiles/temp.txt"
        char[] chars = null;
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            int c = -1;
            chars = new char[fileInputStream.available()];
            for (int j = 0; (c = fileInputStream.read()) != -1; j++) {
                chars[j] = (char) c;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return chars;
    }

    public static void copyFile(String fileName1, String fileName2) {
        char[] chars = readFile(fileName1);
        writeFile(fileName2, String.valueOf(chars));
    }

}
