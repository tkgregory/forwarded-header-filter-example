package com.tomgregory.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.AbstractMap;
import java.util.Map;

@RestController
public class MyController {
    @GetMapping(value = "/absoluteURL", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAbsoluteURLWithoutFilter() {
        return buildURL();
    }

    @GetMapping(value = "/absoluteURLWithFilter", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAbsoluteURLWithFilter() {
        return buildURL();
    }

    private String buildURL() {
        return ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
    }

    private Map<String, String> getRequestInfo(HttpServletRequest httpServletRequest) {
        return Map.ofEntries(
                new AbstractMap.SimpleEntry<>("serverName", httpServletRequest.getServerName()),
                new AbstractMap.SimpleEntry<>("serverPort", String.valueOf(httpServletRequest.getServerPort())),
                new AbstractMap.SimpleEntry<>("scheme", String.valueOf(httpServletRequest.getScheme())),
                new AbstractMap.SimpleEntry<>("isSecure", String.valueOf(httpServletRequest.isSecure()))
        );
    }
}
