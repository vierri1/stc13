package lesson7.classloaders.homework.generateclass;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenerateClass {
    public void generate(String path) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder();
        System.out.println("Enter your method: \n");
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            if (str.equals("")) {
                break;
            }
            text.append(str + "\n");
        }
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write("package " + getClass().getPackage().getName() + ";\n");
            fileWriter.write("\npublic class MyDynamicClass implements MyInterface{\n");
            fileWriter.write("\npublic void doWork() {\n");
            fileWriter.write(text.toString());
            fileWriter.write("\n}\n}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
