package lesson4.io.homework.genText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

class TextGeneratorTest {

    private final String[] WORDS = new String[]{"word", "word"};
    private final String RANDOM_WORD = "RandomWord";
    private TextGenerator generator;
    private GeneratorUtils generatorUtils = Mockito.mock(GeneratorUtils.class);

    @BeforeEach
    void beforeEach() {
        generator = new TextGenerator(generatorUtils);
    }

    @Test
    void getSentenceLengthTest() {
        when(generatorUtils.getRandomInt(anyInt(), anyInt())).thenReturn(10);
        when(generatorUtils.isNeedInsert(anyInt())).thenReturn(false);
        when(generatorUtils.getRandomWord()).thenReturn(RANDOM_WORD);
        when(generatorUtils.getEndSymb()).thenReturn('!');
        String str = generator.getSentence(10, WORDS);
        int length = str.split(" ").length;
        assertEquals(length, 10);
    }

    @Test
    void insertWordInSentenceTest() {
        when(generatorUtils.getRandomInt(anyInt(), anyInt())).thenReturn(5);
        when(generatorUtils.isNeedInsert(anyInt())).thenReturn(true, false);
        when(generatorUtils.getWordFromArray(any())).thenReturn(WORDS[0]);
        when(generatorUtils.getEndSymb()).thenReturn('!');
        when(generatorUtils.getRandomWord()).thenReturn(RANDOM_WORD);
        String sent = generator.getSentence(1, WORDS);
        ArrayList<String> words = new ArrayList<>(Arrays.asList(sent.toLowerCase().split("[\\s,]")));
        assertTrue(words.contains("word"));
    }


    @Test
    void fileGenNotThrowExc() {
        when(generatorUtils.getRandomInt(anyInt(), anyInt())).thenReturn(1, 10);
        when(generatorUtils.isNeedInsert(anyInt())).thenReturn(false);
        when(generatorUtils.getRandomWord()).thenReturn(RANDOM_WORD);
        when(generatorUtils.getEndSymb()).thenReturn('!');
        assertDoesNotThrow(() -> generator.genFiles("file", 1, 1, WORDS, 1));
    }

    @Test
    void fileGenThrowsExc() {
        when(generatorUtils.getRandomInt(anyInt(), anyInt())).thenReturn(1, 10);
        when(generatorUtils.isNeedInsert(anyInt())).thenReturn(false);
        when(generatorUtils.getRandomWord()).thenReturn(RANDOM_WORD);
        when(generatorUtils.getEndSymb()).thenReturn('!');
        assertThrows(IOException.class, () -> generator.genFiles("/lol/file", 1, 1, WORDS, 1));
    }
}