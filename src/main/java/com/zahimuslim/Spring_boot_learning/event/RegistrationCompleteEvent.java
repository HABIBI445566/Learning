package com.zahimuslim.Spring_boot_learning.event;

import com.zahimuslim.Spring_boot_learning.entity.User;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;

public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String applicationUrl;


    public RegistrationCompleteEvent(User user, String appUrl)
    {
        super(user);
        this.user = user;
        this.applicationUrl = appUrl;
    }
}
