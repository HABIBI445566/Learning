package com.zahimuslim.Spring_boot_learning.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello()
    {
        return "Hello welcome to my youtube channel";
    }
}
