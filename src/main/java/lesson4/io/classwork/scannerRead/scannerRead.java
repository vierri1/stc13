package lesson4.io.classwork.scannerRead;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class scannerRead {
    public static void main(String[] args) {
        File file = new File("/Users/Andrey/Documents/Учеба/TempFiles/temp.txt");
        List<String> stringList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                stringList.add(line);
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
