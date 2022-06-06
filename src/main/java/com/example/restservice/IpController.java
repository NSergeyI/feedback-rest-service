package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class IpController {

    private final AtomicLong counter = new AtomicLong();
    private static final String[] IP_HEADER_CANDIDATES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    @GetMapping("/ip")
    public Ip ip(HttpServletRequest request) {
        String ip;
        Enumeration<String> headerNames  = request.getHeaderNames();
        HashMap<String, String> headers = new HashMap<>();
        while (headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            headers.put(name, request.getHeader(name));
        }
        for (String headerIp: IP_HEADER_CANDIDATES) {
            String ipList = request.getHeader(headerIp);
            if (ipList != null && ipList.length() != 0 && !"unknown".equalsIgnoreCase(ipList)) {
                ip = ipList.split(",")[0];
                return new Ip(counter.incrementAndGet(), ip, headers);
            }
        }
        ip = request.getRemoteAddr();
        return new Ip(counter.incrementAndGet(), ip, headers);
    }
}
