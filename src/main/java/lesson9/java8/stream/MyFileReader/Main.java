package lesson9.java8.stream.MyFileReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyFileReader reader = new MyFileReader();
        reader.getWordsFromFile("/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson4/io/homework/genText/harrypottertext.txt",
                "/Users/Andrey/Documents/Учеба/stc13/projects/lessonsProject/src/lesson4/io/homework/genText/resultarray.txt");

    }
}
