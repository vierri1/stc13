package lesson4.io.homework.genText;

import java.util.Random;

public class GeneratorUtilsImpl implements GeneratorUtils {

    @Override
    public boolean isNeedInsert(int probability) {
        return probability != 0 && getRandomInt(1, probability) == 1;
    }

    @Override
    public String getRandomWord() {
        int wordLength = getRandomInt(1, 15);
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            char symb = (char) getRandomInt(97, 26);
            word.append(symb);
        }
        return word.toString();
    }

    @Override
    public String getWordFromArray(String[] words) {
        int index = getRandomInt(0, words.length);
        return words[index];
    }

    @Override
    public char getEndSymb() {
        char[] arrayMarks = {'.', '!', '?', '…'};
        int randomIndex = getRandomInt(0, arrayMarks.length);
        return arrayMarks[randomIndex];
    }

    @Override
    public int getRandomInt(int min, int bound) {
        Random random = new Random();
        return min + random.nextInt(bound);
    }
}
