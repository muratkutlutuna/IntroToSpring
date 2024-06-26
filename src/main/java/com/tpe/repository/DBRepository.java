package com.tpe.repository;

import com.tpe.domain.Message;
import org.springframework.stereotype.Component;

@Component
public class DBRepository implements Repository{
    @Override
    public void save(Message message) {
        System.out.println("Your message has been saved to Database: "+message.getMessage());
    }
}
