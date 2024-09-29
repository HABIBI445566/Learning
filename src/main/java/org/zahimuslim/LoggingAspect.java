package org.zahimuslim;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;

@Aspect
@Component
public class LoggingAspect {

    // before (the function in the annotation is called), this logger needs to be called
    // we need to give two dots in checkout so that it takes any number of parameters
    @Before("execution(* org.zahimuslim.ShoppingCart.checkout(..))")
    public void beforelogger(JoinPoint jp)
    {
        System.out.println("type of signature"+jp.getSignature());
        System.out.println("Loggers");
        // if we want to get the value of arguments you can do it this way
        System.out.println("Before Loggers Getting Arguments ->"+jp.getArgs()[0].toString());
        /*
        * Authenticating the request
type of signaturevoid org.zahimuslim.ShoppingCart.checkout(String)
Loggers
Checkout Method from ShoppingCart Called
After Loggers
*
* This way we can get details of the class and arguments
* */


        /*
        * Authenticating the request
type of signaturevoid org.zahimuslim.ShoppingCart.checkout(String)
Loggers
Before Loggers Getting Arguments ->Working
Checkout Method from ShoppingCart Called
After Loggers
*
* we can get teh inout parameters as well to log them*/
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

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retValue")
    public void afterReturn(int retValue)
    {
        System.out.println("After Returning : "+retValue);
    }
    // here we created a point cut named afterReturningPointCut, then we created one more function
    // after return and annotated with AfterReturn and target it to the particular point cut with getting a return value
/*
This is the results ->


* Authenticating the request
type of signaturevoid org.zahimuslim.ShoppingCart.checkout(String)
Loggers
Before Loggers Getting Arguments ->Working
Checkout Method from ShoppingCart Called
After Loggers
Authenticating the request
After Returning : 20*/

    @Pointcut("execution(* org.zahimuslim.*.quantity(..))")
    public void afterReturningPointCut()
    {

    }
}
