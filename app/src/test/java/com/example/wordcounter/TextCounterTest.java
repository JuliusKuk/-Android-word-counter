
package com.example.wordcounter;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import static org.junit.Assert.assertEquals;

public class TextCounterTest {

    private TextCounter textCounter;

    @Before
    public void setUp() {
        textCounter = new TextCounter();
    }

    @Test
    public void countWordsReturnsCorrectResult() {
        int result = textCounter.CountWords("Hello world Java");
        assertEquals(3, result);
    }

    @Test
    public void countWordsWithEmptyTextReturnsZero() {
        int result = textCounter.CountWords("");
        assertEquals(0, result);
    }

    @Test
    public void countWordsWithMultipleSpaces() {
        int result = textCounter.CountWords("Hello   world");
        assertEquals(2, result);
    }

    @Test
    public void countSentencesReturnsCorrectResult() {
        int result = textCounter.CountSentences("Hello. World.");
        assertEquals(2, result);
    }

    @Test
    public void countSentencesWithEmptyTextReturnsZero() {
        int result = textCounter.CountSentences("");
        assertEquals(0, result);
    }

    @Test
    public void countPunctuationReturnsCorrectResult() {
        int result = textCounter.CountPunctuation("Hello, world.");
        assertEquals(3, result);
    }

    @Test
    public void countPunctuationWithoutSymbolsReturnsZero() {
        int result = textCounter.CountPunctuation("Hello");
        assertEquals(0, result);
    }

    @Test
    public void countNumbersReturnsCorrectResult() {
        int result = textCounter.CountNumbers("Cia turetu buti tik 2 ir tiktai 2 skaiciai");
        assertEquals(2, result);
    }

    @Test
    public void countNumbersWithoutDigitsReturnsZero() {
        int result = textCounter.CountNumbers("Hello world");
        assertEquals(0, result);
    }

    @Test
    public void countNumbersWithMultipleDigits() {
        int result = textCounter.CountNumbers("123 456 789");
        assertEquals(3, result);
    }
}
