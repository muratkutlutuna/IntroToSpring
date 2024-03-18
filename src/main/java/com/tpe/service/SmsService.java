package com.tpe.service;

import com.tpe.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class SmsService implements MessageService{
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
}
