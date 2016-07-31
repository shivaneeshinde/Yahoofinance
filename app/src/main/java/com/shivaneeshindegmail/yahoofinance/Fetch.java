package com.shivaneeshindegmail.yahoofinance;

import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.util.HashMap;
import java.util.Map;


public class Fetch extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://rlyconcession.vjti/stock/nse.php";
    private Map<String, String> params;

    public Fetch(String name, Response.Listener<String> listener) {
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
