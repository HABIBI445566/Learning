package com.zahimuslim.Spring_boot_learning.Controller;


import com.zahimuslim.Spring_boot_learning.entity.User;
import com.zahimuslim.Spring_boot_learning.event.RegistrationCompleteEvent;
import com.zahimuslim.Spring_boot_learning.model.UserModel;
import com.zahimuslim.Spring_boot_learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationContoller {


    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel)
    {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(user,
                "url"));
        return "Success";

    }

}
