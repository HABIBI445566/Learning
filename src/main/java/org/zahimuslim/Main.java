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
        //the same way how we did in the xml configuration we can do the same thing over here
        Doctor staff = context.getBean(Doctor.class);
        staff.assist();
        staff.setQualification("MBBS");
       /* System.out.println(staff);
        // this proves that the default the bean is in singleton scope
        Doctor doctor = context.getBean(Doctor.class);
        System.out.println(doctor);*/
        /*
        * Results ->
        *
        * Doctor is assisting
        Doctor{qualification='MBBS'}
        Doctor{qualification='MBBS'}
        *
        *
        * */
    }
}