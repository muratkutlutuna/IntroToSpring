package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration //this will be my configuration class
@ComponentScan("com.tpe") //by defult it will scan all the paralel package(current package and all of its sub-packages.)
//to be able to scan my POJO classes and creates one instance from each and puts them inside spring container
public class AppConfiguration {

    @Bean //creates bean from Random class, and puts inside a container
    //@Bean is used to create bean for existing classes
    public Random randomInteger(){
        return new Random();
    }

}
