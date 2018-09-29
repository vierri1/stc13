package lesson4.io.homework.genText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        TextGenerator textGenerator = new TextGenerator(new GeneratorUtilsImpl());

        String[] words = Files.lines(Paths.get("/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson4/io/homework/genText/resultarray.txt"))
                .flatMap(line -> Arrays.stream(line.split("[|]")))
                .limit(1000)
                .map(String::trim)
                .distinct()
                .filter(word -> !word.contains("'") && word.length() != 0)
                .toArray(String[]::new);


//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }
        textGenerator.genFiles("/Users/Andrey/WORDFINDER/generatedfiles2/", 1, 6000000, words, 10);
    }
}
