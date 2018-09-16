package lesson4.io.homework.genText;

public class Test {
    public static void main(String[] args) {
        TextGenerator textGenerator = new TextGenerator();
        String[] words = {"innopolis", "stc13", "java", "spring", "hibernate"};
        textGenerator.genFiles("/Users/Andrey/Documents/Учеба/TempFiles/", 25, 100, words, 10);
    }
}
