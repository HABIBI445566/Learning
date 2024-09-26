package org.zahimuslim;

import com.sun.source.doctree.DocTree;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;


public class Main {
    public static void main(String[] args) {
       // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // since we are not using xml config we need a different type of context for us

        //over here we add the class for configuration
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Staff staff = context.getBean(Doctor.class);
        staff.assist();
    }
}