package org.zahimuslim;

import com.sun.source.doctree.DocTree;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;


public class Main {
    public static void main(String[] args) {
       // This is the start of AOP
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ShoppingCart cart = context.getBean(ShoppingCart.class);
        cart.checkout("Working");

        /*
        This was the result of trying to log,
        you get your logging as aspect thing
        1) Get your dependency
        2) Add annotation in BeanConfig and LoggingAspect
        3) Run it and you will see it


        Loggers
Checkout Method from ShoppingCart Called
*/
    }
}