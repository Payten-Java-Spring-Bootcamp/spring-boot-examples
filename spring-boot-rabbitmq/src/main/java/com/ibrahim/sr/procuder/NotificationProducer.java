package com.ibrahim.sr.procuder;

import com.ibrahim.sr.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service //otomatik ayaga kaldir, bir instance ini olustur. ben bunu kullanacagim
public class NotificationProducer {

    @Value("${sr.rabbit.routing.name}")
    private String bindingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct //direkt calis
    public void init(){
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Ibrahim Bu isi yapacaksin!");
        notification.setSeen(Boolean.FALSE);
        sendToQueue(notification);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate; //conneciton nesnesi

    public void sendToQueue(Notification notification){
        System.out.println("Notification Send ID:"+ notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName, bindingName, notification);
    }
}
