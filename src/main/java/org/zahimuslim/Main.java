package org.zahimuslim;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.print.Doc;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // I am making changes to the main projects to check if my push was succssfull or not




        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        // there are many ways to get this context but we shall go with xml
        //based configration

        // everything we did till now we have used constructor and setter injection
        // this wont work beacause we have not defined this in the xml
       // Doctor doctor = context.getBean(Doctor.class);
        // we can get this object by using the ID
       // Nurse nurse = (Nurse) context.getBean("nurse");
        //we have created an interface called Staff, which the doc and then nurse both implements
        // now we can write thing this way.
        Staff staff = context.getBean(Doctor.class);
        // this way we have decopled the entire application.
        //staff.assist();
        // nurse.assist();
       /* Doctor doc = new Doctor();*/
        //doctor.assist();
        // Doctor docqal = context.getBean(Doctor.class);
        System.out.println("docqal" );
        staff.assist();

        //we shall move to annotions now, I will be commenting all the beans from the spring.xml file.

    }
}