package org.zahimuslim;

import org.springframework.stereotype.Component;

import javax.print.Doc;


//to use annotations we need to use @Component , whatever is marked with this we are telling beans that you can use it to make beans out of it.
@Component
public class Doctor implements Staff{
    private String qualification;
    public void assist()
    {
        System.out.println("Doctor is assisting");
    }

}
