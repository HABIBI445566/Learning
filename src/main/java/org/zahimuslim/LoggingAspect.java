package org.zahimuslim;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // before (the function in the annotation is called), this logger needs to be called
    // we need to give two dots in checkout so that it takes any number of parameters
    @Before("execution(* org.zahimuslim.ShoppingCart.checkout(..))")
    public void beforelogger()
    {
        System.out.println("Loggers");
    }
    // understand this, where do you want it to be called and when do you want it to be called

    // for any return type , for any package, for any class, with function checkout this will work (To understand *)
    // we need to give two dots in checkout so that it takes any number of parameters
    //@After("execution(*  *.*.checkout(..))") For some reason this doesnt work and I was forced to give the package name, it worked for the guy in yt
    @After("execution(*  org.zahimuslim.*.checkout(..))")
    public void afterlogger()
    {
        System.out.println("After Loggers");
    }
}
