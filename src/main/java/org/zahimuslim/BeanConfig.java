package org.zahimuslim;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.zahimuslim")
@EnableAspectJAutoProxy
public class BeanConfig {
}
