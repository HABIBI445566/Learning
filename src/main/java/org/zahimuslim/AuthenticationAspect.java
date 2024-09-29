package org.zahimuslim;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {

    // all the methods and class under zahimuslim
    @Pointcut("within(org.zahimuslim..*)")
    public void authenticatingPointCut()
    {
        // for all the packages you need to authenticate and authorize
        // we can have point cuts for different packages
        // in Logging Aspect we used execution(), that defines to which method do you want to execute
        // over here we are going to use within to target a particular class for all the methods available

    }
    @Pointcut("within(org.zahimuslim..*)")
    public void authorizationPointCut()
    {

    }

    // now this will execute for that pointcut I suppose to every method which is involved with
    @Before("authenticatingPointCut() && authorizationPointCut()")
    public void authenticate()
    {
        System.out.println("Authenticating the request");
    }
}
