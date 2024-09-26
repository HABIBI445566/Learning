package org.zahimuslim;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.zahimuslim") // I am telling the class where to search the components
public class BeanConfig {
//    this is a configuration class
    // It scans the components in those packages and makes those objects for us

    public Doctor doctor()
    {
          return new  Doctor();
    }
}
