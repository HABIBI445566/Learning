package com.zahimuslim.Spring_boot_learning.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// ctrl + Alt + o to remove all the unused imports

//this by default will be a component and also tells that this will always return a response body
@RestController
public class HelloController {

    @Value("${welcome.message}")
    private String welcomeMessage;


    //we are telling what will be the end point, when you put localhost/ it will hit this and the method type is GET
    //@RequestMapping(value = "/", method = RequestMethod.GET)
    //By this we can simply get the end point / and we know its a get method
    @GetMapping("/")
    public String helloworld()
    {
        //over here this is hardcoded, suppose if we wanted something from the properties file we could do something like this
        return welcomeMessage;
        //There is a way to run the applicaiton as we are building it without stopping and rerunning each time, check about the registry
    }
    /*
    * Spring boot does everything for you, suppose if you want to do something like change the default port, from 8080 to 8082 you need to check
    * application.properties file*/
}
