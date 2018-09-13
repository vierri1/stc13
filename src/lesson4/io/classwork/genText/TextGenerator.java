package lesson4.io.classwork.genText;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TextGenerator {

    public void genFiles(String path, int n, int size, String[] words, int probability) {
        for (int i = 1; i <= n; i++) {
            try (FileWriter fileWriter = new FileWriter(path + "file" + i + ".txt")) {
                fileWriter.write(genText(size, probability, words));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String genText(int size, int probability, String[] word) {
        int bound = 20;
        int countGenSent = 0;
        if (size < 20) {
            bound = size;
        }
        StringBuilder text = new StringBuilder();
        int paragraphLength;
        int sentencesLeft = size - countGenSent;
        while (sentencesLeft > 0) {
            paragraphLength = getRandomInt(1, bound);
            for (int i = 0; i < paragraphLength; i++) {
                text.append(getSentence(probability, word));
                countGenSent++;
            }
            text.append("   \n");
            sentencesLeft = size - countGenSent;
            if (sentencesLeft > 20) {
                bound = 20;
            } else {
                bound = sentencesLeft;
            }
        }
        return text.toString();
    }

    private String getSentence(int probability, String[] words) {
        boolean isStartSentence = true;
        boolean isWordInsered = false;
        int sentenceLength = getRandomInt(1, 15);
        StringBuilder sentence = new StringBuilder();
        String word;
        for (int i = 0; i < sentenceLength; i++) {
            if (!isWordInsered && isNeedInsert(probability)) {
                word = getWordFromArray(words);
                isWordInsered = true;
            } else {
                word = getRandomWord();
            }
            if (isStartSentence) {
                char[] charsWord = word.toCharArray();
                charsWord[0] = Character.toUpperCase(charsWord[0]);
                word = String.valueOf(charsWord);
                isStartSentence = false;
            }
            sentence.append(word);
            if (i == sentenceLength - 1) {
                sentence.append(getEndSymb()).append(" ");
            } else if (getRandomInt(1, 10) == 1) {
                sentence.append(", ");
            } else {
                sentence.append(" ");
            }
        }
        return sentence.toString();
    }

    private boolean isNeedInsert(int probability) {
        return probability != 0 && getRandomInt(1, probability) == 1;
    }

    private String getRandomWord() {
        int wordLength = getRandomInt(1, 15);
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < wordLength; i++) {
            char symb = (char) getRandomInt(97, 26);
            word.append(symb);
        }
        return word.toString();
    }

    private String getWordFromArray(String[] words) {
        int index = getRandomInt(0, words.length - 1);
        return words[index];
    }

    private char getEndSymb() {
        char[] arrayMarks = {'.', '!', '?'};
        int randomIndex = getRandomInt(0, arrayMarks.length);
        return arrayMarks[randomIndex];
    }


    private int getRandomInt(int min, int bound) {
        Random random = new Random();
        return min + random.nextInt(bound);
    }
}
