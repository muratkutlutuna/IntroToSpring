package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;

@Configuration //this will be my configuration class
@ComponentScan("com.tpe") //by defult it will scan all the paralel package(current package and all of its sub-packages.)
//to be able to scan my POJO classes and creates one instance from each
// and puts them inside spring container

@PropertySource("classpath:application.properties")// annotation to specify the location file that contains
                                                    // key-value pairs to be used in your application
public class AppConfiguration {
    @Autowired
    private Environment environment; //to read application.properties file
                                        // we use Environment Interface fro, Spring framework
//The Environment interface provides a number of methods for accessing properties, such as getProperty()

    @Bean //creates bean from Random class, and puts inside a container
    //@Bean is used to create bean for existing classes
    public Random randomInteger(){
        return new Random();
    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.setProperty("email", environment.getProperty("app.email"));
        properties.setProperty("phone", environment.getProperty("app.phone"));
        return properties;
    }

}
