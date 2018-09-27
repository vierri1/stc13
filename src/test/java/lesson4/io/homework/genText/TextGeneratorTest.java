package lesson4.io.homework.genText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class TextGeneratorTest {

    private final String[] WORDS = new String[]{"word", "word"};
    private TextGenerator generator;

    @BeforeEach
    void beforeEach() {
        generator = new TextGenerator();
    }

    @RepeatedTest(50)
    void randomIntTest() {
        int num = generator.getRandomInt(5, 5);
        assertTrue(num <= 10 && num >= 5);
    }

    @RepeatedTest(50)
    void endSymbTest() {
        char ch = generator.getEndSymb();
        assertTrue(ch == '.' || ch == '!' || ch == '?' || ch == '…');
    }

    @RepeatedTest(50)
    void getSentenceLengthTest() {
        String str = generator.getSentence(10, WORDS);
        int length = str.split(" ").length;
        assertTrue(length >= 1 && length <= 15);
    }

    @RepeatedTest(50)
    void getWordLength() {
        String word = generator.getRandomWord();
        assertTrue(word.length() >= 1 && word.length() <= 15);
    }

    @Test
    void insertWordInSentenceTest() {
        String sent = generator.getSentence(1, WORDS);
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sent.toLowerCase().split("[\\s,]")));
        assertTrue(words.contains("word"));
    }

    @Test
    void fileGenNotThrowExc() {
        assertDoesNotThrow(() -> generator.genFiles("file", 1, 1, WORDS, 1));
    }

    @Test
    void fileGenThrowsExc() {
        assertThrows(IOException.class, () -> generator.genFiles("/lol/file", 1, 1, WORDS, 1));
    }
}