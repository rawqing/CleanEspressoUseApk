package com.trubuzz.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by king on 2016/6/30.
 */
public class DLogin {
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";

    public static final Map<String,String> INPUT1 = new HashMap<String,String>(){{
        put(USER_NAME, "abc@abc.com");
        put(PASSWORD, "aA123321");
    }};

    public static final List<Map<String,String>> INPUT2 = Arrays.asList(
        INPUT1
);
    public static final List<Map<String,String>> INPUT = new ArrayList<Map<String,String>>(){{
        add( new HashMap<String,String>(){{
                put(USER_NAME, "abc@abc.com");
                put(PASSWORD, "aA123321");
        }});
        add( new HashMap<String,String>(){{
                put(USER_NAME, "23423423423");
                put(PASSWORD, "");
        }});
        add( new HashMap<String,String>(){{
                put(USER_NAME, "zhao.deng@jucaidao.com");
                put(PASSWORD, "aA123321");
        }});
    }};
}
