package org.zahimuslim;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.print.Doc;

@Component
//to use annotations we need to use @Component , whatever is marked with this we are telling beans that you can use it to make beans out of it.
//if we want to define ourselves what kind of scopes that we would like to implement this is how we can do it
//@Scope(scopeName = "singleton")
@Scope(scopeName = "prototype")
//now we are setting the scope as prototype so.. we would get a new object each time we request for an object.
//after adding this as prototype and running still I didnt get a different type of Object, we have to declare this as @Component it seems I dont know why though, need to ask that
public class Doctor implements Staff{
    private String qualification;
    public void assist()
    {
        System.out.println("Doctor is assisting");
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "qualification='" + qualification + '\'' +
                '}';
    }
}
