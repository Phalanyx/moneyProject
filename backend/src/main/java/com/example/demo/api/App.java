package com.example.demo.api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class App {

    @GetMapping("/hello")
    public Map<String, String> index() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "world");
        map.put("foo", "bar");


        return map;
    }

}