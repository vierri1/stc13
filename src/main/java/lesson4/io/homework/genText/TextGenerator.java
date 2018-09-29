package lesson4.io.homework.genText;

import java.io.FileWriter;
import java.io.IOException;

public class TextGenerator {
    private int countInseredWords;
    private int countSentence;
    private GeneratorUtils generatorUtils;

    public TextGenerator(GeneratorUtils generatorUtils) {
        this.generatorUtils = generatorUtils;
    }

    public void genFiles(String path, int n, int size, String[] words, int probability) throws IOException {
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
                    paragraphLength = generatorUtils.getRandomInt(1, bound);
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
                throw e;
            }
        }
        System.out.println(countInseredWords);
        System.out.println(countSentence);
    }

    String getSentence(int probability, String[] words) {
        boolean isStartSentence = true;
        boolean isWordInsered = false;
        int sentenceLength = generatorUtils.getRandomInt(1, 15);
        StringBuilder sentence = new StringBuilder();
        String word;
        for (int i = 0; i < sentenceLength; i++) {
            if (!isWordInsered && generatorUtils.isNeedInsert(probability)) {
                countInseredWords++;
                word = generatorUtils.getWordFromArray(words);
                isWordInsered = true;
            } else {
                word = generatorUtils.getRandomWord();
            }
            if (isStartSentence) {
                char[] charsWord = word.toCharArray();
                charsWord[0] = Character.toUpperCase(charsWord[0]);
                word = String.valueOf(charsWord);
                isStartSentence = false;
            }
            sentence.append(word);
            if (i == sentenceLength - 1) {
                sentence.append(generatorUtils.getEndSymb()).append(" ");
            } else if (generatorUtils.getRandomInt(1, 10) == 1) {
                sentence.append(", ");
            } else {
                sentence.append(" ");
            }
        }
        countSentence++;
        return sentence.toString();
    }
}
