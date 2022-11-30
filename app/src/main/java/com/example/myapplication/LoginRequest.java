package com.example.myapplication;

import androidx.annotation.Nullable;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest {

    final static private String URL  = "http://122.128.135.40/androidLogin";
    private Map<String,String> map ;


    public LoginRequest(String userId, String userPassword
            , Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userId",userId);
        map.put("userPassword", userPassword);
    }

    protected Map getParams() {
        return map;
    }
}
