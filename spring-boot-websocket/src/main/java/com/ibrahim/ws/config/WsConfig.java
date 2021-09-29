package com.ibrahim.ws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration //bu bir konfigurasyon dosyasidir
@EnableWebSocketMessageBroker //Web socket broker enable edildi
public class WsConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
        //setAllowedOrigins(*) tum gelen istekleri kabul et demek
        //sockJs i enable et
        //biz mesajlarimizi bu endpoint uzerinden gonderecegiz yani chat uzerinden
        //mesela aktif olup olmadiklarini tutan bir endpoints yayinlayabilirdik
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); //biz mesajlarimizi topic uzerinden dinleyecegiz
    }
}
