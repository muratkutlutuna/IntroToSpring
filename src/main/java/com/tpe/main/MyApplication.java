package com.tpe.main;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.service.MailService;
import com.tpe.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

//        MailService mailService3 = context.getBean(MailService.class);
//        mailService3.createRandom();

        //
        MessageService service4 = context.getBean(MailService.class);
        MessageService service5 = context.getBean(MailService.class);

        if (service4 == service5) {
            System.out.println("They are the same object");
            System.out.println("service4 = " + service4);
            System.out.println("service5 = " + service5);
        } else {
            System.out.println("They are not the same object");
            System.out.println("service4 = " + service4);
            System.out.println("service5 = " + service5);
        }

        if (service4.equals(service5)) {
            System.out.println("They are the same object");
            System.out.println("service4 = " + service4);
            System.out.println("service5 = " + service5);
        } else {
            System.out.println("They are not the same object");
            System.out.println("service4 = " + service4);
            System.out.println("service5 = " + service5);
        }

        //TODO differences between singleton and prototype will be explained
        //




        context.close();//this will destroy the beans created
    }
}
