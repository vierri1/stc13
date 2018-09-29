package lesson4.io.homework.genText;

public interface GeneratorUtils {
    String getRandomWord();

    String getWordFromArray(String words[]);

    char getEndSymb();

    int getRandomInt(int min, int bound);

    boolean isNeedInsert(int probability);
}
