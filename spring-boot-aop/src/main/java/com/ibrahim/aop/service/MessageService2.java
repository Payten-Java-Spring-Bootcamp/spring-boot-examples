package com.ibrahim.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService2 {
    public void message(String param){
        System.out.println(param);
    }
}
