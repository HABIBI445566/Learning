package com.zahimuslim.Spring_boot_learning.event.listener;

import com.zahimuslim.Spring_boot_learning.entity.User;
import com.zahimuslim.Spring_boot_learning.event.RegistrationCompleteEvent;
import com.zahimuslim.Spring_boot_learning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;


@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {


    @Autowired
    private UserService userService;


    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //create the verification Token for user with link
        User user = event.getUser();
        //whatever token is generated we can save this for a particular user, whenever the user hits the link, we get a token if both the token matches only then we would let them login
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        //Once link is created send mail to the user
        String url = event.getApplicationUrl() + "verifyRegistration?token="+ token;

        //sendVerificationEmail()
        log.info("Click the link to verify your account: {}",url);
    }
}
