package com.ibrahim.aop.api;

import com.ibrahim.aop.service.MessageService;
import com.ibrahim.aop.service.MessageService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageApi {

    @Autowired //messageApi yaratildiginda zaten var olan messageService nesnesini bu nesneye bagla yani ioc
    private MessageService messageService;

    //ya autowired ya da final ile birlikte @RequiredArgsConstructor kullanman lazim
    //nesne bu sekilde yaratilir ve surekli ayni nesneyi kullanmis oluruz


    @Autowired
    private MessageService2 messageService2;

    @PostMapping
    public ResponseEntity<String> getAll(@RequestBody String message){
        messageService2.message(message);
        return ResponseEntity.ok(messageService.getMessage(message));
    }

}
