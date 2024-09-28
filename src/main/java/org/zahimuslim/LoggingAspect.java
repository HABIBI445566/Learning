package org.zahimuslim;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // before (the function in the annotation is called), this logger needs to be called
    @Before("execution(* org.zahimuslim.ShoppingCart.checkout())")
    public void logger()
    {
        System.out.println("Loggers");
    }
    // understand this, where do you want it to be called and when do you want it to be called
}
