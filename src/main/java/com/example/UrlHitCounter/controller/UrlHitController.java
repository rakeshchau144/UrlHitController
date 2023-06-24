package com.example.UrlHitCounter.controller;

import com.example.UrlHitCounter.service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {
    @Autowired
    public UrlHitService urlHitService;

    @GetMapping("username/{username}/count")
    public Map<String, Object> getHitCountByUsername(@PathVariable String username) {
        int hitCount = urlHitService.getHitCountByUsername(username);
        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", hitCount);
        return response;
    }
}
