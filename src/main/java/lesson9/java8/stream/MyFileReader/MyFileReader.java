package lesson9.java8.stream.MyFileReader;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class MyFileReader {
    public void getWordsFromFile(String path, String path2) throws IOException {

        String text = Files.lines(Paths.get(path))
                .flatMap(p -> Arrays.stream(p.split("[\\s,\\.\\!\\?\\-\":)(;]")))
                .distinct()
                .map(String::toLowerCase)
                .collect(Collectors.joining("|"));

        FileWriter fileWriter = new FileWriter(path2);
        fileWriter.write(text);
        fileWriter.close();
    }
}
