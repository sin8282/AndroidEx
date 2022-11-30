package com.example.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL  = "http://122.128.135.40/androidRegister";
    private Map<String,String> map ;


    public RegisterRequest(String userId, String userPassword, String userName, String userAge
            , Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userId",userId);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userAge", userAge+"");
    }

    protected Map getParams() { return map; }
}
