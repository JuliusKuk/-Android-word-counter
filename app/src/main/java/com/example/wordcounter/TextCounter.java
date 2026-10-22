
package com.example.wordcounter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextCounter {

    public int CountWords(String text) {
        String cleanedText = text.trim();

        if (cleanedText.isEmpty()) {
            return 0;
        }

        return cleanedText.split("[ ,.]+").length;
    }

    public int CountSentences(String text) {
        String[] sentences = text.split("\\.+");
        int sentenceCount = 0;

        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                sentenceCount++;
            }
        }

        return sentenceCount;
    }

    public int CountPunctuation(String text) {
        int punctuationCount = 0;

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);

            if (character == ' ' ||
                    character == ',' ||
                    character == '.') {
                punctuationCount++;
            }
        }

        return punctuationCount;
    }

    public int CountNumbers(String text) {
        Pattern numberPattern = Pattern.compile("\\d+");
        Matcher numberMatcher = numberPattern.matcher(text);

        int numberCount = 0;

        while (numberMatcher.find()) {
            numberCount++;
        }

        return numberCount;
    }
}
