package com.tpe.main;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class MyApplication {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMessage("Your order has been shipped...");

        // this is how we did in core Java...
//        MessageService mailService = new MailService();
//        mailService.sendMessage(message);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

//        MailService mailService1 = context.getBean(MailService.class);
//        MessageService mailService1 = context.getBean("mailService",MessageService.class); //Spring is smart enough that it finds the
        // concrete class which extends from interface
//        mailService1.sendMessage(message);
        //we get method from MailService class, without using new keyword
//        MessageService smsService1 = context.getBean("smsService",MessageService.class);
//        smsService1.sendMessage(message);

        //new instance for save method
//        MessageService mailService2 = context.getBean("mailService",MessageService.class);
//        mailService2.sendMessage(message);
//        mailService2.saveMessage(message);
        //we didn't create a new zoomService by writing "new", we just asked for it!
        //we also didn't create a new repository for our service. It also come along with it :)

//        MailService mailService3 = context.getBean(MailService.class);
//        mailService3.createRandom();

        //
        MessageService service4 = context.getBean(MailService.class);
        MessageService service5 = context.getBean(MailService.class);

        if (service4 == service5) {
            System.out.println("They are the same object");
        } else {
            System.out.println("They are not the same object");
        }
        System.out.println("service4 = " + service4);
        System.out.println("service5 = " + service5);

//        if (service4.equals(service5)) {
//            System.out.println("They are the same object");
//            System.out.println("service4 = " + service4);
//            System.out.println("service5 = " + service5);
//        } else {
//            System.out.println("They are not the same object");
//            System.out.println("service4 = " + service4);
//            System.out.println("service5 = " + service5);
//        }

        SmsService service3 = context.getBean(SmsService.class);
        service3.createRandom();
        service3.sendMessage(message);
        service3.printContact();
        service3.printProperties();

        //how to see all beans that are created with Spring Container
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName :
                beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        context.close();//this will destroy the beans created
    }
}
