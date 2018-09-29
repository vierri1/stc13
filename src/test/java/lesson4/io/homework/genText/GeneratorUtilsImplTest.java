package lesson4.io.homework.genText;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GeneratorUtilsImplTest {

    private GeneratorUtils generatorUtils;

    @BeforeEach
    void setUp() {
        generatorUtils = new GeneratorUtilsImpl();
    }

    @RepeatedTest(50)
    void randomIntTest() {
        int num = generatorUtils.getRandomInt(5, 5);
        assertTrue(num <= 10 && num >= 5);
    }

    @RepeatedTest(50)
    void endSymbTest() {
        char ch = generatorUtils.getEndSymb();
        assertTrue(ch == '.' || ch == '!' || ch == '?' || ch == '…');
    }


    @RepeatedTest(50)
    void getWordLength() {
        String word = generatorUtils.getRandomWord();
        assertTrue(word.length() >= 1 && word.length() <= 15);
    }

    @Test
    void isNeedInsertTrueTest() {
        assertTrue(generatorUtils.isNeedInsert(1));
    }

    @Test
    void getWordFromArrayTest() {
        assertEquals("word", generatorUtils.getWordFromArray(new String[]{"word"}));
    }

}