package com.example.restservice;

public class Ip {

    private final long id;
    private final String ip;

    public Ip(long id, String ip) {
        this.id = id;
        this.ip = ip;
    }

    public long getId() {
        return id;
    }

    public String getIp() {
        return ip;
    }
}
