package org.zahimuslim;

import org.springframework.stereotype.Component;

import javax.print.Doc;

// we are telling spring that this is a component and can be used to create a componenet out of
// this will fail if we dont mention this in the spring.xml file.

@Component
public class Doctor implements Staff{

    //over here we are injecting using constructor injection.
    //         <constructor-arg value="MBBS"></constructor-arg>
/*public Doctor(String qualification){
    this.qualification = qualification;
}*/
    /*
    We are going to get another property called qualification
    now spring doesnt know about this property and we have getters and
    setters for it, so its simply is going to put null for it.

e values to it we can go it from the xml file itself

     */


    /*

    This is for setter injection

            <property name="qualification" value="MBBS"></property>

     */

    private String qualification;



    public void assist()
    {
        System.out.println("Doctor is assisting");
    }


    //I am commenting this out while trying to learn about annotination for simplifiction
   /* public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }*/


    /*
    Okay for simplicity sake we are going to create a nurse object over here and get it injected
     */

    /*This was only for a demo if you want to see how we are injecting
            using id's just look at the spring.xml file*/

   /* private Nurse nurse;

    public Nurse getNurse() {
        return nurse;
    }

    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }*/

   // 26-09-24

//   we are going to add a constructor to the doctor class and we shall inject it from spring.xml

    public Doctor(String qualification) {
        this.qualification = qualification;
    }


    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
