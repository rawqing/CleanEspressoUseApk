package com.trubuzz.utils;

import android.view.View;

import org.hamcrest.Matcher;

import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by king on 2016/6/29.
 */
public class Match {
    public static final class login{
        public static final Matcher<View> user = withId(Find.id("com.trubuzz.trubuzz:id/account"));
        public static final Matcher<View> pwd = withId(Find.id("com.trubuzz.trubuzz:id/password"));
        public static final Matcher<View> submit = withId(Find.id("com.trubuzz.trubuzz:id/submit"));


    }

    public static final class reg{
        public static final Matcher<View> email = withId(Find.id("com.trubuzz.trubuzz:id/email"));
    }
}
