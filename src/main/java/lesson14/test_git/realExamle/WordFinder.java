package lesson14.test_git.realExamle;

import java.net.URL;
import java.util.Set;

public interface WordFinder {
    Set<String> getSentences(URL resource);

    boolean checkIfWordInSentence(String sentence, String word);

    void writeSentenceToResult(String sentence);

}
