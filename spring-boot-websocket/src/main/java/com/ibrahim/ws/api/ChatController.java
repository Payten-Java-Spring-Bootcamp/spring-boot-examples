package com.ibrahim.ws.api;

//endpoint in fonksiyonalitesi burada tanimlanacak

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
//component demende ayni sey, ama controller disariya acilan kapi demek, component ise instance yarat demek
@CrossOrigin
public class ChatController {

    @Autowired //instance i var zaten al o instance i
    private SimpMessagingTemplate simpMessagingTemplate; //biz bir yere gondermeyi bu class ile yapacagiz asagidaki annotation lar ile yapmayacagiz

    @MessageMapping("/chat") //disaridan gelen mesajlar
    //@SendTo("/topic") herkese yolla kanali parametre olarak alir
    //@SendToUser bir user a yolla, user parametresi alir, broadcast parametresi aktif olursa gene tum kullanicilara gider
    public void chatEndpoint(@Payload WsMessage wsMessage){ //Payload body de mesaj var demek
        System.out.println(wsMessage);
        simpMessagingTemplate.convertAndSend("/topic",wsMessage); //tum client lara mesaj yolla
    }
}
