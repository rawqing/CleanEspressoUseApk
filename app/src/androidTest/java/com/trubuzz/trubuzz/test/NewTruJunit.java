package com.trubuzz.trubuzz.test;

import android.content.Context;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.trubuzz.data.DLogin;
import com.trubuzz.feature.BaseTest;
import com.trubuzz.utils.Find;
import com.trubuzz.utils.Match;
import com.trubuzz.utils.RunTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import java.util.Map;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.*;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewTruJunit  {

  	private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.trubuzz.roy.MainActivity";

    private static Class<?> launcherActivityClass;
    static{
        try {
            launcherActivityClass = Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
           throw new RuntimeException(e);
        }
    }

    @Rule
    public ActivityTestRule<?> mActivityTestRule = new ActivityTestRule(launcherActivityClass);

  //  @Test
	public void mainActivityTest() throws InterruptedException {
        Thread.sleep(2000);
		System.out.println("test1");
        onView((withText("登入"))).perform(click());
        Thread.sleep(1000);
	}

    @Test
    public void testLogin() throws InterruptedException {
//        Thread.sleep(2000);
//        onView(withId(getResourceId("submit"))).perform(click());
//        onView(withId(getId("com.trubuzz.trubuzz:id/submit"))).perform(click());

//        INPUT.forEach(n -> {
//            onView(Match.login.user).perform(typeText(n.get(USER_NAME)));
//            onView(Match.login.pwd).perform(typeText(n.get(PASSWORD)));
//            onView(Match.login.submit).perform(click());
//        });
//        RunTest.forEach(new BaseTest() {
//            @Override
//            public <T> void setIn(T t) {
//                onView(Match.login.user).perform(typeText(((Map<String,String>)t).get(DLogin.USER_NAME)));
//                onView(Match.login.pwd).perform(typeText(((Map<String,String>)t).get(DLogin.PASSWORD)));
//                onView(Match.login.submit).perform(click());
//            }
//        },DLogin.INPUT);

        for(Map<String,String> map : DLogin.INPUT){
            onView(allOf(Match.login.user,isDisplayed())).perform(replaceText(map.get(DLogin.USER_NAME)));
            onView(Match.login.pwd).perform(replaceText(map.get(DLogin.PASSWORD)));
            onView(Match.login.submit).perform(click());
            if(Find.isToast(onView(withText("无效的账户或密码")),mActivityTestRule)){

           //     Thread.sleep(3000);
            }
        }



    }

    public static int getResourceId(String s) {
        Context targetContext = getTargetContext();
        String packageName = targetContext.getPackageName();
        return targetContext.getResources().getIdentifier(s, "id", packageName);
    }

    public static int getId(String resourcesId){
        String packageName = resourcesId.split(":")[0];
        String id = resourcesId.split("/")[1];
        return getTargetContext().getResources().getIdentifier(id ,"id",packageName);
    }
}
