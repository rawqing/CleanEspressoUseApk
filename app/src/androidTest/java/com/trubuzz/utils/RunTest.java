package com.trubuzz.utils;

import com.trubuzz.feature.BaseTest;

import java.util.List;
import java.util.Objects;

/**
 * Created by king on 2016/6/30.
 */
public class RunTest {

    public static <T> void forEach(BaseTest bt, List<T> data){
        Objects.requireNonNull(data);
        for(T t:data){
            bt.setIn(t);
        }
    }
}
