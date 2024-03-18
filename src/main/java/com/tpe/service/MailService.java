package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.DBRepository;
import com.tpe.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component("mailService") // when ComponentScanner scans POJO classes, it creates one instance from this class
// default bean name for this class is "mailService"
//@Scope(value="singleton")//by default the value is singleton which means only one instance will be created
//whenever we call the obj it will return us the same obj
@Scope(value="prototype")//creates new obj whenever we request the obj from the class
public class MailService implements MessageService{

    @Autowired
    private Random random;


    //there are three ways of DI


    //1st Field Injection
//    @Autowired // when spring creates an instance from MailService, it will inject Repository
//    @Qualifier("fileRepository")
//    private Repository repository; // null

    //2nd way: Setter Injection
//    private Repository repository;
//    @Autowired
//    @Qualifier("fileRepository")
//    public void setRepository(Repository repository){
//        this.repository = repository;
//    }

    //3rd way: Constructor Injection
    //this way is suggested because:
        //it is more secure
        //when you write test, it will be easy
        //easy to read
    private Repository repository;
    @Autowired
    public MailService(@Qualifier("fileRepository") Repository repository){
        this.repository = repository;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("I am mail service. I am sending this message: "+ message.getMessage());
    }

    @Override
    public void saveMessage(Message message) {
        repository.save(message);
    }

    public void createRandom() {
//        Random random = new Random();
        System.out.println(random.nextInt(100));
    }


}
