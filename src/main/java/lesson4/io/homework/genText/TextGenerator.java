package lesson4.io.homework.genText;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TextGenerator {
    private int countInseredWords;
    private int countSentence;

    public void genFiles(String path, int n, int size, String[] words, int probability) {
        for (int j = 1; j <= n; j++) {
            int bound = 20;
            int countGenSent = 0;
            if (size < 20) {
                bound = size;
            }
            int paragraphLength;
            int sentencesLeft = size - countGenSent;
            try (FileWriter fileWriter = new FileWriter(path + "file" + j + ".txt")) {
                while (sentencesLeft > 0) {
                    paragraphLength = getRandomInt(1, bound);
                    for (int i = 0; i < paragraphLength; i++) {
                        fileWriter.write(getSentence(probability, words));
                        countGenSent++;
                    }
                    fileWriter.append("\n");
                    sentencesLeft = size - countGenSent;
                    if (sentencesLeft > 20) {
                        bound = 20;
                    } else {
                        bound = sentencesLeft;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(countInseredWords);
        System.out.println(countSentence);
    }

    private String getSentence(int probability, String[] words) {
        boolean isStartSentence = true;
        boolean isWordInsered = false;
        int sentenceLength = getRandomInt(1, 15);
        StringBuilder sentence = new StringBuilder();
        String word;
        for (int i = 0; i < sentenceLength; i++) {
            if (!isWordInsered && isNeedInsert(probability)) {
                countInseredWords++;
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
        countSentence++;
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
        char[] arrayMarks = {'.', '!', '?', '…'};
        int randomIndex = getRandomInt(0, arrayMarks.length);
        return arrayMarks[randomIndex];
    }


    private int getRandomInt(int min, int bound) {
        Random random = new Random();
        return min + random.nextInt(bound);
    }
}
