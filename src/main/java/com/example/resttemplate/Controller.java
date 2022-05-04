package com.example.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {


    @GetMapping("/hello")
    public Object hello()
    {
        HashMap hashMap = new HashMap<>();
        hashMap.put(1,"hello");
        hashMap.put(2,"hello2");
        hashMap.put(3,"hello3");
        return hashMap;


    }

}
