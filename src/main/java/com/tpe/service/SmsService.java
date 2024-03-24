package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Properties;
import java.util.Random;

/**
 * In Java, "@PostConstructor" and "@PreDestroy" are lifecycle annotations that are used to specify methods
 * that should be called after an object is constructed and before it is destroyed, respectively.
 * These annotations are used in conjunction with the Java EE container to perform specific actions in the
 * lifecycle of a managed bean
 */
@Component
public class SmsService implements MessageService{

    /**
     * "@PostConstruct" is a Java annotation used to specify a method that needs to be executed after an object
     * is constructed and all of its dependencies have been injected
     */
    @PostConstruct
    public void init() {
        System.out.println("SMS Service Object is created...");
    }

    /**
     * "@PreDestroy" is used to annotate a method that needs to be executed just before the bean is destroyed
     * by the container. This method is typically used to release any resources held by the bean before it is destroyed
     */
    @PreDestroy
    public void Destroy() {
        System.out.println("SMS Service Object is destroyed...");
    }

    @Autowired
    private Random random;
    @Override
    public void sendMessage(Message message) {
        System.out.println("I am SMS service. I am sending this message: "+ message.getMessage());

    }

    @Override
    public void saveMessage(Message message) {

    }


    public void createRandom() {
//        Random random = new Random();
        System.out.println(random.nextInt(100));
    }





    //if you want to set some values outside in this Class

    //inject the values from properties file using @Value annotation
    @Value("${app.email}")
    private String email;
    @Value("${app.phone}")
    private String phone;
    @Value("${app.website}")
    private String website;

    public void printContact(){
//        System.out.println("email : email@gmail.com");
//        System.out.println("phone : 32423453453534");

        System.out.println("email : "+email+" -- phone : "+phone);
        System.out.println("website = " + website);
    }
    @Autowired
    private Properties properties;
    public void printProperties(){
        System.out.println("Contact email : "+ properties.get("email"));
        System.out.println("Contact phone : "+ properties.get("phone"));
    }



}
