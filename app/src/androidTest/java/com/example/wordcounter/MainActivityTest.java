
package com.example.wordcounter;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;



@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void countWordsDisplaysCorrectResult() {
        onView(withId(R.id.txtInputCounted))
                .perform(replaceText("Hello world Java"),
                        closeSoftKeyboard());

        onView(withId(R.id.btnCount)).perform(click());

        onView(withId(R.id.txtViewWordCount))
                .check(matches(withText("Words: 3")));
    }

    @Test
    public void countSentencesDisplaysCorrectResult() {
        onView(withId(R.id.txtInputCounted))
                .perform(replaceText("Hello. World."),
                        closeSoftKeyboard());

        onView(withId(R.id.btnCount)).perform(click());

        onView(withId(R.id.txtViewSentenceCount))
                .check(matches(withText("Sentences: 2")));
    }

    @Test
    public void countPunctuationDisplaysCorrectResult() {
        onView(withId(R.id.txtInputCounted))
                .perform(replaceText("Hello, world."),
                        closeSoftKeyboard());

        onView(withId(R.id.btnCount)).perform(click());

        onView(withId(R.id.txtViewPunctuationCount))
                .check(matches(withText("Punctuation: 3")));
    }

    @Test
    public void countNumbersDisplaysCorrectResult() {
        onView(withId(R.id.txtInputCounted))
                .perform(replaceText("Cia turetu buti tik 2 ir tiktai 2 skaiciai"),
                        closeSoftKeyboard());

        onView(withId(R.id.btnCount)).perform(click());

        onView(withId(R.id.txtViewNumberCount))
                .check(matches(withText("Numbers: 2")));
    }

    @Test
    public void inputFieldAcceptsText() {
        onView(withId(R.id.txtInputCounted))
                .perform(replaceText("Testing Android"));

        onView(withId(R.id.txtInputCounted))
                .check(matches(withText("Testing Android")));
    }
}
