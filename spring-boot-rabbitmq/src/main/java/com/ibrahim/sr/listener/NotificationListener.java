package com.ibrahim.sr.listener;

import com.ibrahim.sr.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service //otomatik ayaga kaldir, bir instance ini olustur. ben bunu kullanacagim
public class NotificationListener {

    @RabbitListener(queues = "ibrahim-queue") //bu kuyruktan mesaj dinle
    public void handleMessage(Notification notification){
        System.out.println("message received");
        System.out.println(notification.toString());
    }
}
