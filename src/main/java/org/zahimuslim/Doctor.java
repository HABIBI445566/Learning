package org.zahimuslim;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.print.Doc;

@Component
@Scope(scopeName = "prototype")
//to use annotations we need to use @Component , whatever is marked with this we are telling beans that you can use it to make beans out of it.
public class Doctor implements Staff, BeanNameAware {
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

    // Before creating the object this method was called
    @Override
    public void setBeanName(String name) {
        System.out.println("Set Bean method is calling");
    }

    @PostConstruct
    public void postConstruct()
    {
        System.out.println("Post Construct Method is Called");
    }
/*
    Set Bean method is calling
    Post Construct Method is Called*/
}
