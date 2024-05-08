package com.example.softlab;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSubtraction() {
        // Type numbers into EditText fields
        onView(withId(R.id.editTextNumber1)).perform(replaceText("5"));
        onView(withId(R.id.editTextNumber2)).perform(replaceText("3"));

        // Close soft keyboard if it's open
        onView(withId(R.id.editTextNumber2)).perform(click());

        // Click on the subtract button
        onView(withId(R.id.buttonSubtract)).perform(click());

        // Check if result is displayed correctly
        onView(withId(R.id.textViewResult)).check(matches(withText("Result: 2.0")));
    }

    @Test
    public void testEmptyFieldsError() {
        // Leave EditText fields empty

        // Click on the subtract button
        onView(withId(R.id.buttonSubtract)).perform(click());

        // Check if error message is displayed
        onView(withId(R.id.textViewResult)).check(matches(withText("Please enter numbers in both fields")));
    }
}
