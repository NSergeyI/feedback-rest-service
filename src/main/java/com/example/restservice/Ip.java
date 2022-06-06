package com.example.restservice;

import java.util.HashMap;

public class Ip {

    private final long id;
    private final String ip;
    private final HashMap<String, String> headers;

    public Ip(long id, String ip, HashMap<String, String> headers) {
        this.id = id;
        this.ip = ip;
        this.headers = headers;
    }

    public long getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }
}
