package com.trubuzz.utils;

import android.app.FragmentManager;
import android.support.test.espresso.IdlingResource;

/**
 * Created by king on 2016/7/1.
 */
public class ProgressFramentIdlingResource implements IdlingResource {
    private FragmentManager fragmentManager;
    private ResourceCallback resourceCallback;

    public ProgressFramentIdlingResource(FragmentManager fg) {
        fragmentManager = fg;
    }

    @Override
    public String getName() {
        return ProgressFramentIdlingResource.class.getName();
    }

    @Override
    public boolean isIdleNow() {
        //通过当前页面的fragment 是否存在以及可见，来判断。
//        for (Fragment fragment: Activity) {
//            if(fragment != null && fragment.isVisible()) {
//                resourceCallback.onTransitionToIdle();
//                return false;
//            }
//
//        }

        return true;
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        resourceCallback = callback;
    }
}
