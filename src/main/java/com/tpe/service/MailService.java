package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component // when ComponentScanner scans POJO classes , it creates one instance from this class
public class MailService implements MessageService{

    @Override
    public void sendMessage(Message message) {
        System.out.println("I am mail service. I am sending this message: "+ message.getMessage());
    }
}
